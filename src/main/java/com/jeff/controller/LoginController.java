package com.jeff.controller;

import com.jeff.entity.User;
import com.jeff.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author Jeff
 * @createTime 2019-05-28 20:03
 */

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    //登陆页面
    @RequestMapping("loginPage")
    public String loginPage() {

        return "sys/login";
    }

    //登陆
    @PostMapping("login")
    @ResponseBody
    public String login(User u) {
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(u.getLoginName(), u.getPassword());
        //记住我
        token.setRememberMe(true);
        try {
            user.login(token);
            return "success";
        } catch (UnknownAccountException e) {
            return "accountNotExist ";
        } catch (DisabledAccountException e) {
            return "accountNotEnabled";
        } catch (IncorrectCredentialsException e) {
            return "passwordError";
        } catch (Throwable e) {
            return "error";
        }
    }

    @RequestMapping(value = {"/", "index"})
    public String index(HttpSession session) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        session.setAttribute("user", user);
        return "sys/index";
    }

}