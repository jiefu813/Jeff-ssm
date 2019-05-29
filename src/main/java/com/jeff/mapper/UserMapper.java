package com.jeff.mapper;


import com.jeff.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUserList();
    @Select("select * from user where login_name=#{loginName} and password=#{password}")
    User login(User user);
}
