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
 *  URL ���ʿ��ƹ�����
 *  2009-11-12
 */
public class AccessPurviewFilter extends HttpServlet implements Filter {
	
	/**  
	 *  �ض����URL  
	 */  
	private String redirectURl = null;
	 /**  
      * ��������Ľ�ɫ  
      */  
	//private String allowRole = null; 

   /**   doFilter�����ĵ�һ������ΪServletRequest���󡣴˶�����������ṩ�˶Խ������Ϣ������
	*    �����ݡ�cookie��HTTP����ͷ������ȫ���ʡ��ڶ�������ΪServletResponse��ͨ���ڼ򵥵Ĺ�
	*    �����к��Դ˲��������һ������ΪFilterChain���˲�����������servlet��JSPҳ��
	*    -- �������HTTP���󣬲�����Ҫ��������getHeader��getCookies����ServletRequest��
	*    �޷��õ��ķ�������Ҫ�Ѵ�request�������HttpServletRequest
	*/
	public void doFilter(ServletRequest sRequest, ServletResponse sResponse,
			FilterChain filterChain) throws IOException, ServletException {
 		 HttpServletRequest request = (HttpServletRequest) sRequest;   
         HttpServletResponse response = (HttpServletResponse) sResponse;   
         HttpSession session = request.getSession();   
   
         // ����ػ��е��û���Ϊ��,ҳ�����¶��򵽵�½ҳ��   
         if (session.getAttribute("userName") == null) {
        	 String contextPath  = request.getContextPath();
        	 String currentPath = request.getRequestURI(); 		//��ǰ���������·��
        	 //System.out.println("contextPath:"+contextPath+" currentPath:"+currentPath);
             response.sendRedirect(contextPath  + redirectURl);   
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
         
         /*if (!checkUserPopedom(request, response, contextPath, currentPath)) {     //��鵱ǰ���ʵ�·���Ƿ�����ڴ��û���Ȩ���б��У����������return��ȥ����������һ���ĵ���
             return;
         }
         filterChain.doFilter(sRequest, sResponse);*/
	}
	
/*	private boolean checkUserPopedom(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String contextPath, String currentPath) throws IOException {
        User user = (User) httpServletRequest.getSession(true).getAttribute("user");

        if (user == null) {
            httpServletResponse.sendRedirect(contextPath + "/");
            return false;
        } else {
            if (!checkPopedom(user, contextPath, currentPath)) {
                httpServletResponse.sendRedirect(contextPath + "/");
                return false;
            }
        }

        return true;
    }

    private boolean checkPopedom(User user, String contextPath, String currentPath) {
        if (user.getSystemResourceList() != null) {
            for (SystemResource resource : user.getSystemResourceList()) {
                String url = contextPath + resource.getActionUrl().trim();
                if (url.equals(currentPath)) {
                    return true;
                }
            }
        }
        return false;
    }*/
	
	public void init(FilterConfig arg0) throws ServletException {
		// �õ�����Ľ�ɫ,�����������web.xml���allowRole��ָ��   
		//allowRole = filterConfig.getInitParameter("allowRole");    
		redirectURl = "/login.jsp"; 
		
	}
	
	
}
