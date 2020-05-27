package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-10 23:07
 * @Description
 */
public interface IRoleDao {

    //根据用户id查询所有对应角色
    @Select("select * from role where id in (select roleId from users_role where userId = #{id})")
    @Results({
            @Result(id = true ,property = "id", column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(int id) throws Exception;

    //查询所有角色
    @Select("select * from role")
    public List<Role> findAll() throws Exception;

    //新增加角色
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    //根据roleId查询role
    @Select("select * from role where id = #{roleId}")
    Role findById(int roleId) throws Exception;

    //根据roleId查询可以添加的权限
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermission(int roleId);

    //给角色添加权限
    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRle(@Param("roleId") int roleId, @Param("permissionId") int permissionId);
}
