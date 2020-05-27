package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-12 20:00
 * @Description
 */

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    //查询所有角色
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    //角色添加——保存

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    //根据roleId查询role
    @Override
    public Role findById(int roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    //根据roleId查询可以添加的权限
    @Override
    public List<Permission> findOtherPermission(int roleId) throws Exception {
        return roleDao.findOtherPermission(roleId);
    }

    //给角色添加权限
    @Override
    public void addPermissionToRole(int roleId, int[] permissionIds) throws Exception {

        for (int permissionId:permissionIds) {
            roleDao.addPermissionToRle(roleId,permissionId);
        }
    }
}
