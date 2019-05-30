package com.jeff.mapper;

import com.jeff.entity.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Jeff
 * @createTime 2019-05-29 22:44
 */
public interface MenuMapper {
    @Select("select * from menu where type='RESOURCE_MENU'")
    List<Menu> getAllMenu();
    @Select("select * from menu")
    List<Menu> getAllMenuAndButton();
}
