package com.jeff.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jeff.common.entity.Datagrid;
import com.jeff.entity.User;
import com.jeff.entity.UserVo;
import com.jeff.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/editPwdPage")
    public String editPwdPage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "sys/userEditPwd";
    }

    @RequestMapping("/editPwd")
    @ResponseBody
    public String editUserPwd(String oldPwd, String pwd, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (!user.getPassword().equals(oldPwd)) {
            return "passwordError";
        }
        user.setPassword(pwd);
        if (userService.updateById(user)) {
            return "succeed";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/manager")
    @RequiresPermissions("user:list")
    public String manager(Model model, @RequestParam(required = false) String PageName,
                          @RequestParam(required = false, defaultValue = "glyphicon-list") String PageIcon) {
        model.addAttribute("PageName", PageName);
        model.addAttribute("PageIcon", PageIcon);
        return "sys/user/userList";
    }

    @RequestMapping("/dataGrid")
    @RequiresPermissions("user:list")
    @ResponseBody
    public Object dataGrid(UserVo userVo, Integer page, Integer rows) {
        Page<User> p = new Page<>(page, rows);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (userVo.getLoginName() != null && !"".equals(userVo.getLoginName())) {
            wrapper.like("login_name", userVo.getLoginName());
        }
        if (userVo.getCreatedateStart() != null && !"".equals(userVo.getCreatedateStart())) {
            wrapper.ge("create_time", userVo.getCreatedateStart());
        }
        if (userVo.getCreatedateEnd() != null && !"".equals(userVo.getCreatedateEnd())) {
            wrapper.le("create_time", userVo.getCreatedateEnd());
        }
        IPage<User> selectPage = userService.page(p, wrapper);
        return new Datagrid(selectPage.getRecords(), selectPage.getTotal());
    }

    @RequestMapping("/addPage")
    @RequiresPermissions("user:create")
    public String addPage() {
        return "sys/user/userAdd";
    }

    @RequestMapping("/add")
    @RequiresPermissions("user:create")
    @ResponseBody
    public String add(User user, HttpSession session) {
        User u = userService.getOne(new QueryWrapper<User>().eq("login_name", user.getLoginName()));
        if (null != u) {
            return "alreadyExists";
        }
        User currentUser = (User) session.getAttribute("user");
        if (null != currentUser) {
            user.setCreateName(currentUser.getLoginName());
        }
        user.setCreateTime(new Date());
        if (userService.save(user)) {
            return "success";
        }
        return "error";
    }

    @RequestMapping("/editPage")
    @RequiresPermissions("user:update")
    public String editPage(Model model, Long id) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "sys/user/userEdit";
    }

    @RequestMapping("/edit")
    @RequiresPermissions("user:update")
    @ResponseBody
    public String edit(User user, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (null != currentUser) {
            user.setModifyName(currentUser.getLoginName());
        }
        user.setModifyTime(new Date());
        if (user.getPassword() == null || "".equals(user.getPassword())) {
            User u = userService.getById(user.getId());
            user.setPassword(u.getPassword());
        }
        if (userService.updateById(user)) {
            return "success";
        }
        return "error";
    }

    @RequestMapping("/delete")
    @RequiresPermissions("user:delete")
    @ResponseBody
    public String delete(Long id) {
        if (userService.removeById(id)) {
            return "success";
        }
        return "error";
    }

}