package com.test;

import com.john.mb.bean.Emp;
import com.john.mb.bean.User;
import com.john.mb.dao.EmpDao;
import com.john.mb.dao.UserDao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class EmpTest {
   SqlSessionFactory sqlSessionFactory = null;
   @Before
   public void init(){
      String resource = "mybatis-config.xml";
      InputStream inputStream = null;
      try {
         inputStream = Resources.getResourceAsStream(resource);
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Test
   public void test01() throws IOException {

      try (SqlSession session = sqlSessionFactory.openSession()) {
         System.out.println("---------:" + session.getConnection());
         EmpDao mapper = session.getMapper(EmpDao.class);
         Emp emp = mapper.selectById(1);
         System.out.println(emp);
      }
   }
   @Test
   public void test011() throws IOException {

      try (SqlSession session = sqlSessionFactory.openSession()) {
         System.out.println("---------:" + session.getConnection());
         EmpDao mapper = session.getMapper(EmpDao.class);
         Emp emp = mapper.selectById("emp",1);
         System.out.println(emp);
      }
   }
   @Test
   public void test012() throws IOException {

      try (SqlSession session = sqlSessionFactory.openSession()) {
         System.out.println("---------:" + session.getConnection());
         EmpDao mapper = session.getMapper(EmpDao.class);
         List<Emp> emps = mapper.selectMS(1000, 200);
         System.out.println(emps);
      }
   }

   @Test
   public void test02() throws IOException {
      try (SqlSession session = sqlSessionFactory.openSession()) {
         EmpDao empDao = session.getMapper(EmpDao.class);
         Emp emp = new Emp();
         emp.setEmpno(4);
         emp.setEname("dxkg");
         Integer save = empDao.save(emp);
         session.commit();
         System.out.println(save);
      }
   }
   @Test
   public void test03() throws IOException {
      try (SqlSession session = sqlSessionFactory.openSession()) {
         EmpDao empDao = session.getMapper(EmpDao.class);
         Emp emp = new Emp();
         emp.setEmpno(4);
         emp.setEname("dxkg");
         emp.setSal(300);
         Integer save = empDao.update(emp);
         session.commit();
         System.out.println(save);
      }
   }

   @Test
   public void test04() throws IOException {
      try (SqlSession session = sqlSessionFactory.openSession()) {
         EmpDao empDao = session.getMapper(EmpDao.class);
         Integer save = empDao.delete(4);
         session.commit();
         System.out.println(save);
      }
   }

   @Test
   public void test05() throws IOException {
      try (SqlSession session = sqlSessionFactory.openSession()) {
         UserDao userDao = session.getMapper(UserDao.class);
         User user = userDao.queryById(1);
         session.commit();
         System.out.println(user);
      }
   }
   @Test
   public void test06() throws IOException {
      try (SqlSession session = sqlSessionFactory.openSession()) {
         EmpDao empDao = session.getMapper(EmpDao.class);
         List<Emp> emps = empDao.selectAll();
         System.out.println(emps.toString());
      }
   }
   @Test
   public void test13(){
      try(final SqlSession sqlSession = sqlSessionFactory.openSession()){
         final EmpDao mapper = sqlSession.getMapper(EmpDao.class);
         final Emp emp = new Emp();
         emp.setEmpno(1);
         emp.setSal(500);
         final List<Emp> result = mapper.selectByIdAndSal(emp);
         System.out.println(result);
      }
   }

   @Test
   public void test14(){
      try(final SqlSession sqlSession = sqlSessionFactory.openSession()){
         final EmpDao mapper = sqlSession.getMapper(EmpDao.class);
         final Hashtable<String, Object> map = new Hashtable<>();
         map.put("e", 2);
         map.put("s", 300);
         final List<Emp> result = mapper.selectByMap(map);
         System.out.println(result);
      }
   }

   @Test
   public void test15(){
      try {
         final InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
         final SqlSessionFactory s = new SqlSessionFactoryBuilder().build(resource);
         final SqlSession sqlSession = s.openSession();
         final EmpDao mapper = sqlSession.getMapper(EmpDao.class);
         final Map<Object, Object> objectObjectMap = mapper.selectById2(1);
         System.out.println(objectObjectMap);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Test
   public void test16(){
      try(final SqlSession sqlSession = sqlSessionFactory.openSession()){
         final EmpDao mapper = sqlSession.getMapper(EmpDao.class);
         final Map<String, Emp> stringEmpMap = mapper.selectAll2();
         System.out.println(stringEmpMap);
      }
   }
}
