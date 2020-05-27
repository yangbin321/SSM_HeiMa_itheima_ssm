package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IPermissionDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-12 22:19
 * @Description
 */

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    //查找所有资源方法
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    //添加资源权限
    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
