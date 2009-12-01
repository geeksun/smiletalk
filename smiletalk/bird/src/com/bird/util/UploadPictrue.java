package com.bird.util;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 姜志强
 *  jsp上传图片
 *  create at 2009-1-13
 */
public class UploadPictrue {
	String picPath; 		 //图片路径 （如:F:picturea.gif）
	public String pictype[]; //设置图片的后缀名
	FileInputStream in;
	int piclength; 			 //设置图片的最大kb

	public void setPicPath(String picPath) 	//获得图片的路径
	{
		this.picPath = picPath;
	}

	public void setPiclength(int piclength) //设置图片的最大长度
	{
		this.piclength = piclength;
	}

	public int getPiclength() {
		return piclength;
	}

	public boolean testLength() //判断图片的长度是否大于设定的最大长度
	{
		try {
			in = new FileInputStream(picPath);
			if (in.available() / 1024 > piclength)
				return false;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

	public void setpictype(String[] pictype) //设置图片的扩展名
	{
		this.pictype = pictype;
	}

	public boolean testpictype() 			//判断图片的扩展名是否是规定的
	{
		if (pictype != null) {
			for (int i = 0; i < pictype.length; i++) {
				if (picPath.endsWith(pictype[i]))
					return true;
			}
			return false;
		}
		return false;
	}

}
