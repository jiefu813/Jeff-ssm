package com.jeff.controller;

import com.jeff.common.entity.Datagrid;
import com.jeff.common.entity.Tree;
import com.jeff.entity.Menu;
import com.jeff.entity.User;
import com.jeff.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
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
        return "sys/menu/menuList";
    }

    @RequestMapping("treeGrid")
    @ResponseBody
    public Object treeGrid() {

        List<Menu> menuList = menuService.getAllMenu();

        return new Datagrid(menuList, menuList.size());
    }

    @RequestMapping("addPage")
    public String addPage() {
        return "sys/menu/menuAdd";
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(Menu menu, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (null != user) {
            menu.setCreateName(user.getLoginName());
        }
        menu.setCreateTime(new Date());
        if (menuService.save(menu)) {
            return "success";
        }
        return "error";
    }

    @RequestMapping("/editPage")
    public String editPage(Model model, Long id) {
        Menu menu = menuService.getById(id);
        model.addAttribute("menu", menu);
        return "sys/menu/menuEdit";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit(Menu menu,HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (null != user) {
            menu.setModifyName(user.getLoginName());
        }
        menu.setCreateTime(new Date());
        if(menuService.updateById(menu)){
            return "success";
        }
        return "error";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Long id) {
        if(menuService.removeById(id)){
            return "success";
        }
        return "error";
    }

}
