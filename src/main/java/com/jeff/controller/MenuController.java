package com.jeff.controller;

import com.jeff.common.entity.Tree;
import com.jeff.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Jeff
 * @createTime 2019-05-29 22:38
 */
@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/tree")
    @ResponseBody
    public List<Tree> tree() {

        return menuService.getMenuTree();
    }

}
