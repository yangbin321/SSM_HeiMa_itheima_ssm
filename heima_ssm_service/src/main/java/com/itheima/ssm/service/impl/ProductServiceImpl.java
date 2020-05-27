package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IProductDao;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-07 19:40
 * @Description
 */

@Service                //service注解
@Transactional          //事务注解
public class ProductServiceImpl implements IProductService {

    //自动注入
    @Autowired
    private IProductDao productDao;

    @Override
    public Product finfById(int id) throws Exception {
        return productDao.findById(id);
    }

    /**
     *  查询所有产品信息方法
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> findAll() throws Exception {
        return productDao.finfAll();
    }

    /**
     *   添加产品信息时保存方法
     * @param product
     * @throws Exception
     */
    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }



}
