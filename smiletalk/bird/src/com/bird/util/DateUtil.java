package com.bird.util;

import java.text.DateFormat;
import java.text.ParseException;
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
	 * yyyy-MM-dd hh:mm:ss   hhСд 12Сʱ��
	 */
	public static String getDateString(Date d){
		if(d==null){
			return null;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = df.format(d);
		return dateStr;
	}
	
	/**
	 * @param d
	 * @return Date ���ַ���ʾ
	 * yyyy-MM-dd hh:mm:ss   hhСд 12Сʱ��
	 * @throws ParseException
	 */
	public static Date getDate(String source) throws ParseException{
		if(source==null){
			return null;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//String dateStr = df.format(d);
		Date date = df.parse(source);
		return date;
	}
	
	/**
	 * @param a
	 * @param b
	 * @return ʱ��Ƚ�ֵ
	 */
	public static int compareDays(Date a, Date b){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
		    Date d1 = df.parse("2008-03-26 13:31:40");
		    Date d2 = df.parse("2008-01-02 11:30:24");
		    long diff = d1.getTime() - d2.getTime();
		    long days = diff / (1000 * 60 * 60 * 24);
		    return (int) days;
		}
		catch (Exception e)
		{
		}
		return 0;
	}
	
	/**
	 * @return ʱ��Ƚ�ֵ: ��  ʱ  ��  ��
	 * @throws ParseException
	 */
	public static int test() throws ParseException{
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    java.util.Date now = df.parse("2008-03-26 13:31:40");
	    java.util.Date date=df.parse("2008-01-02 11:30:24");
	   
	    long l = now.getTime()-date.getTime();
	    long day = l/(24*60*60*1000);
	    long hour = l/(60*60*1000)-day*24;
	    long min = l/(60*1000)-day*24*60-hour*60;
	    long s = l/1000-day*24*60*60-hour*60*60-min*60;
	    System.out.println(""+day+"��"+hour+"Сʱ"+min+"��"+s+"��");
	    return 0;
	}
	
	/**
	 * @return ʱ��Ƚ�ֵ: ��  ʱ  ��  ��
	 * @throws ParseException
	 */
	public static int test2() throws ParseException{
	   SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   java.util.Date begin=dfs.parse("2008-01-02 11:30:24");
	   java.util.Date end = dfs.parse("2008-03-26 13:31:40");
	   long between=(end.getTime()-begin.getTime())/1000;//����1000��Ϊ��ת������

	   long day1=between/(24*3600);
	   long hour1=between%(24*3600)/3600;
	   long minute1=between%3600/60;
	   long second1=between%60/60;
	   System.out.println(""+day1+"��"+hour1+"Сʱ"+minute1+"��"+second1+"��");
	   return 0;
	}
	
	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		Date d = new Date();
		System.out.println(getDateString(d));
		int i = compareDays(d, d);
		System.out.println(i);
		test();
		test2();
		String s = "1999-3-8 0:0:0";
		Date da= getDate(s);
		System.out.println(da);
	}

}
