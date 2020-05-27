package com.itheima.ssm.service;

import com.itheima.ssm.domain.SysLog;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-16 11:07
 * @Description
 */
public interface ISysLogService {

    //保存日志的方法
    public void save(SysLog sysLog) throws Exception;

    //查找全部日志信息
    public List<SysLog> findAll() throws Exception;
}
