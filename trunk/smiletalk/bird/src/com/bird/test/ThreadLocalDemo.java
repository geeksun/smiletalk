package com.bird.test;

import java.util.Random;

/**
 * Created by IntelliJ IDEA. 
 * User: leizhimin
 * Date: 2007-11-23 
 * Time: 10:53:33
 * ���߳��²���threadLocal���÷�,ThreadLocal����ʵ�ֶ��̲߳������μ�����ݵİ�ȫ�ԡ��ص㣺�Կռ任ʱ�䣬�ķ����ڴ棬��ʱ���б�֤��
 * Synchronized�����̼߳�����ݹ�����ThreadLocal�������̼߳�����ݸ��롣
 * ThreadLocal��Synchonized�����ڽ�����̲߳������ʡ�����ThreadLocal��synchronized�б��ʵ����� synchronized���������Ļ��ƣ�
 * ʹ������������ĳһʱ��ֻ�ܱ�һ���̷߳��ʡ���ThreadLocalΪÿһ���̶߳��ṩ�˱����ĸ�����ʹ��ÿ���߳���ĳһʱ����ʵ��Ĳ�����ͬһ������
 * �����͸����˶���̶߳����ݵ����ݹ�����Synchronizedȴ�����෴���������ڶ���̼߳�ͨ��ʱ�ܹ�������ݹ���
 */
public class ThreadLocalDemo implements Runnable {
	// �����ֲ߳̾�����studentLocal���ں�����ᷢ����������Student����
	private final static ThreadLocal studentLocal = new ThreadLocal();

	public static void main(String[] agrs) {
		ThreadLocalDemo td = new ThreadLocalDemo();
		Thread t1 = new Thread(td, "a");
		Thread t2 = new Thread(td, "b");
		t1.start();
		t2.start();
	}

	public void run() {
		accessStudent();
	}

	/**
	 *  ʾ��ҵ�񷽷�����������
	 */
	public void accessStudent() {
		// ��ȡ��ǰ�̵߳�����
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(currentThreadName + " is running!");
		// ����һ�����������ӡ
		Random random = new Random();
		int age = random.nextInt(100);
		System.out
				.println("thread " + currentThreadName + " set age to:" + age);
		// ��ȡһ��Student���󣬲��������������뵽����������
		Student student = getStudent();
		student.setAge(age);
		System.out.println("thread " + currentThreadName
				+ " first read age is:" + student.getAge());
		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("thread " + currentThreadName
				+ " second read age is:" + student.getAge());
	}

	protected Student getStudent() {
		// ��ȡ�����̱߳���������ǿ��ת��ΪStudent����
		Student student = (Student) studentLocal.get();
		// �߳��״�ִ�д˷�����ʱ��studentLocal.get()�϶�Ϊnull
		if (student == null) {
			// ����һ��Student���󣬲����浽�����̱߳���studentLocal��
			student = new Student();
			studentLocal.set(student);
		}
		return student;
	}
	
	
}