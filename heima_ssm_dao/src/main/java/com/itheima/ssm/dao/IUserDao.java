package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-10 19:20
 * @Description
 */
public interface IUserDao {

    //根据用户名查询用户
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true ,property = "id", column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username) throws Exception;

    //查询所有用户
    @Select("select * from users")
    public List<UserInfo> findAll() throws Exception;

    //保存用户
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    //根据用户id查询指定用户
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true ,property = "id", column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(int id);

    //根据用户的id查找用户可以添加的角色
    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
    public List<Role> findOtherRoles(int userId);

    //给用户添加角色
    @Insert(("insert into users_role(userId,roleId) values(#{userId},#{roleId})"))
    //涉及多个参数的时候，需要用@Param指定一下参数
    void addRoleToUser(@Param("userId") int userId, @Param("roleId") int roleId);
}
