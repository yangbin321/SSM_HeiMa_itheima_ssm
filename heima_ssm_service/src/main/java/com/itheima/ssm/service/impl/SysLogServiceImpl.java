package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.ISysLogDao;
import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-05-16 11:07
 * @Description
 */

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    //保存日志信息
    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    //查询所有日志信息
    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }
}
