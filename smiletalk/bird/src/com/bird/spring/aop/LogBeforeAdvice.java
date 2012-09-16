package com.bird.spring.aop;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.springframework.aop.MethodBeforeAdvice;

import com.bird.util.DateUtil;

/**
 * Description �е�ǰִ�в���
 * @author Administrator
 * 2012-9-16
 */
public class LogBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println("Spring AOP��������ʼ����");
		System.out.println("Before " + this.getClass().getName() + " method " + arg0.getName() +"() execute...");
		
		System.out.println("ϵͳ��־��"+DateUtil.getDateString(new Date())+":"+"������"+arg0.getName()+" :ʹ���˲���"+ (Arrays.toString(arg1)));

	}

}
