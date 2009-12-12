package com.bird.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bird.domain.UserBean;
import com.bird.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ��������Ĵ������ʼ��һ�
 * @author ��־ǿ
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
		
		//��IOC��ʽ,���ַ�ʽ��Servlet API����ϣ������ڵ�Ԫ���ԣ��ŵ��Ǿ��������
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String email = request.getParameter("email");
		if(email!=null){
			UserBean userBean = new UserBean();
			userBean.setEmail(email);
			userBean = (UserBean) userService.getUserByEamil(userBean);
			if(userBean!=null){
				userService.sendForgetDisposeEmail(userBean);
				return SUCCESS;
			}else{	// �޴�ע���ʼ��û�
				
				return INPUT;
			}
		}else{
			return LOGIN;
		}
		
	}
		
		
}
