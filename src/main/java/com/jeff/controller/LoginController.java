package com.jeff.controller;

import com.jeff.entity.User;
import com.jeff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jeff
 * @createTime 2019-05-28 20:03
 */

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("loginPage")
    public String loginPage(){

        return "sys/login";
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(User u){
        User user=userService.login(u);
        if(null!=user){
            return "success";
        }
        return "error";
    }

    @RequestMapping("index")
    public  String index(){

        return "sys/index";
    }

}
