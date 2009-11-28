package com.bird.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bird.domain.TopicBean;
import com.bird.service.TopicService;
import com.bird.util.DateUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * talk topic-��������
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
		
		if(session==null){
			return LOGIN;
		}
		else if(sessionToken!=null&&!clientToken.equals(sessionToken)){		//�ظ��ύ,struts2���ظ��ύ��û��,�˴�������
			return null;
		}else{
			String topicContent = topicBean.getTopicContent();
	    	String userName = (String) session.get("userName");
	    	TopicBean topic = new TopicBean();
			topic.setUserId(userId);
			topic.setTopicContent(topicContent);
			topic.setUserName(userName);
			Date now = new Date();
			String topicTime = DateUtil.getDateString(now);
			topic.setTopicTime(topicTime);
			//δ��topicContent,userName,userId������֤
			int result = topicService.insertObject(topic);
			if(result>0){
				topic.setUserId(userId);
				List<TopicBean> topicList = topicService.getObjectList(topic);
				//����������
				String token = generateToken(request);
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
	
	/**
	 * struts   ���ƻ���
	 * @param   request
	 * @return  ��������
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
	 * @return 16���Ƶ��ַ�����ʾ
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

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
