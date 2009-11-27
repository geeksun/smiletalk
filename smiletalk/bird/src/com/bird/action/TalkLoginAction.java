package com.bird.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bird.domain.TopicBean;
import com.bird.domain.UserBean;
import com.bird.service.TopicService;
import com.bird.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author jzq
 *  italk  登录
 *  2009-11-16
 */
public class TalkLoginAction extends ActionSupport implements ModelDriven<UserBean>,SessionAware,ServletRequestAware {
	private UserService userService;
	private TopicService topicService;
	private UserBean userBean = new UserBean();
	private TopicBean topicBean;
	Map<String, Object> session;
	HttpServletRequest request;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
	
	public String execute() throws Exception {	
		UserBean user = new UserBean();
		user.setUserName(userBean.getUserName());
		user.setPassword(userBean.getPassword());
	
		if(userBean.getUserName()==null||userBean.getUserName().equals("")){
			user.setErrorMessage("请输入用户名");                // jsp 文件用 //userVo.setErrormessage()
			//this.addActionError("用户名不能为空!");
			return LOGIN;
		}
		else if(userBean.getPassword()==null||userBean.getPassword().equals("")){
			user.setErrorMessage("请输入密码");
			// this.addActionError("密码不能为空!");
			return LOGIN;
		}
		else
		{	
			user = userService.loginUser(user);
			if(user!=null){
				session.put("userName", user.getUserName());
				long userId = user.getUserId();
				session.put("userId", userId);
				topicBean = new TopicBean();
				topicBean.setUserId(userId);
				List<TopicBean> topicList = topicService.getObjectList(topicBean); 			
				request.setAttribute("topicList", topicList);
				
				return SUCCESS;	
			}else{
				user.setErrorMessage("用户名或密码错误");
				// this.addActionError("用户名或密码错误");
				return LOGIN;
			}
		}	
	}	
	
	public UserBean getModel() {
		return userBean;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;		
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;			
	}


/*	
	public void doPost(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {

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

		 保存用户cookie信息 
		if (!"1".equals(cookieFlag) && autoLogin != null) {
			Cookie usrCookie = new Cookie("usrCookie", iTalkName);
			Cookie pwdCookie = new Cookie("pwdCookie", iTalkName);
			// 网站域名
			usrCookie.setDomain("www.italk.com");
			pwdCookie.setDomain("www.italk.com");
			usrCookie.setPath("/");
			pwdCookie.setPath("/");
			usrCookie.setMaxAge(3 * 24 * 60 * 60);//cookie生存期3天
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
	}*/
	
	
}
