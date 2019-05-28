package com.jeff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jeff
 * @createTime 2019-05-28 20:03
 */

@Controller
public class LoginController {

    @RequestMapping("loginPage")
    public String loginPage(){

        return "sys/login";
    }

}
