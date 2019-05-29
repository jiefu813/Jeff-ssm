package com.jeff.service.impl;

import com.jeff.common.entity.Tree;
import com.jeff.entity.Menu;
import com.jeff.mapper.MenuMapper;
import com.jeff.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeff
 * @createTime 2019-05-29 22:44
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Tree> getMenuTree() {
        List<Tree> trees = new ArrayList<Tree>();
        List<Menu> menuList = menuMapper.getAllMenu();
        for (Menu menu : menuList) {
            Tree tree = new Tree();
            tree.setId(menu.getId());
            tree.setPid(menu.getParentId());
            tree.setText(menu.getName());
            tree.setIconCls(menu.getIcon());
            tree.setUrl(menu.getUrl());
            tree.setState(menu.getOpened());
            trees.add(tree);
        }
        return trees;
    }
}
