package com.bird.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Description AOP����
 *        ���Ȼ�ȡһ��ҵ��ӿڵ�ʵ�ֶ���
 *       ��ȡһ��InvocationHandlerʵ���࣬������Ǵ������
 *        ������̬�������
 *       ͨ����̬����������processBusiness()��������ʱ����ԭʼ����ķ����м������
 *       
 *       ��java������ʵ�ֶ�̬������ 
 * ��һ��������Ҫ��һ���ӿڣ���Ҫ��һ���ӿڵ�ʵ���࣬�����ʵ�����ؾ�������Ҫ����Ķ��� 
 * ��ν������Ҳ�����ڵ���ʵ����ķ���ʱ�������ڷ���ִ��ǰ��������Ĺ�����������Ǵ��� 
 * �ڶ���������Ҫ�Լ�дһ����Ҫ������ķ���ִ��ʱ���ܹ������⹤�����࣬����������̳�InvocationHandler�ӿڣ� 
 * ΪʲôҪ�̳����أ���Ϊ�������ʵ���ڵ���ʵ����ķ�����ʱ�򣬲����������ʵ�������������� 
 * ����ת������������invoke�������̳�ʱ����ʵ�ֵķ����������������������Ե���������ʵ��������������
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

		// ���ô�������ҵ�񷽷�ǰ��, ʵ��AOP���أ�����������Ĺ���
		proxy.processBusiness();
	}

}
