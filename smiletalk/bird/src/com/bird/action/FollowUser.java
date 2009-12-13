package com.bird.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bird.domain.FollowBean;
import com.bird.domain.UserBean;
import com.bird.service.UserService;
import com.bird.util.ConstantUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 追随、关注用户
 * @author 姜志强
 *	2009-12-12
 */
public class FollowUser extends ActionSupport {
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(session!=null){
			UserBean usrBean = (UserBean) session.getAttribute(ConstantUtil.USER);
			long userId = usrBean.getUserId();
			String followId = request.getParameter("followId");
			if(followId!=null){
				FollowBean followBean = new FollowBean();
				followBean.setUserId(userId);
				followBean.setFollowId(Long.parseLong(followId));
				userService.insertFollow(followBean);
				
				return null;
			}else{
				return ERROR;
			}
		}else{
			return ERROR;
		}
	}

}
