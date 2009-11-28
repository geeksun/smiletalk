package com.bird.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.bird.domain.UserBean;
import com.bird.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author jzq
 * ºÏ≤‚EmailŒ®“ª–‘
 * 2009-11-16
 */
public class CheckUniqueEmail extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	private UserService userService;
	private UserBean userBean;
	HttpServletRequest request;
	HttpServletResponse response;
	
	public String execute() throws Exception {	
		request.setCharacterEncoding("GBK");
		response.setContentType("text/xml;charset=GBK");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		//HttpSession session = request.getSession(true);
		
		String iTalkemail = request.getParameter("email").trim();
		iTalkemail = java.net.URLDecoder.decode(iTalkemail, "UTF-8").trim();
		
		userBean = new UserBean();
		userBean.setEmail(iTalkemail);
		
		userBean = (UserBean) userService.getUserByEamil(userBean);
		if(userBean!=null){
			out.print("fail");
		}else{
			out.print("success");
		}
		userBean = null;
		out.close();
		return null;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
