package com.jeff.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeff.common.entity.Tree;
import com.jeff.entity.Menu;
import com.jeff.mapper.MenuMapper;
import com.jeff.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeff
 * @createTime 2019-05-29 22:44
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {


    @Override
    public List<Tree> getMenuTree() {
        List<Tree> trees = new ArrayList<Tree>();
        List<Menu> menuList = list(new QueryWrapper<Menu>().eq("type", "MENU"));
        for (Menu menu : menuList) {
            Tree tree = setMenu(menu);
            trees.add(tree);
        }
        return trees;
    }


    @Override
    public List<Menu> getMenuList(Long roleId) {

        return baseMapper.getMenuList(roleId);
    }

    @Override
    public List<Tree> getAllTreeByRoleId(Long roleId) {
        // 根据角色id获取对应的资源id
        List<Long> menuIds = new ArrayList<>();
        List<Menu> menuList = baseMapper.getMenuList(roleId);
        for (Menu menu : menuList) {
            menuIds.add(menu.getId());
        }
        // 获取所有正常的菜单以tree形式展示
        List<Tree> trees = new ArrayList<Tree>();
        List<Menu> menuAll = list(new QueryWrapper<Menu>().eq("status", "ENABLE").orderByAsc("seq"));
        for (Menu menu : menuAll) {
            Tree tree = setMenu(menu);
            if (null != menuIds && menuIds.size() > 0) {
                if (menuIds.contains(menu.getId())) {
                    if (count(new QueryWrapper<Menu>().eq("parent_id", menu.getId())) == 0) {
                        tree.setChecked(true);
                    }
                }
            }
            trees.add(tree);
        }
        return trees;
    }

    private Tree setMenu(Menu menu) {
        Tree tree = new Tree();
        tree.setId(menu.getId());
        tree.setPid(menu.getParentId());
        tree.setText(menu.getName());
        tree.setIconCls(menu.getIcon());
        tree.setUrl(menu.getUrl());
        tree.setState(menu.getOpened());
        return tree;
    }
}
