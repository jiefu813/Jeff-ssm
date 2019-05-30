package com.jeff.controller;

import com.jeff.entity.User;
import com.jeff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.Subject;
import javax.servlet.http.HttpSession;

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
    public String login(User u, HttpSession session){
        User user=userService.login(u);
        if(null!=user){
            session.setAttribute("user",user);
            return "success";
        }
        return "error";
    }

    @RequestMapping("index")
    public  String index(){

        return "sys/index";
    }

    @RequestMapping("/logout")
    public Object logout() {

        return "redirect:loginPage";
    }

}
