package com.john.dao;

import com.john.bean.Emp;
import java.util.List;

public interface EmpMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbg.generated Wed Oct 20 18:23:29 CST 2021
     */
    int deleteByPrimaryKey(Integer empno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbg.generated Wed Oct 20 18:23:29 CST 2021
     */
    int insert(Emp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbg.generated Wed Oct 20 18:23:29 CST 2021
     */
    Emp selectByPrimaryKey(Integer empno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbg.generated Wed Oct 20 18:23:29 CST 2021
     */
    List<Emp> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbg.generated Wed Oct 20 18:23:29 CST 2021
     */
    int updateByPrimaryKey(Emp record);
}