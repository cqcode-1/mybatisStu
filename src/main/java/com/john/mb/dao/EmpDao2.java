package com.john.mb.dao;

import com.john.mb.bean.Emp;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpDao2 {
  Emp selectByDeptno(Integer e);
  Emp selectByDeptnoStep(Integer e);
  Emp select(Emp emp);
  List<Emp> selectIn(@Param("deptnos") List<Integer> deptnos);

  Integer update(Integer empno);
}
