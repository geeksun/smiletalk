package com.bird.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bird.domain.TopicBean;
import com.bird.service.TopicService;
import com.bird.util.DateUtil;
import com.bird.util.TokenUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * talk topic-��������,�з�ֹ�ظ��ύ����
 * @author jzq
 *  beta 0.1
 *  2009-11-9
 */
public class NewTalk extends ActionSupport implements ModelDriven<TopicBean>, SessionAware, ServletRequestAware {
	private TopicBean topicBean = new TopicBean();
	private TopicService topicService;
	Map<String, Object> session;
	HttpServletRequest request;
	
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public void setTopicBean(TopicBean topicBean) {
		this.topicBean = topicBean;
	}

	public String execute() throws Exception{
		Long userId = (Long) session.get("userId");
		String clientToken = request.getParameter("clientToken");
		String sessionToken = (String) session.get("token");
		
		if(session==null||session.size()==0){
			return LOGIN;
		}
		else if(sessionToken!=null&&!clientToken.equals(sessionToken)){		//struts2���ظ��ύ
			topicBean.setUserId(userId);
			List<TopicBean> topicList = topicService.getObjectList(topicBean);
			//����������
			String token = TokenUtil.generateToken(request);
			request.setAttribute("clientToken", token);
			//�滻������
			session.put("token", token);
			request.setAttribute("topicList", topicList);
			return SUCCESS;
		}else{
	    	String userName = (String) session.get("userName");
	    	topicBean.setUserId(userId);
	    	topicBean.setUserName(userName);
			Date now = new Date();
			String topicTime = DateUtil.getDateString(now);
			topicBean.setTopicTime(topicTime);
			//δ��topicContent,userName,userId������֤
			int result = topicService.insertObject(topicBean);
			if(result>0){
				List<TopicBean> topicList = topicService.getObjectList(topicBean);
				//����������
				String token = TokenUtil.generateToken(request);
				request.setAttribute("clientToken", token);
				//�滻������
				session.put("token", token);
				request.setAttribute("topicList", topicList);
				return SUCCESS;
			}else{
				return ERROR;
			}
		}
		
	}
	
	public TopicBean getModel() {
		return topicBean;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
