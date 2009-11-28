package com.bird.action;

import java.util.Date;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bird.domain.UserBean;
import com.bird.service.UserService;
import com.bird.service.impl.UserServiceImpl;
import com.bird.util.DateUtil;
import com.bird.util.GuidUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * register new italk user
 * @author jzq
 * @version beta0.1
 * 2009-11-16
 */
public class TalkRegister extends ActionSupport implements ModelDriven<UserBean>,SessionAware,ServletRequestAware {
	private static String REGISTER = "register";
	private UserService userService;
	private UserBean userBean = new UserBean();
	Map<String, Object> session;
	HttpServletRequest request;
	
	public String execute() throws Exception {
		String userName = userBean.getUserName();
		String password = userBean.getPassword();
		String email = userBean.getEmail();
		
		userBean = new UserBean();
		userBean.setUserName(userName);
		userBean.setPassword(password);
		userBean.setEmail(email);
		Date now = new Date();
		String regTime = DateUtil.getDateString(now);
		userBean.setRegTime(regTime);
		String validateCode = GuidUtil.generateGuid(email);
		userBean.setValidateCode(validateCode);
		
		//检验是否已经有此用户名的用户, 服务器端验证, 防止批量注册
		/*UserBean uBean = (UserBean) userService.getObject(userBean);
		if(uBean!=null){
			request.setAttribute("validate", "fail");
			return REGISTER;
		}else{}*/
			userService.insertObject(userBean);
			//发邮件验证用户,激活码
			try {
				userService.sendActivateEmail(userBean);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			return SUCCESS;
		
	}

	public UserBean getModel() {
		return userBean;
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

	
}
