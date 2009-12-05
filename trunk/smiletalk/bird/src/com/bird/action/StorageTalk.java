package com.bird.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bird.domain.TopicBean;
import com.bird.domain.UserBean;
import com.bird.service.TopicService;
import com.bird.util.ConstantUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户的ITalk发言记录
 * @author 姜志强
 * @version beta 0.1 
 * 2009-11-29
 */
public class StorageTalk extends ActionSupport implements SessionAware,ServletRequestAware  {
	private UserBean userBean;
	private TopicService topicService;
	private List<TopicBean> topicList;
	Map<String, Object> session;
	HttpServletRequest request;
	
	public String execute() throws Exception {
		if(session!=null&&session.size()>0){
			userBean = (UserBean) session.get(ConstantUtil.USER);
			long userId = userBean.getUserId();
			TopicBean topicBean = new TopicBean();
			List<Long> userIdList = new ArrayList<Long>();
			userIdList.add(userId);
			topicBean.setUserIdList(userIdList);
			topicList = topicService.getObjectList(topicBean); 		
			String photoPath = userBean.getPhotoPath();
			for(TopicBean topic:topicList){
				topic.setPhotoPath(photoPath);
			}
			//request.setAttribute("topicList", topicList);
			
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

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public List<TopicBean> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<TopicBean> topicList) {
		this.topicList = topicList;
	}

}
