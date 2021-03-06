package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-11 20:27
 * @Description
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    //查询所有用户
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{

        ModelAndView mv = new ModelAndView();
        List<UserInfo> users = userService.findAll();
        mv.addObject("userList",users);
        mv.setViewName("user-list");
        return mv;
    }

    //保存用户
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception{
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    //查询指定id的用户
    @RequestMapping("/findById.do")
    public ModelAndView findById(int id) throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    //查询用户以及用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) int userId) throws Exception {

        ModelAndView mv = new ModelAndView();
        //1、根据用户id查询用户
        UserInfo userInfo = userService.findById(userId);
        //2、根据用户id查询可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(userId);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;

    }

    //给用户添加角色
    //userId对应页面中的<input type="hidden" name="userId" value="${user.id}">中的userId，
    //ids对应页面中的<input name="ids" type="checkbox" value="${role.id}">中的ids
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) int userId,@RequestParam(name = "ids",required = true) int[] roleIds) throws Exception {

        userService.addRoleToUser(userId,roleIds);
        //添加成功后，返回用户查询后的界面
        return "redirect:findAll.do";
    }
}
