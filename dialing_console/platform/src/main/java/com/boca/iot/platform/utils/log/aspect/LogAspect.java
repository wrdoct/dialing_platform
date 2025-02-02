package com.boca.iot.platform.utils.log.aspect;

import com.boca.iot.platform.model.entity.system.SysOperLog;
import com.boca.iot.platform.utils.log.util.LogUtil;
import com.boca.iot.platform.utils.log.annotation.Log;
import com.boca.iot.platform.utils.log.service.AsyncOperLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 环绕通知切面类
 *
 * @author lulinwei
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Autowired
    private AsyncOperLogService asyncOperLogService ;

    @Around(value = "@annotation(sysLog)")  // 使用该注解标记环绕通知方法，并指定切点为被@Log注解标记的方法。
    public Object doAroundAdvice(ProceedingJoinPoint joinPoint , Log sysLog) {

        // 构建前置参数
        SysOperLog sysOperLog = new SysOperLog() ;

        LogUtil.beforeHandleLog(sysLog , joinPoint , sysOperLog) ;

        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
            // 执行业务方法
            LogUtil.afterHandlLog(sysLog , proceed , sysOperLog , 0 , null) ;
            // 构建响应结果参数
        } catch (Throwable e) {                                 // 代码执行进入到catch中，
            // 业务方法执行产生异常
            e.printStackTrace();                                // 打印异常信息
            LogUtil.afterHandlLog(sysLog , proceed , sysOperLog , 1 , e.getMessage()) ;

            throw new RuntimeException(); // 事务失效问题解决：抛出异常。--当业务方法产生异常以后，事务切面类感知到异常以后事务进行回滚；
            // 事务切面类的优先级要高于自定义切面类，当在自定义切面类中对异常进行了捕获，没有将异常进行抛出，那么此时事务切面类是感知不到异常的存在，因此事务失效。
            // 另一种事务失效的解决方案：使用@Order注解提高自定义切面类的优先级
        }

        // 保存日志数据
        asyncOperLogService.saveSysOperLog(sysOperLog);

        // 返回执行结果
        return proceed ;
    }
}
