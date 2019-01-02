package com.xiao.mapper;

import com.xiao.domain.Permission;
import com.xiao.domain.PermissionExample;
import com.xiao.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {
    long countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    /*
    以下为非mybatis自动生成SQL
     */

    /**
     * 根据角色id查找角色拥有的权限
     * @param roleid
     * @return
     */
    List<Permission> selectPermissionsByUser(int roleid);
}