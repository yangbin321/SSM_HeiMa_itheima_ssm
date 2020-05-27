package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-10 12:31
 * @Description
 */
public interface ITravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId =#{ordersId})")
    public List<Traveller> findByOrdersId(int id) throws Exception;
}
