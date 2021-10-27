package com.john.plus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.john.plus.bean.Emp;

public interface EmpDao extends BaseMapper<Emp> {

    Emp query(Integer empno);
}
