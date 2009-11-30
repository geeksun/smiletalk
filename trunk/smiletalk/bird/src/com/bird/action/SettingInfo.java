package com.bird.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bird.domain.Follow;
import com.bird.domain.TopicBean;
import com.bird.service.TopicService;
import com.bird.service.UserService;
import com.bird.util.TokenUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 *  �����û�������Ϣ
 *  @author ��־ǿ 
 *  2009-11-30
 */
public class SettingInfo extends ActionSupport implements SessionAware, ServletRequestAware {
	private UserService userService;
	Map<String, Object> session;
	HttpServletRequest request;
	
	public String execute() throws Exception {
		
		
		
		if(session!=null&&session.size()>0){
			long userId = (Long) session.get("userId");
			TopicBean topicBean = new TopicBean();
			topicBean.setUserId(userId);
			Follow follow = new Follow();
			follow.setUserId(userId);
			List<Long> userIdList = userService.getUserIdList(follow);
			
			userIdList.add(userId);
			topicBean.setUserIdList(userIdList);
			//����������
			String token = TokenUtil.generateToken(request);
			request.setAttribute("clientToken", token);
			//�滻������
			session.put("token", token);
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

}
