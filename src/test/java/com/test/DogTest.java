package com.test;

import com.john.mb.bean.Dog;
import com.john.mb.dao.DogDao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class DogTest {
   SqlSessionFactory sqlSessionFactory = null;
   @Before
   public void init(){
      final InputStream resource;
      try {
         resource = Resources.getResourceAsStream("mybatis-config.xml");
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Test
   public void test01(){
      try ( SqlSession sqlSession = sqlSessionFactory.openSession();){
         final DogDao mapper = sqlSession.getMapper(DogDao.class);
         final Dog dog = mapper.selectById(1);
         System.out.println(dog);
      } catch (Exception e) {
         e.printStackTrace();
      }

   }
}
