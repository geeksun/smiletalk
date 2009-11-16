package com.bird.core;

import javax.servlet.http.HttpServlet;

import com.bird.domain.UserBean;
import com.bird.service.UserService;
import com.bird.service.impl.UserServiceImpl;

/**
 * register new user
 * @author jzq
 * 2009-11-16
 */
public class TalkRegister extends HttpServlet {
	private UserService userService;
	private UserBean userBean;

	public void doGet(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		return;
	}

	public void doPost(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		request.setCharacterEncoding("GBK");
		//HttpSession session = request.getSession(true);

		//String iTalkAct = request.getParameter("iTalkAct"); // iTalk 的动作标记

		String iTalkName = request.getParameter("iTalkName");
		String iTalkpwd = request.getParameter("iTalkpwd");
		String iTalkemail = request.getParameter("iTalkemail");
		
		userService = new UserServiceImpl();
		userBean = new UserBean();
		userBean.setUserName(iTalkName);
		userBean.setEmail(iTalkemail);
		userBean.setPassword(iTalkpwd);
		
		userBean = (UserBean) userService.getObject(userBean);
		if(userBean!=null){
			request.setAttribute("validate", "fail");
			request.getRequestDispatcher("/register.jsp").forward(
					request, response);
		}else{
			userService.insertObject(userBean);
			request.getRequestDispatcher("/frame/iTalk.jsp").forward(
					request, response);
		}
	}
	
	
}
