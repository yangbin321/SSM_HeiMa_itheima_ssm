package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IOrdersDao;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-10 11:22
 * @Description
 */

@Service                //service注解
@Transactional          //事务注解
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    /**
     * 订单查询的方法
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public List<Orders> findAll(int pageNum, int pageSize) throws Exception {

        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(pageNum,pageSize);
        return ordersDao.findAll();

    }

    //根据id查询订单
    @Override
    public Orders findById(int ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }
}
