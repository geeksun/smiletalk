package com.bird.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bird.domain.UserBean;
import com.bird.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 忘记密码的处理：用邮件找回
 * @author 姜志强
 *  2009-12-11
 */
public class ForgetPassword extends ActionSupport {
	private UserService userService;
		
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute() throws Exception {
		/*ActionContext actx = ActionContext.getContext();
		*/
		
		//非IOC方式,这种方式与Servlet API紧耦合，不利于单元测试，优点是具有灵活性
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String email = request.getParameter("email");
		if(email!=null){
			UserBean userBean = new UserBean();
			userBean.setEmail(email);
			userBean = (UserBean) userService.getUserByEamil(userBean);
			if(userBean!=null){
				userService.sendForgetDisposeEmail(userBean);
				return SUCCESS;
			}else{	// 无此注册邮件用户
				
				return INPUT;
			}
		}else{
			return LOGIN;
		}
		
	}
		
		
}
