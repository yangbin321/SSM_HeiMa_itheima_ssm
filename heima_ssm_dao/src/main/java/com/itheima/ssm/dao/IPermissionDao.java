package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-11 22:49
 * @Description
 */
public interface IPermissionDao {

    //查找角色关联表中的资源权限
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    public List<Permission> findPermissionByRoleId(int id) throws Exception;

    //查找所有资源权限
    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    //添加资源权限
    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;

}
