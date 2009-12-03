package com.bird.action;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bird.domain.UserBean;
import com.bird.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * talker��ϢԤ��������
 * @author ��־ǿ
 * 2009-11-30
 */
public class SettingsTalk extends ActionSupport implements SessionAware, ServletRequestAware {
	private UserService userService;
	private UserBean userBean;
	Map<String, Object> session;
	HttpServletRequest request;
	
	public String execute() throws Exception {
		if(session!=null&&session.size()>0){
			Long userId = (Long) session.get("userId");
			userBean = new UserBean();
			userBean.setUserId(userId);
			userBean = userService.getUserById(userBean);
			//String phothPath = userBean.getPhotoPath();
			/*if(phothPath!=null){
				userBean.setPhotoPath(request.getContextPath()+phothPath);
			}*/
			//��Ҫ��ǰ̨��ʾ��userBean������Ϊnull��ֵ����,�����null,ת����""
			
			return SUCCESS;	
		}else{
			return LOGIN;	
		}
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

}
