package com.bird.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

/**
 * Description ��־AOP���أ� AOP������
 * ��ʵ����Ҫͨ����java.lang.reflect.Proxy���java.lang.reflect.InvocationHandler�ӿڡ�
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
	 * ����ʵ�ֵ��õķ���
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
