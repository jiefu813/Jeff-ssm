package com.jeff.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeff.entity.User;
import com.jeff.mapper.UserMapper;
import com.jeff.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
