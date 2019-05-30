package com.jeff.controller;

import com.jeff.entity.User;
import com.jeff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController{

    @Autowired
    private UserService userService;

    @RequestMapping("getUserList")
    @ResponseBody
    public List<User> getUserList(){

        return userService.getUserList();
    }

    @GetMapping("/editPwdPage")
    public String editPwdPage(Model model, HttpSession session) {
        User user = (User)session.getAttribute("user");
        return "sys/userEditPwd";
    }

    @PostMapping("/editPwd")
    @ResponseBody
    public String editUserPwd(String oldPwd, String pwd,HttpSession session) {
        User user = (User)session.getAttribute("user");
        if (!user.getPassword().equals(oldPwd)) {
            return "passwordError";
        }
        user.setPassword(pwd);
        if(userService.updatePwd(user)){
            return "succeed";
        }else {
            return "error";
        }
    }

}
