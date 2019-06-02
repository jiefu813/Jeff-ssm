package com.jeff.common.shiro;

import com.jeff.entity.User;
import com.jeff.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jeff
 * @createTime 2019-06-02 23:00
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 从token 中获取身份信息
        String username = token.getPrincipal().toString();
        // 根据用户名到数据库中取出用户信息如果查询不到返回null
        User user = userService.selectUserByLoginName(username);
        // 返回认证信息
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
    }
}
