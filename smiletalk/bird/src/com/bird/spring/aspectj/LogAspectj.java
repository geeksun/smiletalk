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
 * Description aspectjע�ⷽʽʵ��AOP
 * @author Administrator
 * 2012-9-16
 */
@Aspect
@Component
public class LogAspectj {
	
	/**
	 * ��־��¼Service
	 */
	@Autowired
    private LogService logService;		
	
	 /** 
     * ���ҵ���߼���������� 
     */  
    @Pointcut("execution(* com.bird.service.*.insert*(..))")  
    public void insertServiceCall() { }  
	
    /** 
     * ��¼ҵ���߼���������� 
     */  
    @Pointcut("execution(* com.bird.service.*.login*(..))")  
    public void loginServiceCall() { }  
    
    /** 
     * ����Ա��Ӳ�����־(����֪ͨ) 
     * @param joinPoint 
     * @param rtv 
     * @throws Throwable 
     */  
    @AfterReturning(value="insertServiceCall()", argNames="rtv", returning="rtv")  
    public void insertServiceCallCalls(JoinPoint joinPoint, Object rtv) throws Throwable{  
          
        //�жϲ���  
        if(joinPoint.getArgs() == null){//û�в���  
            return;  
        }
          
        //��ȡ������  
        String methodName = joinPoint.getSignature().getName();  
          
        //������־����  
        LogBean log = new LogBean();
        log.setUserName("testAccount");
        log.setOperation("joinPoint:"+joinPoint+", Method:"+methodName+"()");
        
        log.setOperation("���");
        logService.addLog(log);
    }
    
    /** 
     * �û���¼������־(����֪ͨ) 
     * @param joinPoint 
     * @param rtv 
     * @throws Throwable 
     */  
    @AfterReturning(value="loginServiceCall()", argNames="rtv", returning="rtv")  
    public void loginServiceCallCalls(JoinPoint joinPoint, Object rtv) throws Throwable{  
          
        //�жϲ���  
        if(joinPoint.getArgs() == null){//û�в���  
            return;  
        }
          
        //��ȡ������  
        String methodName = joinPoint.getSignature().getName();  
          
        //������־����  
        LogBean log = new LogBean();
        log.setUserName("testAccount");
        log.setOperation("joinPoint:"+joinPoint+", Method:"+methodName+"()");
        
        log.setOperation("��¼");
        logService.addLog(log);
    }
    
}
