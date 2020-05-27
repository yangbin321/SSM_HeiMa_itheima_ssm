package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-12 19:58
 * @Description
 */
public interface IRoleService {

    //查询所有角色
    public List<Role> findAll() throws Exception;

    //保存用户
    void save(Role role) throws Exception;

    //根据roleId查询role
    Role findById(int roleId) throws Exception;

    //根据roleId查询可以添加的权限
    List<Permission> findOtherPermission(int roleId) throws Exception;

    //给角色添加权限
    void addPermissionToRole(int roleId, int[] permissionIds) throws Exception;
}
