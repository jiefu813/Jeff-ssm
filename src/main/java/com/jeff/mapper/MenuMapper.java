package com.jeff.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jeff.entity.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Jeff
 * @createTime 2019-05-29 22:44
 */
public interface MenuMapper extends BaseMapper<Menu> {

    @Select("select * from menu m left join role_menu rm on m.id=rm.menu_id where rm.role_id=#{roleId}")
    List<Menu> getMenuList(Long roleId);
}
