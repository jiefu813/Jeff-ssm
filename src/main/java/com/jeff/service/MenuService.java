package com.jeff.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jeff.common.entity.Tree;
import com.jeff.entity.Menu;

import java.util.List;

/**
 * @author Jeff
 * @createTime 2019-05-29 22:44
 */
public interface MenuService extends IService<Menu> {

    List<Tree> getMenuTree();

    List<Menu> getMenuList(Long roleId);

    List<Tree> getAllTreeByRoleId(Long roleId);
}
