package com.john.mb.dao;

import com.john.mb.bean.Dog;

import java.util.List;

public interface DogDao {
    Dog selectById(Integer id);
}
