package com.test;

import com.john.bean.Emp;
import com.john.dao.EmpMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Test01 {

   @Test
   public void test01() throws Exception{
      List<String> warnings = new ArrayList<String>();
      boolean overwrite = true;
      File configFile = new File("generatorConfig.xml");
      ConfigurationParser cp = new ConfigurationParser(warnings);
      Configuration config = cp.parseConfiguration(configFile);
      DefaultShellCallback callback = new DefaultShellCallback(overwrite);
      MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
      myBatisGenerator.generate(null);
   }

   @Test
   public void test02() throws Exception {
      final InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
      final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
      final SqlSession sqlSession = sqlSessionFactory.openSession();
      final EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
      final List<Emp> emps = mapper.selectAll();
      for (Emp emp : emps) {
         System.out.println(emp);
      }
   }
}
