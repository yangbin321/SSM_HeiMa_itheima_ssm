package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-10 17:46
 * @Description
 */
public interface IUserService extends UserDetailsService {

    //查询所有用户
    public List<UserInfo> findAll() throws Exception;

    //添加的时候保存用户
    void save(UserInfo userInfo) throws Exception;

    //根据用户id查询指定用户
    UserInfo findById(int id) throws Exception;

    //根据用户的id查找用户可以添加的角色
    List<Role> findOtherRoles(int userId) throws Exception;

    //给用户添加角色
    void addRoleToUser(int userId, int[] roleIds) throws Exception;
}
