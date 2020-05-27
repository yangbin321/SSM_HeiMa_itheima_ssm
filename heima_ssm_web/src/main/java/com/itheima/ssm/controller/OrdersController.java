package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-10 11:28
 * @Description
 */

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    //查询全部订单---未分页
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception {
//        ModelAndView mv = new ModelAndView();
//        List<Orders> ordersList = ordersService.findAll();
//        mv.addObject("ordersList", ordersList);
//        mv.setViewName("orders-list");
//        return mv;
//    }

    //查询全部订单---已分页
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageNum",required = true,defaultValue = "1") Integer pageNum,@RequestParam(name = "pageSize",required = true,defaultValue = "5")Integer pageSize) throws Exception {

        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(pageNum,pageSize);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    //根据id查询订单信息
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) int ordersId) throws Exception {

        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

}
