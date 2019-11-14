package com.itheima.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class quickController {

    @Value("${name}")
    private String name;
    @Value("${person.sex}")
    private String sex;
    @Value("${server.port}")
    private String port;


    @RequestMapping("/quick")
    public String quick() {

        return "name="+name+",sex="+sex+",port="+port;
    }
}
