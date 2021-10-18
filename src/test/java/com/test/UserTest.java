package com.test;

import com.john.mb.bean.User;
import com.john.mb.dao.UserDao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {

   private SqlSessionFactory mSqlSessionFactory;

   @Before
   public void init(){
      String res = "mybatis-config.xml";
      try {
         InputStream resource = Resources.getResourceAsStream(res);
         mSqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Test
   public void test1(){
      try(SqlSession sqlSession = mSqlSessionFactory.openSession()){
         UserDao mapper = sqlSession.getMapper(UserDao.class);
         User user = mapper.queryById(1);
         System.out.println(user);
      }
   }
   @Test
   public void test02(){
      try(SqlSession sqlSession = mSqlSessionFactory.openSession(true)){
         UserDao mapper = sqlSession.getMapper(UserDao.class);
         User user = new User();
         user.setUserName("jded");
         Integer result = mapper.save(user);
         System.out.println(user);
         System.out.println(result);
      }
   }

   @Test
   public void test03(){
      try(final SqlSession sqlSession = mSqlSessionFactory.openSession()){
         final UserDao mapper = sqlSession.getMapper(UserDao.class);
         final List<User> users = mapper.queryAll();
         System.out.println(users);
      }
   }
}
