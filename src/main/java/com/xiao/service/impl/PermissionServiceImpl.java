package com.xiao.service.impl;

import com.xiao.domain.Permission;
import com.xiao.mapper.PermissionMapper;
import com.xiao.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jnlp.PersistenceService;
import java.util.List;
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> findPermissionsByRoleid(int roleid) {
        return permissionMapper.selectPermissionsByUser(roleid);
    }
}
