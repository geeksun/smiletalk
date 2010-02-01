package com.bird.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bird.domain.FollowBean;
import com.bird.domain.TopicBean;
import com.bird.domain.UserBean;
import com.bird.service.TopicService;
import com.bird.service.UserService;
import com.bird.util.ConstantUtil;
import com.bird.util.DateUtil;
import com.bird.util.StringUtil;
import com.bird.util.TokenUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ���뻹�����Ż�
 * ��talk����ҳ�棺�����Լ���talk��follow�ߵ�talk
 * ��¼�ɹ��󵽴�ҳ
 * @author ��־ǿ
 * 2009-11-30
 */
public class HomeTalk extends ActionSupport  implements SessionAware, ServletRequestAware {
	private String topicContent;
	private TopicBean topicBean;
	private UserBean userBean;
	private List<TopicBean> topicList;
	private UserService userService;
	private TopicService topicService;
	Map<String, Object> session;
	HttpServletRequest request;
	
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
	
	public String execute() throws Exception {
		request.setCharacterEncoding("GBK");
		
		if(session==null||session.size()==0) {		// ��ҳֱ�ӵ�½
			String userName = null,password = null;
			//�ж�cookie��Ϣ
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().equals("usrCookie")) {
						userName = cookies[i].getValue();
					}else if(cookies[i].getName().equals("pwdCookie")){
						password = cookies[i].getValue();
					}
				}
				userBean = new UserBean();
				userBean.setUserName(userName);
				userBean.setPassword(password);
				userBean = userService.loginUser(userBean);	
				if(userBean!=null){
					session.put(ConstantUtil.USER, userBean);
					Long userId = userBean.getUserId();
					FollowBean follow = new FollowBean();
					follow.setUserId(userId);
					List<Long> userIdList = userService.getUserIdList(follow);
					
					userIdList.add(userId);
					
					//������ʾ��ͼƬ·��
					Map<String, String> photoPathMap = new HashMap<String, String>();
					for(long usrId:userIdList){
						UserBean usrBean = new UserBean();
						usrBean.setUserId(usrId);
						usrBean = userService.getUserById(usrBean);
						String usrName = usrBean.getUserName();
						String photoPath = usrBean.getPhotoPath();
						photoPathMap.put(usrName, photoPath);
					}
					
					topicBean = new TopicBean();
					topicBean.setUserId(userId);
					topicBean.setUserIdList(userIdList);
					topicList = topicService.getObjectList(topicBean); 		
					for(TopicBean topic:topicList){
						String usrName = topic.getUserName();
						//String topicContent = topic.getTopicContent();
						if(photoPathMap.containsKey(usrName)){
							String photoPath = photoPathMap.get(usrName);
							topic.setPhotoPath(photoPath);
						}
						/*if(topicContent.contains("&lt;")){
							topicContent = topicContent.replaceAll("&lt;", replacement);						
						}*/
						
					}				
					
					//����������
					String token = TokenUtil.generateToken(request);
					request.setAttribute("clientToken", token);
					//�滻������
					session.put("token", token);
					
					return SUCCESS;	
				}else{
					return LOGIN;
				}
			}else{
				return LOGIN;
			}
		} else {
			userBean = (UserBean) session.get(ConstantUtil.USER);
			Long userId = userBean.getUserId();
			String clientToken = request.getParameter("clientToken");
			String sessionToken = (String) session.get("token");
			
			if(clientToken==null){				//���home���ӻ�ӵ�½���ӹ���, clientToken==null
				FollowBean follow = new FollowBean();
				follow.setUserId(userId);
				List<Long> userIdList = userService.getUserIdList(follow);
				
				userIdList.add(userId);
				
				//����italk��ҳ���ǰ����ʾ��ͼƬ·��
				Map<String, String> photoPathMap = new HashMap<String, String>();
				for(long usrId:userIdList){
					UserBean usrBean = new UserBean();
					usrBean.setUserId(usrId);
					usrBean = userService.getUserById(usrBean);
					String usrName = usrBean.getUserName();
					String photoPath = usrBean.getPhotoPath();
					photoPathMap.put(usrName, photoPath);
				}
				
				topicBean = new TopicBean();
				topicBean.setUserId(userId);
				topicBean.setUserIdList(userIdList);
				topicList = topicService.getObjectList(topicBean); 		
				for(TopicBean topic:topicList){
					String usrName = topic.getUserName();
					if(photoPathMap.containsKey(usrName)){
						String photoPath = photoPathMap.get(usrName);
						topic.setPhotoPath(photoPath);
					}
				}				
				
				//����������
				String token = TokenUtil.generateToken(request);
				request.setAttribute("clientToken", token);
				//�滻������
				session.put("token", token);
				return SUCCESS;	
			} else if(sessionToken!=null&&!clientToken.equals(sessionToken)){			// �ظ��ύ����
				FollowBean follow = new FollowBean();
				follow.setUserId(userId);
				List<Long> userIdList = userService.getUserIdList(follow);
				
				userIdList.add(userId);
				//����italk��ҳ���ǰ����ʾ��ͼƬ·��
				Map<String, String> photoPathMap = new HashMap<String, String>();
				for(long usrId:userIdList){
					UserBean usrBean = new UserBean();
					usrBean.setUserId(usrId);
					usrBean = userService.getUserById(usrBean);
					String usrName = usrBean.getUserName();
					String photoPath = usrBean.getPhotoPath();
					photoPathMap.put(usrName, photoPath);
				}
				topicBean = new TopicBean();
				topicBean.setUserId(userId);
				topicBean.setUserIdList(userIdList);
				topicList = topicService.getObjectList(topicBean);
				//��italk��ҳ���ǰ����ʾ��ͼƬ·��set��topicBean
				for(TopicBean topic:topicList){
					String usrName = topic.getUserName();
					if(photoPathMap.containsKey(usrName)){
						String photoPath = photoPathMap.get(usrName);
						topic.setPhotoPath(photoPath);
					}
				}
				
				//����������
				String token = TokenUtil.generateToken(request);
				request.setAttribute("clientToken", token);
				//�滻������
				session.put("token", token);
				//request.setAttribute("topicList", topicList);
				return SUCCESS;
			}else{										// �����ύ�Ĵ���
		    	String userName = userBean.getUserName();
		    	topicBean = new TopicBean();
		    	topicBean.setUserId(userId);
		    	topicBean.setUserName(userName);
		    	topicContent = StringUtil.htmlencode(topicContent);
		    	topicBean.setTopicContent(topicContent);
				Date now = new Date();
				String topicTime = DateUtil.getDateString(now);
				topicBean.setTopicTime(topicTime);

				int result = topicService.insertObject(topicBean);
				if(result>0){
					FollowBean follow = new FollowBean();
					follow.setUserId(userId);
					List<Long> userIdList = userService.getUserIdList(follow);
					
					userIdList.add(userId);
					
					//����italk��ҳ���ǰ����ʾ��ͼƬ·��
					Map<String, String> photoPathMap = new HashMap<String, String>();
					for(long usrId:userIdList){
						UserBean usrBean = new UserBean();
						usrBean.setUserId(usrId);
						usrBean = userService.getUserById(usrBean);
						String usrName = usrBean.getUserName();
						String photoPath = usrBean.getPhotoPath();
						photoPathMap.put(usrName, photoPath);
					}
					
					topicBean.setUserIdList(userIdList);
					topicList = topicService.getObjectList(topicBean);
					for(TopicBean topic:topicList){
						String usrName = topic.getUserName();
						if(photoPathMap.containsKey(usrName)){
							String photoPath = photoPathMap.get(usrName);
							topic.setPhotoPath(photoPath);
						}
					}
					
					//����������
					String token = TokenUtil.generateToken(request);
					request.setAttribute("clientToken", token);
					//�滻������
					session.put("token", token);
					return SUCCESS;
				}else{
					return ERROR;
				}
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

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public List<TopicBean> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<TopicBean> topicList) {
		this.topicList = topicList;
	}

	public String getTopicContent() {
		return topicContent;
	}

	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}
	
	
}