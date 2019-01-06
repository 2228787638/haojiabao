package com.haojiabao.controller;

import com.haojiabao.entity.User;
import com.haojiabao.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/index")
    public String index(){
        return "user/index";
    }
    @RequestMapping("/add")
    public String add(){
        User user=new User();
        user.setUsername("2228787638");
        user.setPassword("ygf123456");
        user.setRole(1);
        user.setState(1);
        userService.save(user);
        return "user/index";
    }
}
