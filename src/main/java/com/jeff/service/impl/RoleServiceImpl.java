package com.jeff.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeff.entity.Role;
import com.jeff.mapper.RoleMapper;
import com.jeff.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @author Jeff
 * @createTime 2019-06-01 17:24
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
