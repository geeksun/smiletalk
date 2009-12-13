package com.bird.action;

import java.util.List;

import com.bird.domain.TopicBean;
import com.bird.domain.UserBean;
import com.bird.service.TopicService;
import com.bird.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 查找想找的人名:返回user的信息、最新一条topic的信息
 * @author 姜志强
 *2009-12-12
 */
public class FindPeople extends ActionSupport implements ModelDriven<UserBean>{
	private UserBean userBean = new UserBean();
	private TopicBean topicBean;
	private UserService userService;
	private TopicService topicService;
	private List<UserBean> userList;
	
	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute() throws Exception {
		//String userName = userBean.getUserName();
		if(userBean!=null){
			userList = userService.getObjectList(userBean);
			if(userList.size()==0){
				userList = null;
			}else{
				for(UserBean usrBean:userList){		//取用户的最新一条talk记录
					long userId = usrBean.getUserId();
					topicBean = new TopicBean();
					topicBean.setUserId(userId);
					topicBean = topicService.getRecentTopic(topicBean);
					usrBean.setTopicBean(topicBean);
				}
				
			}
			
			return SUCCESS;
		}else{
			return INPUT;
		}
		
	}

	public List<UserBean> getUserList() {
		return userList;
	}

	public void setUserList(List<UserBean> userList) {
		this.userList = userList;
	}

	public UserBean getModel() {
		return userBean;
	}

	public TopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

}
