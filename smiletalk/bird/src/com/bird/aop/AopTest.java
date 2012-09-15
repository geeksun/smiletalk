package com.bird.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Description AOP测试
 *        首先获取一个业务接口的实现对象；
 *       获取一个InvocationHandler实现类，这个就是代理对象
 *        创建动态代理对象；
 *       通过动态代理对象调用processBusiness()方法，此时会在原始对象的方法中加入操作
 *       
 *       在java种怎样实现动态代理呢 
 * 第一步，我们要有一个接口，还要有一个接口的实现类，而这个实现类呢就是我们要代理的对象， 
 * 所谓代理呢也就是在调用实现类的方法时，可以在方法执行前后做额外的工作，这个就是代理。 
 * 第二步，我们要自己写一个在要代理类的方法执行时，能够做额外工作的类，而这个类必须继承InvocationHandler接口， 
 * 为什么要继承它呢？因为代理类的实例在调用实现类的方法的时候，不会调真正的实现类的这个方法， 
 * 而是转而调用这个类的invoke方法（继承时必须实现的方法），在这个方法中你可以调用真正的实现类的这个方法。
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

		// 调用代理对象的业务方法前后, 实现AOP拦截，可以做额外的工作
		proxy.processBusiness();
	}

}
