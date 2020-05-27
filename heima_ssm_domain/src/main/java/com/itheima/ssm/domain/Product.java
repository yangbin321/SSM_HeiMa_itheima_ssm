package com.itheima.ssm.domain;

import com.itheima.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Yangbin
 * @create 2020-05-06 23:25
 * @Description 产品信息的实体类
 */
public class Product {

    private int id;
    private String productNum;
    private String productName;
    private String cityName;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")//局部的类型转换
    private Date departureTime;
    private String departureTimeStr;//将时间转换为字符串展示
    private double productPrice;
    private String productDesc;
    private Integer productStatus;
    private String productStatusStr;//将状态为0、1转换为字符串展示

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }


    public String getDepartureTimeStr() {
        //将时间转换为指定的字符串形式展示
        if (departureTime != null){
            departureTimeStr = DateUtils.date2String(departureTime,"yyyy-MM-dd HH:mm:ss");
        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        //将状态为1和0的转化为文字表述
        if (productStatus != null){
            if (productStatus == 0){
                productStatusStr = "关闭";
            }
            if (productStatus == 1){
                productStatusStr = "开启";
            }
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }

}
