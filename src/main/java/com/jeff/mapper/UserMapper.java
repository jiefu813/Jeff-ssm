package com.jeff.mapper;


import com.jeff.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList(Map<String, Object> condition);
    @Select("select * from user where login_name=#{loginName} and password=#{password}")
    User login(User user);
    @Update("update user set password=#{password} where id=#{id}")
    int updatePwd(User user);
    @Insert("insert into user values(default,#{loginName},#{password},#{salt},#{sex},#{status},#{name},#{nickName},#{phone},#{email},#{birthday},#{headimgUrl},#{createTime},#{createName},#{modifyTime},#{modifyName})")
    int save(User user);
    @Select("select * from user where login_name=#{loginName}")
    User selectUserByLoginName(String loginName);
    @Update("update user set password=#{password},sex=#{sex},status=#{status},name=#{name},nick_name=#{nickName},phone=#{phone},email=#{email},birthday=#{birthday},headimg_url=#{headimgUrl},modify_time=#{modifyTime},modify_name=#{modifyName} where id=#{id}")
    int updateById(User user);
    @Select("select * from user where id=#{id}")
    User getById(Long id);
    @Delete("delete from user where id=#{id}")
    int removeById(Long id);
}
