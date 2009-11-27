package com.bird.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bird.domain.TopicBean;
import com.bird.service.TopicService;
import com.bird.service.impl.TopicServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * talk topic-发布话题
 * @author jzq
 *  beta 0.1
 *  2009-11-9
 */
public class NewTalk extends ActionSupport implements ModelDriven<TopicBean>, Preparable {
	private TopicBean topicBean;
	private TopicService topicService;
	
	
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public void setTopicBean(TopicBean topicBean) {
		this.topicBean = topicBean;
	}

	public String execute() throws Exception{
		
		
		return null;
		/*request.setCharacterEncoding("GBK");
		HttpSession session = request.getSession(true);
		
		//String iTalkAct = request.getParameter("iTalkAct");		//iTalk 的动作标记
		
		Long userId = (Long) session.getAttribute("userId");
		String clientToken = request.getParameter("clientToken");
		String sessionToken = (String) session.getAttribute("token");
		TopicBean topic = null;
		TopicService topicService = null;
		
		if(sessionToken!=null&&!clientToken.equals(sessionToken)){		//重复提交
			;
		}else{
			String topicContent = request.getParameter("talkTopic");
	    	String userName = (String) session.getAttribute("userName");
	    	topicService = new TopicServiceImpl();
			topic = new TopicBean();
			topic.setUserId(userId);
			topic.setTopicContent(topicContent);
			topic.setUserName(userName);
			topicService.insertObject(topic);
	    }
	    
		if(topic==null){
			topic = new TopicBean();
		}
		if(topicService == null){
			topicService = new TopicServiceImpl();
		}
		topic.setUserId(userId);
		List<TopicBean> topicList = topicService.getObjectList(topic);
		//生成新令牌
		String token = generateToken(request);
		request.setAttribute("clientToken", token);
		//替换旧令牌
		session.setAttribute("token", token);
		request.setAttribute("topicList", topicList);
		request.getRequestDispatcher("/frame/iTalk.jsp").forward(request, response);*/
	}
	
/*	public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
		throws javax.servlet.ServletException, java.io.IOException{
		return;
	}
	
	public void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
		throws javax.servlet.ServletException, java.io.IOException{
		request.setCharacterEncoding("GBK");
		HttpSession session = request.getSession(true);
		
		//String iTalkAct = request.getParameter("iTalkAct");		//iTalk 的动作标记
		
		Long userId = (Long) session.getAttribute("userId");
		String clientToken = request.getParameter("clientToken");
		String sessionToken = (String) session.getAttribute("token");
		TopicBean topic = null;
		TopicService topicService = null;
		
		if(sessionToken!=null&&!clientToken.equals(sessionToken)){		//重复提交
			;
		}else{
			String topicContent = request.getParameter("talkTopic");
	    	String userName = (String) session.getAttribute("userName");
	    	topicService = new TopicServiceImpl();
			topic = new TopicBean();
			topic.setUserId(userId);
			topic.setTopicContent(topicContent);
			topic.setUserName(userName);
			topicService.insertObject(topic);
	    }
	    
		if(topic==null){
			topic = new TopicBean();
		}
		if(topicService == null){
			topicService = new TopicServiceImpl();
		}
		topic.setUserId(userId);
		List<TopicBean> topicList = topicService.getObjectList(topic);
		//生成新令牌
		String token = generateToken(request);
		request.setAttribute("clientToken", token);
		//替换旧令牌
		session.setAttribute("token", token);
		request.setAttribute("topicList", topicList);
		request.getRequestDispatcher("/frame/iTalk.jsp").forward(request, response);
	}*/
	
	/**
	 * struts 令牌机制
	 * @param request
	 * @return  生成令牌
	 */
	protected String generateToken(HttpServletRequest request) {
       HttpSession session = request.getSession();
       try {
           byte id[] = session.getId().getBytes();
           byte now[] = new Long(System.currentTimeMillis()).toString().getBytes();
           MessageDigest md = MessageDigest.getInstance("MD5");
           md.update(id);
           md.update(now);
           return (toHex(md.digest()));
       } catch (IllegalStateException e) {
           return (null);
       } catch (NoSuchAlgorithmException e) {
           return (null);
       }
	}
	
	/**
	 * @param  buffer
	 * @return 16进制的字符串表示
	 */
	protected String toHex(byte buffer[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buffer.length; i++)
            sb.append(Integer.toHexString((int) buffer[i] & 0xff));
        return (sb.toString());
    }

	public TopicBean getModel() {
		return topicBean;
	}

	public void prepare() throws Exception {
		 /*if (id == null || id.length() == 0)  
			 topicBean = new TopicBean();  
         else  
        	 topicBean = getUserService().getUserById(Integer.parseInt(id)); */
		
	}
	
}
