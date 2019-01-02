package com.xiao.service;

import com.xiao.domain.Role;

import java.util.List;

public interface RoleService {
    /**
     * 根据用户id查找其对应的角色
     * @param id
     * @return
     */
    List<Role> findRolesByUserid(int id);
}
