package com.boca.iot.platform.service.impl;


import com.boca.iot.platform.mapper.SysOperLogMapper;
import com.boca.iot.platform.model.entity.system.SysOperLog;
import com.boca.iot.platform.utils.log.service.AsyncOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author lulinwei
 */
@Service
public class AsyncOperLogServiceImpl implements AsyncOperLogService {
    @Autowired
    private SysOperLogMapper sysOperLogMapper;

    @Async      // 异步执行保存日志操作 //要想通过异步线程执行saveSysOperLog方法，那么此时就需要在启动类上添加@EnableAsync注解
    @Override
    public void saveSysOperLog(SysOperLog sysOperLog) {
        sysOperLogMapper.insert(sysOperLog);
    }
}
