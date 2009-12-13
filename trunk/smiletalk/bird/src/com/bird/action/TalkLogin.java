package com.bird.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bird.domain.TopicBean;
import com.bird.domain.UserBean;
import com.bird.service.UserService;
import com.bird.util.ConstantUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author jzq
 *  italk  登录
 *  2009-11-16
 */
public class TalkLogin extends ActionSupport implements ModelDriven<UserBean>,SessionAware,ServletRequestAware,ServletResponseAware {
	private UserService userService;
	private UserBean userBean = new UserBean();
	private List<TopicBean> topicList;
	Map<String, Object> session;
	HttpServletRequest request;
	HttpServletResponse response;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute() throws Exception {
		String userName = userBean.getUserName();
		String password = userBean.getPassword();
		
		if(userName==null||userName.equals("")){
			userBean.setErrorMessage("请输入用户名");                // jsp 文件用 //userVo.setErrormessage()
			//this.addActionError("用户名不能为空!");
			return LOGIN;
		}
		else if(password==null||password.equals("")){
			userBean.setErrorMessage("请输入密码");
			// this.addActionError("密码不能为空!");
			return LOGIN;
		}
		else
		{
			userBean = userService.loginUser(userBean);		//1000因为初始化连接池需要时间时间
			if(userBean!=null){
				String cookieFlag = null;
				String autoLogin = request.getParameter("autoLogin");	//是否自动登录
				
				//判断cookie信息
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (int i = 0; i < cookies.length; i++) {
						if (cookies[i].getName().equals("usrCookie")
								&& cookies[i].getValue().equals(userName)) {
							cookieFlag = "1";
						}
					}
				}
				//保存用户cookie信息 
				if (!"1".equals(cookieFlag) && autoLogin != null) {
					Cookie usrCookie = new Cookie("usrCookie", userName);
					Cookie pwdCookie = new Cookie("pwdCookie", password);
					// 网站域名
					/*usrCookie.setDomain("www.italk.com");
					pwdCookie.setDomain("www.italk.com");*/
					usrCookie.setPath("/");
					pwdCookie.setPath("/");
					usrCookie.setMaxAge(3 * 24 * 60 * 60);//cookie生存期3天
					pwdCookie.setMaxAge(3 * 24 * 60 * 60);
					response.addCookie(usrCookie);
					response.addCookie(pwdCookie);
				}
				
				session.put(ConstantUtil.USER, userBean);
				
				//跳转到 homeTalk 进行处理
				return SUCCESS;	
			}else{
				//userBean.setErrorMessage("用户名或密码错误");
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

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public List<TopicBean> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<TopicBean> topicList) {
		this.topicList = topicList;
	}
	
}
