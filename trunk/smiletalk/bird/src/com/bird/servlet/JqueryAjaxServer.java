package com.bird.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;

/**
 * jquery:$.ajax()用法\$.post()\$.get()三种方式
 * @author jzq
 * 2010-1-11
 */
public class JqueryAjaxServer extends HttpServlet {

	public JqueryAjaxServer() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String account = request.getParameter("account");
		if ("iamcrazy".equals(account)) {
			out.print("Sorry,the user is exist");
		} else {
			out.print("Congratulation,this account you can use!!!!");
		}
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		this.doGet(request, response);
	}
	
}
