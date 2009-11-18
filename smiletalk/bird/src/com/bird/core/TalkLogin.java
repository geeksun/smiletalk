package com.bird.core;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import com.bird.domain.TopicBean;
import com.bird.domain.UserBean;
import com.bird.service.TopicService;
import com.bird.service.UserService;
import com.bird.service.impl.TopicServiceImpl;
import com.bird.service.impl.UserServiceImpl;

/**
 * @author jzq
 *  italk 登录
 *  2009-11-16
 */
public class TalkLogin extends HttpServlet {
	private UserService userService;
	private TopicService topicService;
	private UserBean userBean;
	private TopicBean topicBean;

	public void doGet(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		return;
	}

	public void doPost(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		request.setCharacterEncoding("GBK");
		HttpSession session = request.getSession(true);

		String iTalkName = request.getParameter("iTalkName");
		String iTalkpwd = request.getParameter("iTalkpwd");
		String autoLogin = request.getParameter("autoLogin");
		String cookieFlag = null;

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("usrCookie")
						&& cookies[i].getValue().equals(iTalkName)) {
					cookieFlag = "1";
				}
			}
		}

		if (!"1".equals(cookieFlag) && autoLogin != null) {
			Cookie usrCookie = new Cookie("usrCookie", iTalkName);
			Cookie pwdCookie = new Cookie("pwdCookie", iTalkName);
			// 网站域名
			usrCookie.setDomain("www.italk.com");
			pwdCookie.setDomain("www.italk.com");
			usrCookie.setPath("/");
			pwdCookie.setPath("/");
			usrCookie.setMaxAge(3 * 24 * 60 * 60);//cookie生存期期3天
			pwdCookie.setMaxAge(3 * 24 * 60 * 60);
			response.addCookie(usrCookie);
			response.addCookie(pwdCookie);
		}
		
		userService = new UserServiceImpl();
		userBean = new UserBean();
		userBean.setUserName(iTalkName);
		userBean.setPassword(iTalkpwd);
		userBean = userService.loginUser(userBean);
		if(userBean!=null) {
			session.setAttribute("userName", userBean.getUserName());
			long userId = userBean.getUserId();
			session.setAttribute("userId", userId);
			topicService = new TopicServiceImpl();
			topicBean = new TopicBean();
			topicBean.setUserId(userId);
			List<TopicBean> topicList = topicService.getObjectList(topicBean); 			
			request.setAttribute("topicList", topicList);
			request.getRequestDispatcher("/frame/iTalk.jsp")
					.forward(request, response);			
		}
	}
	
	
}
