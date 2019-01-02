package com.xiao.shiro;

import com.xiao.domain.Permission;
import com.xiao.domain.Role;
import com.xiao.domain.User;
import com.xiao.service.PermissionService;
import com.xiao.service.RoleService;
import com.xiao.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
      //1.获取用户user
        User user = (User) principalCollection.getPrimaryPrincipal();
        //2.根据user的id查找其拥有的角色
        List<Role> roles = roleService.findRolesByUserid(user.getId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        if (null != roles && roles.size()!= 0){
            for (Role role: roles) {
                //给用户设置角色
                info.addRole(role.getRole());
                //3.根据角色查找权限
                List<Permission> permissions = permissionService.findPermissionsByRoleid(role.getId());
                if (null != permissions && permissions.size() != 0){
                    for (Permission permission: permissions) {
                        info.addStringPermission(permission.getUrl());
                    }
                }
            }
        }
        return info;
    }
   //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //1.根据用户名查找用户
        User user = userService.findUserByName(token.getUsername());
        if (user == null){
            return null;
        }
        //2.根据用户信息查找出密码
        String password = user.getPassword();
        //3,根据用户信息查找出密码对应的盐
        String salt = user.getSalt();
        AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(salt),this.getName());
        return info;

    }

}
