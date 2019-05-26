package com.jeff.controller;

import com.jeff.entity.User;
import com.jeff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import java.util.List;

@Controller
public class UserController{

    @Autowired
    private UserService userService;

    @RequestMapping("getUserList")
    @ResponseBody
    public List<User> getUserList(){

        return userService.getUserList();
    }

}
