package com.bird.action;

import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.ambow.log.timer.LogProcess;
import com.ambow.log.vo.DataLogVo;
import com.bird.domain.TopicBean;
import com.bird.domain.UserBean;
import com.bird.service.TopicService;
import com.bird.util.ConstantUtil;
import com.bird.util.DateUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * talk topic-发布话题
 * @author jzq
 *  beta 0.1
 *  2009-11-9
 */
public class NewTalk extends ActionSupport implements ServletRequestAware,SessionAware,ServletResponseAware{
	private TopicBean topicBean;
	private TopicService topicService;
	Map<String, Object> session;
	HttpServletRequest request;
	HttpServletResponse response;
	
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public String execute() throws Exception{
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		response.setHeader("Cache-Control", "no-cache");
		
		if(session==null||session.size()==0){
			return LOGIN;
		}
		
		UserBean user = (UserBean) session.get(ConstantUtil.USER);
		Long userId = user.getUserId();
		String content = request.getParameter("content");
		content = URLDecoder.decode(content, "UTF-8");
		String userName = user.getUserName();
		topicBean = new TopicBean();
    	topicBean.setUserId(userId);
    	topicBean.setUserName(userName);
    	topicBean.setTopicContent(content);
		Date now = new Date();
		String topicTime = DateUtil.getDateString(now);
		topicBean.setTopicTime(topicTime);
		
		PrintWriter out = response.getWriter();
		int result = topicService.insertObject(topicBean);
		if(result>0){
			// 数据日志代码开始
			DataLogVo dataLog = new DataLogVo();
			//模块ID 查ACT_Module表
			dataLog.setModuleId(11);
			//操作者ID 用户ID
			dataLog.setOptId(String.valueOf(userId));
			//操作类型 自定义,如：新增、修改、删除
			dataLog.setOptType("发布信息");
			//操作时间
			dataLog.setOptTime(new Date());
			//访问者IP
			dataLog.setIpAddress(request.getRemoteAddr());
			//原始数据
			dataLog.setOriginalData("");
			//改动后数据
			dataLog.setChangesData(content);
			//对象ID  如新增或编辑用户，ID就是userName
			dataLog.setObjId("content");
			//备注（操作的补充信息）
			dataLog.setRemark("");
			LogProcess.logList.add(dataLog);
			// 日志代码结束
			
			out.print("1");
		}else{
			out.print("0");
		}
		out.close();
		return null;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}


}
