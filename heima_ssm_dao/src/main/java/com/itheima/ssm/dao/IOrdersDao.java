package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-10 11:10
 * @Description 订单接口
 */
public interface IOrdersDao {

    //订单查找的方法
    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.itheima.ssm.dao.IProductDao.findById")),
    })
    public List<Orders> findAll() throws Exception;


    //多表操作
    //根据订单id查询
    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            //订单和产品有关
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.itheima.ssm.dao.IProductDao.findById")),
            //订单和会员有关
            @Result(property = "member",column = "memberId",javaType = Product.class,one = @One(select = "com.itheima.ssm.dao.IMemberDao.findById")),
            //订单和游客有关，这里的游客是多个，需要多表管理查询
            @Result(property = "travellers",column = "id",javaType = java.util.List.class, many = @Many(select = "com.itheima.ssm.dao.ITravellerDao.findByOrdersId"))
    })
    public Orders findById(int ordersId);
}
