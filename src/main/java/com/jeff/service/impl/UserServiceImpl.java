package com.jeff.service.impl;

import com.jeff.entity.User;
import com.jeff.mapper.UserMapper;
import com.jeff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList(Map<String, Object> condition) {

        return userMapper.getUserList(condition);
    }

    @Override
    public User login(User user) {

        return userMapper.login(user);
    }

    @Override
    public boolean updatePwd(User user) {

        return userMapper.updatePwd(user)>0;
    }

    @Override
    public User selectUserByLoginName(String loginName) {

        return userMapper.selectUserByLoginName(loginName);
    }

    @Override
    public boolean save(User user) {
        return userMapper.save(user)>0;
    }

    @Override
    public boolean updateById(User user) {
        return userMapper.updateById(user)>0;
    }

    @Override
    public User getById(Long id) {
        return userMapper.getById(id);
    }

    @Override
    public boolean removeById(Long id) {
        return userMapper.removeById(id)>0;
    }
}
