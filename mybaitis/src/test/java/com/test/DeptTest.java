package com.test;

import com.john.mb.bean.Dept;
import com.john.mb.dao.DeptDao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class DeptTest {

   private SqlSessionFactory mSessionFactory;

   @Before
   public void init(){
      try {
         final InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
         mSessionFactory = new SqlSessionFactoryBuilder().build(resource);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Test
   public void test01(){
      final SqlSession sqlSession = mSessionFactory.openSession();
      final DeptDao mapper = sqlSession.getMapper(DeptDao.class);
      final Dept dept = mapper.selectById(20);
      System.out.println(dept);
      sqlSession.close();
   }
   @Test
   public void test02(){
      final SqlSession sqlSession = mSessionFactory.openSession();
      final DeptDao mapper = sqlSession.getMapper(DeptDao.class);
      final Dept dept = mapper.selectById2(20);
      System.out.println(dept.getDeptname());
      sqlSession.close();
   }
}
