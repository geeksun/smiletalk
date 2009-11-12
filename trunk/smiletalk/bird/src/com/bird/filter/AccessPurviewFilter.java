package com.bird.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author jzq
 *  URL 访问控制
 *  2009-11-12
 */
public class AccessPurviewFilter extends HttpServlet implements Filter {
	
	/**  
	 *  重定向的URL  
	 */  
	private String redirectURl = null;

	public void doFilter(ServletRequest arg0, ServletResponse sRequest,
			FilterChain sResponse) throws IOException, ServletException {
 		 HttpServletRequest request = (HttpServletRequest) sRequest;   
         HttpServletResponse response = (HttpServletResponse) sResponse;   
         HttpSession session = request.getSession();   
   
         // 如果回话中的用户为空,页面重新定向到登陆页面   
         if (session.getAttribute("userName") == null) {   
             response.sendRedirect(redirectURl);   
         }   
         // 会话中存在用户，则验证用户是否存在当前页面的权限   
         /*else {
             User user = (User) session.getAttribute(UserAction.CURRENT_USER);   
             try {   
                 // 如果用户没有当前页的权限,页面重新定向到登陆页面   
                 if ("0".equals(allowRole) || user.hasPower(allowRole)) {   
                     filterChain.doFilter(sRequest, sResponse);   
                 } else {   
                     // 过滤器经过过滤后，过滤链继续传递请求和响应   
                     response.sendRedirect(redirectURl);   
                 }   
             } catch (Throwable e) {   
                 LOG.error("权限过滤时候出现错误", e);   
                 throw new RuntimeException("权限过滤时候出现错误", e);   
             }
         }*/
	}
	
	public void init(FilterConfig arg0) throws ServletException {
		redirectURl = "/login.jsp"; 
	}
	
	
}
