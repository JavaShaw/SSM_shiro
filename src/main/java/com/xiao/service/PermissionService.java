package com.xiao.service;

import com.xiao.domain.Permission;

import java.util.List;

public interface PermissionService {
    /**
     * 根据角色id查找对应的权限
     * @param roleid
     * @return
     */
    List<Permission> findPermissionsByRoleid(int roleid);
}
