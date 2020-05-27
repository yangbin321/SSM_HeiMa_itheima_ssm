package com.itheima.ssm.domain;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-10 18:58
 * @Description     资源权限表实体类
 */
public class Permission {

    private int id;
    private String permissionName;
    private String url;
    private List<Role> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
