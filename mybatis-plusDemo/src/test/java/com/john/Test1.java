package com.john;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.john.plus.bean.Emp;
import com.john.plus.dao.EmpDao;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;


public class Test1 {

   ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("spring.xml");

   @Test
   public void test01() throws SQLException {
      //测试连接，后续实际不需要使用
      final DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
      final DruidPooledConnection connection = dataSource.getConnection();
      System.out.println(connection);
   }


   @Test
   public void test02(){
      final EmpDao empDao = context.getBean("empDao", EmpDao.class);
      final List<Emp> emp = empDao.selectList(null);
      System.out.println(emp);
   }

   @Test
   public void insert(){
      final EmpDao empDao = context.getBean("empDao", EmpDao.class);
      final Emp e = new Emp();
//      e.setEmpno(8);
      e.setEname("BBB");
      e.setJob("clk");
      e.setMgr("ks");
      e.setHiredate(new Date());
      e.setSal(4000.0d);
      System.out.println(empDao.insert(e));
   }

   @Test
   public void update(){
      final EmpDao empDao = context.getBean("empDao", EmpDao.class);
      final Emp e = new Emp();
      e.setEmpno(1);
      e.setEname("kkk");
      final int i = empDao.updateById(e);
      System.out.println(i);
   }

}
