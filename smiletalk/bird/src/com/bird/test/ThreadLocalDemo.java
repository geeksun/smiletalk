package com.bird.test;

import java.util.Random;

/**
 * Created by IntelliJ IDEA. 
 * User: leizhimin
 * Date: 2007-11-23 
 * Time: 10:53:33
 * 多线程下测试程序
 */
public class ThreadLocalDemo implements Runnable {
	// 创建线程�?部变量studentLocal，在后面你会发现用来保存Student对象
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
	 *  示例业务方法，用来测�?      
	 */
	public void accessStudent() {
		// 获取当前线程的名�?
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(currentThreadName + " is running!");
		// 产生�?个随机数并打�?
		Random random = new Random();
		int age = random.nextInt(100);
		System.out
				.println("thread " + currentThreadName + " set age to:" + age);
		// 获取�?个Student对象，并将随机数年龄插入到对象属性中
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
		// 获取本地线程变量并强制转换为Student类型
		Student student = (Student) studentLocal.get();
		// 线程首次执行此方法的时�?�，studentLocal.get()肯定为null
		if (student == null) {
			// 创建�?个Student对象，并保存到本地线程变量studentLocal�?
			student = new Student();
			studentLocal.set(student);
		}
		return student;
	}
	
	
}