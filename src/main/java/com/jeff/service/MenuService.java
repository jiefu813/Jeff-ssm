package com.jeff.service;

import com.jeff.common.entity.Tree;
import com.jeff.entity.Menu;

import java.util.List;

/**
 * @author Jeff
 * @createTime 2019-05-29 22:44
 */
public interface MenuService {
    List<Tree> getMenuTree();

    List<Menu> getAllMenu();
}
