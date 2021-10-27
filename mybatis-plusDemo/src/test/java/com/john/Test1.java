package com.john;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.john.plus.bean.Emp;
import com.john.plus.dao.EmpDao;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
      e.setEmpno(17);
      e.setJob("clk");
      e.setMgr("ks");
      e.setHiredate(new Date());
      e.setSal(4000.0d);
      System.out.println(empDao.insert(e));
   }
   @Test
   public void update02(){
      final EmpDao empDao = context.getBean("empDao", EmpDao.class);
      final Emp e = new Emp();
      e.setEmpno(1);
      e.setEname("DFSDF");
      e.setJob("clk");
      e.setMgr("ks");
      e.setVersion(2);
      System.out.println(empDao.updateById(e));
   }
   @Test
   public void update03(){
      final EmpDao empDao = context.getBean("empDao", EmpDao.class);
      final Emp e = new Emp();
      e.setSal(1000.0);
      e.setVersion(2);
      System.out.println(empDao.update(e, null));
   }

   @Test
   public void update(){
      final EmpDao empDao = context.getBean("empDao", EmpDao.class);
      final Emp e = new Emp();
      e.setEmpno(10);
      e.setEname("kkk");
      final int i = empDao.updateById(e);
      System.out.println(i);
   }

   @Test
   public void delete(){
      final EmpDao empDao = context.getBean("empDao", EmpDao.class);
      final Emp e = new Emp();
      e.setEmpno(1);
      e.setEname("kkk");
//      final int i = empDao.delete(new QueryWrapper<Emp>(e));
      final HashMap<String, Object> map = new HashMap<>();
      map.put("empno", "1");
      map.put("ename", "BBB");
      System.out.println(empDao.deleteByMap(map));
   }

   @Test
   public void select(){
      final EmpDao empDao = context.getBean("empDao", EmpDao.class);
      final Emp e = new Emp();
      e.setEmpno(1);
      e.setEname("BBB");
      final List<Map<String, Object>> maps = empDao.selectMaps(new QueryWrapper<>(e, "sal", "comm", "deptno"));
      System.out.println(maps);

      final HashMap<String, Object> map = new HashMap<>();
      map.put("empno", "2");
      map.put("ename", "lisi");
      System.out.println(empDao.selectByMap(map));

   }

   @Test
   public void query(){
      final EmpDao empDao = context.getBean("empDao", EmpDao.class);
      final Emp query = empDao.query(1);
      System.out.println(query);
      System.out.println("-----------");
      //current 2 当前需要查询的页码， size：3 一页数据量   queryWrapper查询条件
      final Page<Emp> empPage = empDao.selectPage(new Page<Emp>(2, 3), null);
      for (Emp record : empPage.getRecords()) {
         System.out.println(record);
      }

   }



}
