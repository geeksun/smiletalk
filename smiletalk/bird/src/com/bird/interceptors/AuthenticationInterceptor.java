package com.bird.interceptors;

import com.bird.util.ConstantUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.Map;

/**
 * @author geeksun
 * @version : 权限认证的 interceptor
 *  2009-12-3
 */
public class AuthenticationInterceptor implements Interceptor {
	//public static final String USERNAME = "userName";

	/**
	 * 
	 */
	private static final long serialVersionUID = -5632216855718494698L;

	public void destroy() {

	}

	public void init() {

	}

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map session = actionInvocation.getInvocationContext().getSession();
		//UserBean user = (UserBean) session.get(ConstantUtil.USERNAME);
		String userName = (String) session.get(ConstantUtil.USERNAME);
		if (userName == null) {
			return Action.LOGIN;
		} else {
			Action action = (Action) actionInvocation.getAction();
			return Action.ERROR;
		}
	}
	
	
	
}
