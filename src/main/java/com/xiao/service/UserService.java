package com.xiao.service;

import com.xiao.domain.Permission;
import com.xiao.domain.User;

import java.util.List;

public interface UserService {
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findUserByName(String username);

    /**
     * 根据用户信息查找对应的权限
     * @param user
     * @return
     */
    public List<Permission> findPermissionListByUser(User user);
}
