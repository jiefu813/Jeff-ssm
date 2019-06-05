package com.jeff.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jeff.common.entity.Datagrid;
import com.jeff.entity.Role;
import com.jeff.entity.User;
import com.jeff.service.RoleMenuService;
import com.jeff.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author Jeff
 * @createTime 2019-06-01 17:25
 */
@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleMenuService roleMenuService;

    @RequestMapping(value = "manager")
    public String manager(Model model, @RequestParam(required = false) String PageName,
                          @RequestParam(required = false, defaultValue = "glyphicon-list") String PageIcon) {
        model.addAttribute("PageName", PageName);
        model.addAttribute("PageIcon", PageIcon);
        return "sys/role/roleList";
    }

    @RequestMapping("/dataGrid")
    @ResponseBody
    public Object dataGrid(Integer page, Integer rows, Role role) {
        Page<Role> p = new Page<>(page, rows);
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        if (role.getName() != null && !"".equals(role.getName())) {
            wrapper.like("name", role.getName());
        }
        IPage<Role> selectPage = roleService.page(p, wrapper);
        return new Datagrid(selectPage.getRecords(), selectPage.getTotal());
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
    public String edit(Role role, HttpSession session) {
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

    @RequestMapping("/grantPage")
    public String grantPage(Model model, Long id) {
        model.addAttribute("id", id);
        return "sys/role/roleGrant";
    }

    @RequestMapping("/grant")
    @ResponseBody
    public String grant(Long id, String resourceIds) {
        if (roleMenuService.updateRoleMenu(id, resourceIds)) {
            return "success";
        }
        return "error";
    }
}