package com.jeff.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jeff.common.entity.Datagrid;
import com.jeff.entity.Role;
import com.jeff.entity.User;
import com.jeff.entity.UserVo;
import com.jeff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/editPwdPage")
    public String editPwdPage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
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
        if (userService.updatePwd(user)) {
            return "succeed";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/manager")
    public String manager(Model model, @RequestParam(required = false) String PageName,
                          @RequestParam(required = false, defaultValue = "glyphicon-list") String PageIcon, String flag) {
        model.addAttribute("PageName", PageName);
        model.addAttribute("PageIcon", PageIcon);
        return "sys/user/userList";
    }

    @RequestMapping("/dataGrid")
    @ResponseBody
    public Object dataGrid(UserVo userVo, Integer page, Integer rows, String sort, String order) {
        PageHelper.startPage(page, rows);
        Map<String, Object> condition = new HashMap<String, Object>();
        if (userVo.getLoginName() != null &&!"".equals(userVo.getLoginName())) {
            condition.put("loginName", userVo.getLoginName());
        }
        if (userVo.getCreatedateStart() != null&&!"".equals(userVo.getCreatedateStart())) {
            condition.put("startTime", userVo.getCreatedateStart());
        }
        if (userVo.getCreatedateEnd() != null&&!"".equals(userVo.getCreatedateEnd())) {
            condition.put("endTime", userVo.getCreatedateEnd());
        }
        List<User> userList = userService.getUserList(condition);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return new Datagrid(pageInfo.getList(), pageInfo.getTotal());
    }

    @RequestMapping("/addPage")
    public String addPage() {
        return "sys/user/userAdd";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(User user, HttpSession session) {
        int count = userService.selectCountByLoginName(user.getLoginName());
        if (count > 0) {
            return "alreadyExists";
        }
        User u = (User) session.getAttribute("user");
        if (null != u) {
            user.setCreateName(u.getLoginName());
        }
        user.setCreateTime(new Date());
        if (userService.save(user)) {
            return "success";
        }
        return "error";
    }

    @RequestMapping("/editPage")
    public String editPage(Model model, Long id) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "sys/user/userEdit";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit(User user, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (null != currentUser) {
            user.setModifyName(currentUser.getLoginName());
        }
        user.setModifyTime(new Date());
        if(user.getPassword()==null||"".equals(user.getPassword())){
            User u = userService.getById(user.getId());
            user.setPassword(u.getPassword());
        }
        if (userService.updateById(user)) {
            return "success";
        }
        return "error";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Long id) {
        if (userService.removeById(id)) {
            return "success";
        }
        return "error";
    }

}