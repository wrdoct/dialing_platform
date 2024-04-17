package com.boca.iot.platform.mapper;


import com.boca.iot.platform.model.entity.system.SysOperLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lulinwei
 */
@Mapper
public interface SysOperLogMapper {
    void insert(SysOperLog sysOperLog);
}
