package com.jeff.service;

import com.jeff.entity.Role;

import java.util.List;

/**
 * @author Jeff
 * @createTime 2019-06-01 17:24
 */
public interface RoleService {
    List<Role> getRoleList(Role role);

    boolean save(Role role);

    Role getById(Long id);

    boolean updateById(Role role);

    boolean removeById(Long id);
}
