package com.john.mb.dao;

import com.john.mb.bean.Dept;

public interface DeptDao {
  Dept selectById(Integer deptno);
  Dept selectById2(Integer deptno);
}
