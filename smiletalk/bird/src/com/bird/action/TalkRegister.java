package com.bird.action;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServlet;

import com.bird.domain.UserBean;
import com.bird.service.UserService;
import com.bird.service.impl.UserServiceImpl;
import com.bird.util.GuidUtil;

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

		String iTalkName = request.getParameter("iTalkName");
		String iTalkpwd = request.getParameter("iTalkpwd");
		String iTalkemail = request.getParameter("iTalkemail");
		
		userService = new UserServiceImpl();
		userBean = new UserBean();
		userBean.setUserName(iTalkName);
		userBean.setEmail(iTalkemail);
		userBean.setPassword(iTalkpwd);
		String validateCode = GuidUtil.generateGuid(iTalkemail);
		userBean.setValidateCode(validateCode);
		
		UserBean uBean = (UserBean) userService.getObject(userBean);
		if(uBean!=null){
			request.setAttribute("validate", "fail");
			request.getRequestDispatcher("/register.jsp").forward(
					request, response);
		}else{
			userService.insertObject(userBean);
			//发邮件验证用户,激活码
			try {
				userService.sendActivateEmail(userBean);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/frame/iTalk.jsp").forward(
					request, response);
		}
	}
	
	
}
