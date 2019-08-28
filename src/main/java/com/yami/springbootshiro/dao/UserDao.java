package com.yami.springbootshiro.dao;

import com.yami.springbootshiro.model.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao {
    public User findByUsername(@Param("username") String username);
}

