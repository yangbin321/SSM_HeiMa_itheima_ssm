package com.itheima.ssm.domain;

import com.itheima.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Yangbin
 * @create 2020-05-16 10:07
 * @Description 日志表实体类
 */
public class SysLog {

    private int id;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")//局部的类型转换
    private Date visitTime;
    private String visitTimeStr;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitTimeStr() {
        //将时间转换为指定的字符串形式展示
        if (visitTime != null){
            visitTimeStr = DateUtils.date2String(visitTime,"yyyy-MM-dd HH:mm:ss");
        }
        return visitTimeStr;
    }

    public void setvisitTimeStr(String visitTimrStr) {
        this.visitTimeStr = visitTimrStr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
