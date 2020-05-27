package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-06 23:33
 * @Description 实体类接口
 */
public interface IProductDao {

    /**
     * 根据id查询商品信息
     * @return
     * @throws Exception
     */
    @Select("select * from product where id = #{id}")
    public Product findById(int id) throws Exception;

    /**
     * 查找所有产品信息
     * @return
     * @throws Exception
     */
    @Select("select * from product")
    public List<Product> finfAll() throws Exception;

    /**
     * 保存产品的操作
     * @param product
     */
    //=========注意，添加完成后，记得在controller中调用一下查询方法，刷新数据====
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

}
