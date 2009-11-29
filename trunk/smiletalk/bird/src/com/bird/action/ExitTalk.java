package com.bird.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 姜志强
 * 用户退出登录
 * 2009-11-29
 */
public class ExitTalk extends ActionSupport implements SessionAware {
	Map<String, Object> session;

	public String execute() throws Exception {
		if(session!=null&&session.size()>0){
			session.clear();
			session = null;
		}
		return LOGIN;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
