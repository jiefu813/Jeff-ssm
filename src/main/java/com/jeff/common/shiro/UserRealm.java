package com.jeff.common.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jeff.entity.User;
import com.jeff.service.MenuService;
import com.jeff.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Jeff
 * @createTime 2019-06-02 23:00
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("======授权======");
        // 获取身份信息--该身份信息在认证时已设置
        User user = (User) principals.getPrimaryPrincipal();
        // 根据身份信息获取权限数据
        List<String> permsList = menuService.getPermsList(user.getRoleId());
        // 将权限信息保存到AuthorizationInfo中
        if (permsList == null || permsList.size() == 0) {
            return null;
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (String perms : permsList) {
            if (null != perms && !"".equals(perms)) {
                info.addStringPermission(perms);
            }
        }
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("======认证======");
        // 从token 中获取身份信息
        String username = token.getPrincipal().toString();
        // 根据用户名到数据库中取出用户信息如果查询不到返回null
        User user = userService.getOne(new QueryWrapper<User>().eq("login_name", username));
        // 返回认证信息
        return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), this.getName());
    }

    //清理缓存方法
    protected void clearCache() {
        System.out.println("======清理缓存======");
        Subject subject = SecurityUtils.getSubject();
        super.clearCache(subject.getPrincipals());
    }
}
