package com.itheima.ssm.domain;

import org.springframework.security.core.userdetails.User;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-10 18:57
 * @Description 角色的实体类
 */
public class Role {

    private int id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private List<UserInfo> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }
}
