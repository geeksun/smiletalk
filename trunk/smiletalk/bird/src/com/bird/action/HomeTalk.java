package com.bird.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bird.domain.TopicBean;
import com.bird.service.TopicService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 主talk内容页面：包括自己的talk和follow者的talk
 * @author 姜志强
 * 2009-11-30
 */
public class HomeTalk extends ActionSupport  implements SessionAware,ServletRequestAware {
	private TopicService topicService;
	Map<String, Object> session;
	HttpServletRequest request;
	
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public String execute() throws Exception {
		if(session!=null&&session.size()>0){
			long userId = (Long) session.get("userId");
			TopicBean topicBean = new TopicBean();
			topicBean.setUserId(userId);
			List<TopicBean> topicList = topicService.getObjectList(topicBean); 			
			request.setAttribute("topicList", topicList);
			
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
	
	
}
