package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-12 22:19
 * @Description
 */
public interface IPermissionService {

    //查找所有资源方法
    List<Permission> findAll() throws Exception;

    //添加资源权限
    void save(Permission permission) throws Exception;
}
