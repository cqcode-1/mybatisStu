package com.john.mb.dao;

import com.john.mb.bean.User;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
   @Select("select * from user where id= #{id}")
   User queryById(Integer id);

   Integer save(User user);

   List<User> queryAll();
}
