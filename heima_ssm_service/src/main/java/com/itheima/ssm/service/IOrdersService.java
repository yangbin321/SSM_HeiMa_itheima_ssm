package com.itheima.ssm.service;

import com.itheima.ssm.domain.Orders;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-10 11:20
 * @Description
 */
public interface IOrdersService {

    //订单查找方法，设置了页码和查询的范围
    public List<Orders> findAll(int pageNum,int pageSize) throws Exception;

    Orders findById(int ordersId) throws Exception;
}
