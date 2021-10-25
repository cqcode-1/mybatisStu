package com.test;

import com.john.mb.bean.Emp;
import com.john.mb.dao.EmpDao2;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class EmpTest2 {

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
      final EmpDao2 mapper = sqlSession.getMapper(EmpDao2.class);
      final Emp emp = mapper.selectByDeptno(1);
      System.out.println(emp);
      sqlSession.close();
   }

   @Test
   public void test02(){
      final SqlSession sqlSession = mSessionFactory.openSession();
      final EmpDao2 mapper = sqlSession.getMapper(EmpDao2.class);
      final Emp emp = new Emp();
      emp.setEmpno(2);
      emp.setEname("lisi");
      System.out.println(mapper.select(emp));

//      mapper.update(3);
      final Emp emp1 = new Emp();
      emp1.setEmpno(2);
      emp1.setEname("lisi");
      System.out.println(mapper.select(emp1));
      sqlSession.close();

      final SqlSession sqlSession2 = mSessionFactory.openSession();
      final EmpDao2 mapper2 = sqlSession2.getMapper(EmpDao2.class);
      final Emp emp2 = new Emp();
      emp2.setEmpno(2);
      emp2.setEname("lisi");
      System.out.println(mapper2.select(emp2));
      sqlSession2.close();

   }

   @Test
   public void test03(){
      final SqlSession sqlSession = mSessionFactory.openSession();
      final EmpDao2 mapper = sqlSession.getMapper(EmpDao2.class);
      System.out.println(mapper.selectIn(Arrays.asList(10, 20)));
      sqlSession.close();
   }

   @Test
   public void test05(){
      final SqlSession sqlSession = mSessionFactory.openSession();
      final EmpDao2 mapper = sqlSession.getMapper(EmpDao2.class);
      final Emp emp = new Emp();
      emp.setEmpno(1);
      emp.setEname("lisi");
      emp.setSal(1000);
      System.out.println(mapper.select(emp));
      sqlSession.close();
   }
   @Test
   public void test06(){
      final SqlSession sqlSession = mSessionFactory.openSession();
      final EmpDao2 mapper = sqlSession.getMapper(EmpDao2.class);
      final Emp emp = new Emp();
      System.out.println(mapper.selectAll());
      sqlSession.close();
   }
}
