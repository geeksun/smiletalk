package com.bird.test;

/**
 *  生成序列号：使用方法--调用SerialNum.get()
 * @author jzq
 *  私有静态 ThreadLocal 实例（serialNum）为调用该类的静态 SerialNum.get() 方法的每个线程维护了一个“序列号”，
 *  该方法将返回当前线程的序列号。（线程的序列号是在第一次调用 SerialNum.get() 时分配的，并在后续调用中不会更改。） 
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
