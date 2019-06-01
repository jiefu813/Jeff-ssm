package com.jeff.mapper;

import com.jeff.entity.Menu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Jeff
 * @createTime 2019-05-29 22:44
 */
public interface MenuMapper {
    @Select("select * from menu where type='MENU'")
    List<Menu> getAllMenu();
    @Select("select * from menu")
    List<Menu> getAllMenuAndButton();
    @Insert("insert into menu values(default,#{name},#{type},#{status},#{parentId},#{opened},#{seq},#{icon},#{url},#{createTime},#{createName},#{modifyTime},#{modifyName})")
    int addMenu(Menu menu);
    @Select("select * from menu where id=#{id}")
    Menu getById(Long id);
    @Update("update menu set type=#{type},name=#{name},url=#{url},parent_id=#{parentId},seq=#{seq},status=#{status},opened=#{opened},icon=#{icon},modify_time=#{modifyTime},modify_name=#{modifyName} where id=#{id}")
    int updateById(Menu menu);
    @Delete("delete from menu where id=#{id}")
    int removeById(Long id);
}
