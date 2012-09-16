package com.bird.spring.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bird.domain.LogBean;
import com.bird.service.LogService;

/**
 * Description aspectj注解方式实现AOP
 * @author Administrator
 * 2012-9-16
 */
@Aspect
@Component
public class LogAspectj {
	
	/**
	 * 日志记录Service
	 */
	@Autowired
    private LogService logService;		
	
	 /** 
     * 添加业务逻辑方法切入点 
     */  
    @Pointcut("execution(* com.bird.service.*.insert*(..))")  
    public void insertServiceCall() { }  
	
    /** 
     * 登录业务逻辑方法切入点 
     */  
    @Pointcut("execution(* com.bird.service.*.login*(..))")  
    public void loginServiceCall() { }  
    
    /** 
     * 管理员添加操作日志(后置通知) 
     * @param joinPoint 
     * @param rtv 
     * @throws Throwable 
     */  
    @AfterReturning(value="insertServiceCall()", argNames="rtv", returning="rtv")  
    public void insertServiceCallCalls(JoinPoint joinPoint, Object rtv) throws Throwable{  
          
        //判断参数  
        if(joinPoint.getArgs() == null){//没有参数  
            return;  
        }
          
        //获取方法名  
        String methodName = joinPoint.getSignature().getName();  
          
        //创建日志对象  
        LogBean log = new LogBean();
        log.setUserName("testAccount");
        log.setOperation("joinPoint:"+joinPoint+", Method:"+methodName+"()");
        
        log.setOperation("添加");
        logService.addLog(log);
    }
    
    /** 
     * 用户登录操作日志(后置通知) 
     * @param joinPoint 
     * @param rtv 
     * @throws Throwable 
     */  
    @AfterReturning(value="loginServiceCall()", argNames="rtv", returning="rtv")  
    public void loginServiceCallCalls(JoinPoint joinPoint, Object rtv) throws Throwable{  
          
        //判断参数  
        if(joinPoint.getArgs() == null){//没有参数  
            return;  
        }
          
        //获取方法名  
        String methodName = joinPoint.getSignature().getName();  
          
        //创建日志对象  
        LogBean log = new LogBean();
        log.setUserName("testAccount");
        log.setOperation("joinPoint:"+joinPoint+", Method:"+methodName+"()");
        
        log.setOperation("登录");
        logService.addLog(log);
    }
    
}
