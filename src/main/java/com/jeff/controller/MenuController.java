package com.jeff.controller;

import com.jeff.common.entity.Datagrid;
import com.jeff.common.entity.Tree;
import com.jeff.entity.Menu;
import com.jeff.service.MenuService;
import com.mysql.cj.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("tree")
    @ResponseBody
    public List<Tree> tree() {

        return menuService.getMenuTree();
    }

    @RequestMapping("manager")
    public String manager(Model model, @RequestParam(required = false) String PageName,
                          @RequestParam(required = false, defaultValue = "glyphicon-list") String PageIcon) {
        model.addAttribute("PageName", PageName);
        model.addAttribute("PageIcon", PageIcon);
        return "sys/menuList";
    }

    @RequestMapping("/treeGrid")
    @ResponseBody
    public Object treeGrid() {

        List<Menu> menuList=menuService.getAllMenu();

        return new Datagrid(menuList,menuList.size());
    }

}
