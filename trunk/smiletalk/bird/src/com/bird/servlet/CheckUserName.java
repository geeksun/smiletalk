package com.bird.servlet;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.bird.domain.UserBean;
import com.bird.service.UserService;
import com.bird.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author jzq
 *  检查用户名重复
 *  2009-11-13
 */
public class CheckUserName extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	private UserService userService;
	private UserBean userBean;
	HttpServletRequest request;
	HttpServletResponse response;
	
	public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
		throws javax.servlet.ServletException, java.io.IOException {
		return;
	}

	public void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
		throws javax.servlet.ServletException, java.io.IOException {
		request.setCharacterEncoding("GBK");
		response.setContentType("text/xml;charset=GBK");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		//HttpSession session = request.getSession(true);
		
		String iTalkName = request.getParameter("userName").trim();
		iTalkName = java.net.URLDecoder.decode(iTalkName, "UTF-8").trim();
		
		userService = new UserServiceImpl();
		userBean = new UserBean();
		userBean.setUserName(iTalkName);
		
		userBean = (UserBean) userService.getObject(userBean);
		if(userBean!=null){
			out.print("fail");
		}else{
			out.print("success");
		}
		userService = null;
		userBean = null;
		out.close();
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
}
