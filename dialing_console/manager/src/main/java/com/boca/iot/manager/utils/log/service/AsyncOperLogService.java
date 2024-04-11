package com.boca.iot.manager.utils.log.service;

import com.boca.iot.manager.model.entity.system.SysOperLog;

/**
 * @author lulinwei
 */
public interface AsyncOperLogService { // 保存日志数据
    void saveSysOperLog(SysOperLog sysOperLog) ;
}
