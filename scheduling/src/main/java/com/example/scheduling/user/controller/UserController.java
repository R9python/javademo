package com.example.scheduling.user.controller;


import com.example.scheduling.user.entity.User;
import com.example.scheduling.user.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author demo
 * @since 2018-10-28
 */
@RestController
public class UserController {

    @Autowired
    UserMapper mapper;

    @RequestMapping("/user/one")
    public User GetUser() {
        User data = mapper.selectById(1);
        return data;
    }
}
