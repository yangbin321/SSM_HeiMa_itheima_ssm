package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-07 19:39
 * @Description
 */
public interface IProductService {

    //根据id查询商品信息
    public Product finfById(int id) throws Exception;

    //查询所有产品信息
    public List<Product> findAll() throws Exception;

    //添加产品时的保存操作
    void save(Product product) throws Exception;
}
