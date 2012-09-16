package com.bird.spring.aop;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.springframework.aop.MethodBeforeAdvice;

import com.bird.util.DateUtil;

/**
 * Description 切点前执行操作
 * @author Administrator
 * 2012-9-16
 */
public class LogBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println("Spring AOP。。。开始。。");
		System.out.println("Before " + this.getClass().getName() + " method " + arg0.getName() +"() execute...");
		
		System.out.println("系统日志："+DateUtil.getDateString(new Date())+":"+"调用了"+arg0.getName()+" :使用了参数"+ (Arrays.toString(arg1)));

	}

}
