package com.jeff.service;


import com.jeff.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    User login(User user);
}
