package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-10 17:47
 * @Description
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    //引入security对密码加密的配置
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //User是security中的，用来处理自己的用户对象封装成UserDetails
//        User user = new User(userInfo.getUsername(),"{noop}" + userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }


    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    //保存用户
    @Override
    public void save(UserInfo userInfo) throws Exception {
        //对密码进行加密，然后重新设置密码再给userInfo存入数据中
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    //根据用户id查询指定用户
    @Override
    public UserInfo findById(int id) throws Exception {
        return userDao.findById(id);
    }

    //根据用户的id查找用户可以添加的角色
    @Override
    public List<Role> findOtherRoles(int userId) throws Exception {
        return userDao.findOtherRoles(userId);
    }

    //给用户添加角色
    @Override
    public void addRoleToUser(int userId, int[] roleIds) throws Exception {

        for (int roleId:roleIds){
            userDao.addRoleToUser(userId,roleId);
        }

    }
}
