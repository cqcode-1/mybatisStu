package com.john.mb.dao;

import com.john.mb.bean.Emp;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpDao {
 Integer save(Emp emp);
 int update(Emp emp);
 int delete(int empno);
 Emp selectById(int empno);
 Emp selectById(String t, int empno);
 List<Emp> selectByIdAndSal(Emp emp);
 List<Emp> selectAll();
 List<Emp> selectMS(@Param("sss") int sss, @Param("ccc") int ccc);
 List<Emp> selectByMap(Map<String, Object> emp);
 Map<Object, Object> selectById2(int empno);

 @MapKey("empno")
 Map<String, Emp> selectAll2();
}
