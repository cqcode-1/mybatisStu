package com.john.mb.dao;

import com.john.mb.bean.Dog;

public interface DogDao {
    Dog selectById(Integer id);
}
