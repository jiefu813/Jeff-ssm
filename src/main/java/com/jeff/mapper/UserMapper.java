package com.jeff.mapper;


import com.jeff.entity.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUserList();
    @Select("select * from user where login_name=#{loginName} and password=#{password}")
    User login(User user);
    @Update("update user set password=#{password} where id=#{id}")
    int updatePwd(User user);
}
