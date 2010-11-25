package com.bird.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet thread safefy analysis
 * Servlet run mode is multi-thread pattern,single instance(Servlet���з�ʽΪ���߳�ģʽ����ʵ��) 
 * @author ��־ǿ
 * 2010-10-25
 */
@SuppressWarnings("serial")
public class ConcurrentTest extends HttpServlet {
	PrintWriter output;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		this.service(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		this.service(request, response);
	}
	
	/** ��output��ʵ��������ɾֲ������Ϳɽ���̰߳�ȫ���� 
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username;
		response.setContentType("text/html; charset=gb2312");
		username = request.getParameter("username");
		output = response.getWriter();
		try {
			Thread.sleep(5000); // Ϊ��ͻ���������⣬��������һ����ʱ
		} catch (InterruptedException e) {
			output.println("��InterruptedException�쳣����");
		}
		output.println("�û���:" + username + "<BR>");
	}

}
