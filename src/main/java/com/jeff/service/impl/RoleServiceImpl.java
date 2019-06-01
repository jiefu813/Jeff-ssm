package com.jeff.service.impl;

import com.jeff.entity.Role;
import com.jeff.mapper.RoleMapper;
import com.jeff.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jeff
 * @createTime 2019-06-01 17:24
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRoleList(Role role) {

        return roleMapper.getRoleList(role);
    }

    @Override
    public boolean save(Role role) {
        return roleMapper.save(role)>0;
    }

    @Override
    public Role getById(Long id) {
        return roleMapper.getById(id);
    }

    @Override
    public boolean updateById(Role role) {
        return roleMapper.updateById(role)>0;
    }

    @Override
    public boolean removeById(Long id) {
        return roleMapper.removeById(id)>0;
    }
}
