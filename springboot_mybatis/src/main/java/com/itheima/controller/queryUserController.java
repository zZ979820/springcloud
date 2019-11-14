package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class queryUserController {

    @Autowired
    private userMapper um;
    @RequestMapping("/query")
    public List<User> queryUserList(){
        List<User> user = um.queryUserList();
        return user;
    }
    
}
