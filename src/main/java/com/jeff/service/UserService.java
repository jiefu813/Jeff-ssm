package com.jeff.service;


import com.jeff.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> getUserList(Map<String, Object> condition);

    User login(User user);

    boolean updatePwd(User user);

    User selectUserByLoginName(String loginName);

    boolean save(User user);

    boolean updateById(User user);

    User getById(Long id);

    boolean removeById(Long id);
}
