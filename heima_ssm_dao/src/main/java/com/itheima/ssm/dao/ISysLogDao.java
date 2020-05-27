package com.itheima.ssm.dao;

import com.itheima.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-16 11:09
 * @Description
 */
public interface ISysLogDao {

    //保存日志信息
    @Insert("insert into sysLog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog sysLog) throws Exception;

    //查找所有日志信息
    @Select("select * from syslog")
    public List<SysLog> findAll() throws Exception;
}
