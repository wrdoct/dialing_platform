package com.boca.iot.platform.utils.log.service;

import com.boca.iot.platform.model.entity.system.SysOperLog;

/**
 * @author lulinwei
 */
public interface AsyncOperLogService { // 保存日志数据
    void saveSysOperLog(SysOperLog sysOperLog) ;
}
