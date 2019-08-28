package com.yami.springbootshiro.service;

import com.yami.springbootshiro.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    public User findByUsername(@Param("username") String username);
}
