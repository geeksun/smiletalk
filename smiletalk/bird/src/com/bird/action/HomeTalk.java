package com.bird.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bird.domain.Follow;
import com.bird.domain.TopicBean;
import com.bird.domain.UserBean;
import com.bird.service.TopicService;
import com.bird.service.UserService;
import com.bird.util.ConstantUtil;
import com.bird.util.DateUtil;
import com.bird.util.TokenUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 主talk内容页面：包括自己的talk和follow者的talk
 * 登录成功后到此页
 * @author 姜志强
 * 2009-11-30
 */
public class HomeTalk extends ActionSupport  implements ModelDriven<TopicBean>, SessionAware, ServletRequestAware {
	private TopicBean topicBean = new TopicBean();
	private UserBean userBean;
	private UserService userService;
	private TopicService topicService;
	Map<String, Object> session;
	HttpServletRequest request;
	
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
	
	public String execute() throws Exception {
		request.setCharacterEncoding("GBK");
		
		Long userId = (Long) session.get(ConstantUtil.USERID);
		String clientToken = request.getParameter("clientToken");
		String sessionToken = (String) session.get("token");
		
		if(session==null||session.size()==0){
			return LOGIN;
		} else if(clientToken==null){	//点击home链接时clientToken==null
			topicBean = new TopicBean();
			topicBean.setUserId(userId);
			Follow follow = new Follow();
			follow.setUserId(userId);
			List<Long> userIdList = userService.getUserIdList(follow);
			
			userIdList.add(userId);
			topicBean.setUserIdList(userIdList);
			List<TopicBean> topicList = topicService.getObjectList(topicBean); 			
			request.setAttribute("topicList", topicList);
			//生成新令牌
			String token = TokenUtil.generateToken(request);
			request.setAttribute("clientToken", token);
			//替换旧令牌
			session.put("token", token);
			return SUCCESS;	
		} else if(sessionToken!=null&&!clientToken.equals(sessionToken)){		//struts2防重复提交
			topicBean.setUserId(userId);
			List<TopicBean> topicList = topicService.getObjectList(topicBean);
			//生成新令牌
			String token = TokenUtil.generateToken(request);
			request.setAttribute("clientToken", token);
			//替换旧令牌
			session.put("token", token);
			request.setAttribute("topicList", topicList);
			return SUCCESS;
		}else{
	    	String userName = (String) session.get(ConstantUtil.USERNAME);
	    	userBean = new UserBean();
	    	userBean.setUserId(userId);
	    	userBean = userService.getUserById(userBean);
	    	
	    	topicBean.setUserId(userId);
	    	topicBean.setUserName(userName);
			Date now = new Date();
			String topicTime = DateUtil.getDateString(now);
			topicBean.setTopicTime(topicTime);
			//未对topicContent,userName,userId进行验证
			int result = topicService.insertObject(topicBean);
			if(result>0){
				Follow follow = new Follow();
				follow.setUserId(userId);
				List<Long> userIdList = userService.getUserIdList(follow);
				userIdList.add(userId);
				topicBean.setUserIdList(userIdList);
				List<TopicBean> topicList = topicService.getObjectList(topicBean);
				//生成新令牌
				String token = TokenUtil.generateToken(request);
				request.setAttribute("clientToken", token);
				//替换旧令牌
				session.put("token", token);
				request.setAttribute("topicList", topicList);
				return SUCCESS;
			}else{
				return ERROR;
			}
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

	public TopicBean getModel() {
		return topicBean;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	
}
