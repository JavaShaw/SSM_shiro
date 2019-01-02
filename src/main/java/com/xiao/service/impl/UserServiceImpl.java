package com.xiao.service.impl;

import com.xiao.domain.Permission;
import com.xiao.domain.User;
import com.xiao.domain.UserExample;
import com.xiao.mapper.PermissionMapper;
import com.xiao.mapper.UserMapper;
import com.xiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public User findUserByName(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        if(users.size()==0 ||users == null){
            return null;
        }else
        {
            return users.get(0);
        }

    }

    @Override
    public List<Permission> findPermissionListByUser(User user) {
        return permissionMapper.selectPermissionsByUser(user.getId());
    }
}
