package com.bird.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

/**
 * Description 日志AOP拦截： AOP处理类
 * 其实现主要通过是java.lang.reflect.Proxy类和java.lang.reflect.InvocationHandler接口。
 * @author Administrator
 * 2012-9-15
 */
public class LogHandler implements InvocationHandler {
	
	private Logger logger = Logger.getLogger(this.getClass().getName()); 
	private Object delegate; 
	
	public LogHandler(Object delegate){ 
		this.delegate = delegate; 
	} 

	/**
	 * 代理实现调用的方法
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object o = null; 
		try { 
			logger.info("method stats..." + method); 
			o = method.invoke(delegate,	args); 
			logger.info("method ends..." + method); 
		} catch (Exception e){ 
			logger.info("Exception happends..."); 
			//excetpion handling. 
		}
		return o; 
	}

}
