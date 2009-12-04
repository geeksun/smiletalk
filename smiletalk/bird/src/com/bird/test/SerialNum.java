package com.bird.test;

/**
 *  �������кţ�ʹ�÷���--����SerialNum.get()
 * @author jzq
 *  ˽�о�̬ ThreadLocal ʵ����serialNum��Ϊ���ø���ľ�̬ SerialNum.get() ������ÿ���߳�ά����һ�������кš���
 *  �÷��������ص�ǰ�̵߳����кš����̵߳����к����ڵ�һ�ε��� SerialNum.get() ʱ����ģ����ں��������в�����ġ��� 
 *  2009-12-4
 */
public class SerialNum {

	// The next serial number to be assigned
	private static int nextSerialNum = 0;

	private static ThreadLocal serialNum = new ThreadLocal() {
		protected synchronized Object initialValue() {
			return new Integer(nextSerialNum++);
		}
	};

	public static int get() {
		return ((Integer) (serialNum.get())).intValue();
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		final int i = 0;
		
	}


}
