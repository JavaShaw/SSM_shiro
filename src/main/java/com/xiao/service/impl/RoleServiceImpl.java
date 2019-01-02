package com.xiao.service.impl;

import com.xiao.domain.Role;
import com.xiao.mapper.RoleMapper;
import com.xiao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> findRolesByUserid(int id) {
        return roleMapper.selectRolesByUserId(id);
    }
}
