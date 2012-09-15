package com.bird.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Description AOP测试
 * @author Administrator
 * 2012-9-15
 */
public class AopTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BusinessInterface businessImp = new BusinessObject();

		InvocationHandler handler = new LogHandler(businessImp);

		BusinessInterface proxy = (BusinessInterface) Proxy.newProxyInstance(
		businessImp.getClass().getClassLoader(),
		businessImp.getClass().getInterfaces(),
		handler);

		// 调用代理对象的业务方法, 实现AOP拦截
		proxy.processBusiness();
	}

}
