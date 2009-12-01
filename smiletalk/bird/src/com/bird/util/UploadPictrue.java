package com.bird.util;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ��־ǿ
 *  jsp�ϴ�ͼƬ
 *  create at 2009-1-13
 */
public class UploadPictrue {
	String picPath; 		 //ͼƬ·�� ����:F:picturea.gif��
	public String pictype[]; //����ͼƬ�ĺ�׺��
	FileInputStream in;
	int piclength; 			 //����ͼƬ�����kb

	public void setPicPath(String picPath) 	//���ͼƬ��·��
	{
		this.picPath = picPath;
	}

	public void setPiclength(int piclength) //����ͼƬ����󳤶�
	{
		this.piclength = piclength;
	}

	public int getPiclength() {
		return piclength;
	}

	public boolean testLength() //�ж�ͼƬ�ĳ����Ƿ�����趨����󳤶�
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

	public void setpictype(String[] pictype) //����ͼƬ����չ��
	{
		this.pictype = pictype;
	}

	public boolean testpictype() 			//�ж�ͼƬ����չ���Ƿ��ǹ涨��
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
