package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-12 19:55
 * @Description
 */

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    //查询所有角色
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{

        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.findAll();
        mv.addObject("roleList",roles);
        mv.setViewName("role-list");
        return mv;
    }

    //添加—保存用户
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception{

        roleService.save(role);;
        return "redirect:findAll.do";
    }

    //根据roleId查询role，并查询出可以添加的权限
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) int roleId) throws Exception{

        ModelAndView mv = new ModelAndView();
        //根据roleId查询role
        Role role = roleService.findById(roleId);
        //根据roleId查询可以添加的权限
        List<Permission> otherPermissions = roleService.findOtherPermission(roleId);
        //把数据添加到页面
        mv.addObject("role",role);
        mv.addObject("permissionList",otherPermissions);
        //返回到这个页面
        mv.setViewName("role-permission-add");
        return mv;
    }

    //给角色添加权限
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true) int roleId,@RequestParam(name = "ids",required = true) int[] permissionIds) throws Exception {
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";
    }


}
