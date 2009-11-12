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
 *  URL ���ʿ���
 *  2009-11-12
 */
public class AccessPurviewFilter extends HttpServlet implements Filter {
	
	/**  
	 *  �ض����URL  
	 */  
	private String redirectURl = null;

	public void doFilter(ServletRequest arg0, ServletResponse sRequest,
			FilterChain sResponse) throws IOException, ServletException {
 		 HttpServletRequest request = (HttpServletRequest) sRequest;   
         HttpServletResponse response = (HttpServletResponse) sResponse;   
         HttpSession session = request.getSession();   
   
         // ����ػ��е��û�Ϊ��,ҳ�����¶��򵽵�½ҳ��   
         if (session.getAttribute("userName") == null) {   
             response.sendRedirect(redirectURl);   
         }   
         // �Ự�д����û�������֤�û��Ƿ���ڵ�ǰҳ���Ȩ��   
         /*else {
             User user = (User) session.getAttribute(UserAction.CURRENT_USER);   
             try {   
                 // ����û�û�е�ǰҳ��Ȩ��,ҳ�����¶��򵽵�½ҳ��   
                 if ("0".equals(allowRole) || user.hasPower(allowRole)) {   
                     filterChain.doFilter(sRequest, sResponse);   
                 } else {   
                     // �������������˺󣬹��������������������Ӧ   
                     response.sendRedirect(redirectURl);   
                 }   
             } catch (Throwable e) {   
                 LOG.error("Ȩ�޹���ʱ����ִ���", e);   
                 throw new RuntimeException("Ȩ�޹���ʱ����ִ���", e);   
             }
         }*/
	}
	
	public void init(FilterConfig arg0) throws ServletException {
		redirectURl = "/login.jsp"; 
	}
	
	
}
