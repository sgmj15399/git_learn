package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

/**
 * @author mj
 */
public class UserServiceImpl implements UserService {

    @Override
    public User findById(Integer id) {
        return new User(id, "MYRPC");
    }
}
