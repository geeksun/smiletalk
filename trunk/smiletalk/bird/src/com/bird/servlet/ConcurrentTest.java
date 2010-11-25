package com.bird.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet thread safefy analysis
 * Servlet run mode is multi-thread pattern,single instance(Servlet运行方式为多线程模式，单实例) 
 * @author 姜志强
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
	
	/** 把output从实例变量变成局部变量就可解决线程安全问题 
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
			Thread.sleep(5000); // 为了突出并发问题，在这设置一个延时
		} catch (InterruptedException e) {
			output.println("有InterruptedException异常发生");
		}
		output.println("用户名:" + username + "<BR>");
	}

}
