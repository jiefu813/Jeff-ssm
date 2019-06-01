package com.jeff.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jeff.common.entity.Datagrid;
import com.jeff.entity.Role;
import com.jeff.entity.User;
import com.jeff.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author Jeff
 * @createTime 2019-06-01 17:25
 */
@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "manager")
    public String manager(Model model, @RequestParam(required = false) String PageName,
                          @RequestParam(required = false, defaultValue = "glyphicon-list") String PageIcon) {
        model.addAttribute("PageName", PageName);
        model.addAttribute("PageIcon", PageIcon);
        return "sys/role/roleList";
    }

    @RequestMapping("/dataGrid")
    @ResponseBody
    public Object dataGrid(Integer page, Integer rows,Role role) {
        PageHelper.startPage(page, rows);
        List<Role> roleList = roleService.getRoleList(role);
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        return new Datagrid(pageInfo.getList(), pageInfo.getTotal());
    }

    @RequestMapping("/addPage")
    public String addPage() {
        return "sys/role/roleAdd";
    }

    @PostMapping("/add")
    @ResponseBody
    public String add(Role role, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (null != user) {
            role.setCreateName(user.getLoginName());
        }
        role.setCreateTime(new Date());
        if (roleService.save(role)) {
            return "success";
        }
        return "error";
    }

    @RequestMapping("/editPage")
    public String editPage(Model model, Long id) {
        Role role = roleService.getById(id);
        model.addAttribute("role", role);
        return "sys/role/roleEdit";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit(Role role,HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (null != user) {
            role.setModifyName(user.getLoginName());
        }
        role.setModifyTime(new Date());
        if (roleService.updateById(role)) {
            return "success";
        }
        return "error";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Long id) {
        if (roleService.removeById(id)) {
            return "success";
        }
        return "error";
    }
}