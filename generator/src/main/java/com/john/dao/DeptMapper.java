package com.john.dao;

import com.john.bean.Dept;
import java.util.List;

public interface DeptMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbg.generated Wed Oct 20 18:23:29 CST 2021
     */
    int insert(Dept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbg.generated Wed Oct 20 18:23:29 CST 2021
     */
    List<Dept> selectAll();
}