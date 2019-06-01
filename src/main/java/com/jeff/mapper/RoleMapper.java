package com.jeff.mapper;

import com.jeff.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Jeff
 * @createTime 2019-06-01 17:24
 */
public interface RoleMapper {
    List<Role> getRoleList(Role role);
    @Insert("insert into role values(default,#{name},#{status},#{seq},#{createTime},#{createName},#{modifyTime},#{modifyName})")
    int save(Role role);
    @Select("select * from role where id=#{id}")
    Role getById(Long id);
    @Update("update role set name=#{name},status=#{status},seq=#{seq},modify_time=#{modifyTime},modify_name=#{modifyName} where id=#{id}")
    int updateById(Role role);
    @Delete("delete from role where id=#{id}")
    int removeById(Long id);
}
