package com.jeff.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeff.entity.RoleMenu;
import com.jeff.mapper.RoleMenuMapper;
import com.jeff.service.RoleMenuService;
import org.springframework.stereotype.Service;

/**
 * @author Jeff
 * @createTime 2019-06-06 0:15
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

    @Override
    public boolean updateRoleMenu(Long roleId, String menuIds) {
        // 先删除后添加
        remove(new QueryWrapper<RoleMenu>().eq("role_id", roleId));
        // 如果资源id为空，判断为清空角色资源
        if (null == menuIds || "".equals(menuIds)) {
            return true;
        }
        String[] menuIdArray = menuIds.split(",");
        for (String menuId : menuIdArray) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(Long.parseLong(menuId));
            if (!save(roleMenu)) {
                return false;
            }
        }
        return true;
    }
}
