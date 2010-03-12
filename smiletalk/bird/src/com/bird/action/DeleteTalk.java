package com.bird.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.bird.service.TopicService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author jzq
 * 删除一条话题记录
 * 2010-3-12
 */
public class DeleteTalk extends ActionSupport implements ServletRequestAware, ServletResponseAware{
	HttpServletRequest request;
	HttpServletResponse response;
	private TopicService topicService;

	public TopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
	
	public String execute() throws Exception{
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		response.setHeader("Cache-Control", "no-cache");
		
		String tid = request.getParameter("tid");
		
		PrintWriter out = response.getWriter();
		
		out.print("w");
		
		return null;
	}

	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

}
