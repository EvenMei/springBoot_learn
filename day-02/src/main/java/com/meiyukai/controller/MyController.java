package com.meiyukai.controller;

import com.meiyukai.dao.UserMapper;
import com.meiyukai.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/test")
public class MyController {

    @Autowired
    private UserMapper mapper;

    @RequestMapping(value = "/mybatis")
    @ResponseBody
    public List<User> test01(){
    return mapper.findAll();
    }



}
