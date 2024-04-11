package com.boca.iot.manager.mapper;


import com.boca.iot.manager.model.entity.system.SysOperLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lulinwei
 */
@Mapper
public interface SysOperLogMapper {
    void insert(SysOperLog sysOperLog);
}
