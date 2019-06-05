package com.jeff.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jeff.entity.RoleMenu;

/**
 * @author Jeff
 * @createTime 2019-06-06 0:15
 */
public interface RoleMenuService extends IService<RoleMenu> {

    boolean updateRoleMenu(Long id, String resourceIds);
}
