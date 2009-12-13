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
 *  italk  ��¼
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
			userBean.setErrorMessage("�������û���");                // jsp �ļ��� //userVo.setErrormessage()
			//this.addActionError("�û�������Ϊ��!");
			return LOGIN;
		}
		else if(password==null||password.equals("")){
			userBean.setErrorMessage("����������");
			// this.addActionError("���벻��Ϊ��!");
			return LOGIN;
		}
		else
		{
			userBean = userService.loginUser(userBean);		//1000��Ϊ��ʼ�����ӳ���Ҫʱ��ʱ��
			if(userBean!=null){
				String cookieFlag = null;
				String autoLogin = request.getParameter("autoLogin");	//�Ƿ��Զ���¼
				
				//�ж�cookie��Ϣ
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (int i = 0; i < cookies.length; i++) {
						if (cookies[i].getName().equals("usrCookie")
								&& cookies[i].getValue().equals(userName)) {
							cookieFlag = "1";
						}
					}
				}
				//�����û�cookie��Ϣ 
				if (!"1".equals(cookieFlag) && autoLogin != null) {
					Cookie usrCookie = new Cookie("usrCookie", userName);
					Cookie pwdCookie = new Cookie("pwdCookie", password);
					// ��վ����
					/*usrCookie.setDomain("www.italk.com");
					pwdCookie.setDomain("www.italk.com");*/
					usrCookie.setPath("/");
					pwdCookie.setPath("/");
					usrCookie.setMaxAge(3 * 24 * 60 * 60);//cookie������3��
					pwdCookie.setMaxAge(3 * 24 * 60 * 60);
					response.addCookie(usrCookie);
					response.addCookie(pwdCookie);
				}
				
				session.put(ConstantUtil.USER, userBean);
				
				//��ת�� homeTalk ���д���
				return SUCCESS;	
			}else{
				//userBean.setErrorMessage("�û������������");
				// this.addActionError("�û������������");
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
