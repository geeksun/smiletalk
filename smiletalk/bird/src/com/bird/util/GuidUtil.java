package com.bird.util;

/**
 * @author jzq
 * ����ȫ��Ψһ�ַ�
 * 2009-11-18
 */
public class GuidUtil {
	
	/**
	 * ���ݴ���Ĳ����͵�ǰʱ���ΪΨһ��
	 * @param source
	 * @return 
	 */
	public static String generateGuid(String source){
		if(source==null){
			return null;
		}
		String time = Long.toString(System.currentTimeMillis());
		String guidString = source+time;
		MD5 md5 = new MD5();
		guidString = md5.getMD5ofStr(guidString);
		
		return guidString;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = generateGuid("jzq9899@163.com");
		System.out.println(s.toLowerCase());
		
		
	}

}
