package com.bird.core;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;

import com.bird.domain.UserBean;
import com.bird.service.UserService;
import com.bird.service.impl.UserServiceImpl;

/**
 * @author jzq
 *  检查用户名重复
 *  2009-11-13
 */
public class CheckUserName extends HttpServlet {
	
	private UserService userService;
	private UserBean userBean;
	
	public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
		throws javax.servlet.ServletException, java.io.IOException{
		return;
	}

	public void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
		throws javax.servlet.ServletException, java.io.IOException{
		request.setCharacterEncoding("GBK");
		response.setContentType("text/xml;charset=GBK");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		//HttpSession session = request.getSession(true);
		
		String iTalkName = request.getParameter("iTalkName").trim();
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

}
