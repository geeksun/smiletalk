package com.bird.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jzq
 *  ���ڹ�����
 */
public class DateUtil {
	
	/**
	 * @param d
	 * @return Date ���ַ���ʾ
	 */
	public static String getDateString(Date d){
		if(d==null){
			return null;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		String dateStr = df.format(d);
		return dateStr;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date();
		System.out.println(getDateString(d));
	}

}
