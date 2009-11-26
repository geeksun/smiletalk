package com.bird.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bird.domain.TopicBean;
import com.bird.domain.UserBean;
import com.bird.service.TopicService;
import com.bird.service.UserService;
import com.bird.service.impl.TopicServiceImpl;
import com.bird.service.impl.UserServiceImpl;

/**
 * @author jzq
 *  URL 访问控制过滤器
 *  2009-11-12
 */
public class AccessPurviewFilter extends HttpServlet implements Filter {
	
	/**  
	 *  重定向的URL  
	 */  
	private String redirectURl = null;
	 /**  
      * 配置允许的角色  
      */  
	//private String allowRole = null; 

   /**   doFilter方法的第一个参数为ServletRequest对象。此对象给过滤器提供了对进入的信息（包括
	*    表单数据、cookie和HTTP请求头）的完全访问。第二个参数为ServletResponse，通常在简单的过
	*    滤器中忽略此参数。最后一个参数为FilterChain，此参数用来调用servlet或JSP页。
	*    -- 如果处理HTTP请求，并且需要访问诸如getHeader或getCookies等在ServletRequest中
	*    无法得到的方法，就要把此request对象构造成HttpServletRequest
	*/
	public void doFilter(ServletRequest sRequest, ServletResponse sResponse,
			FilterChain filterChain) throws IOException, ServletException {
 		 HttpServletRequest request = (HttpServletRequest) sRequest;   
         HttpServletResponse response = (HttpServletResponse) sResponse;   
         HttpSession session = request.getSession();   
   
         // 如果回话中的用户名为空,页面重新定向到登陆页面   
         if (session.getAttribute("userName") == null) {
    	 	 //鉴定cookie是否存在
    		/* Cookie cookies[] = request.getCookies(); 
    		 Cookie cookie = null; 
    		 String cookieName = null; 
    		 String iTalkName = "";
    		 String iTalkpwd = ""; 
    		 if(cookies!=null){
    			 for(int i=0;i<cookies.length;i++){
    				 cookie = cookies[i]; 
    				 cookieName = cookie.getName();
    				 if(cookieName.equals("usrCookie")){
    					 iTalkName = cookie.getValue();
    				 }
    				 else if(cookieName.equals("pwdCookie")){
    					 iTalkpwd = cookie.getValue();
    				 }
    			 }
    		 }
    		 UserService userService = new UserServiceImpl();
    		 UserBean userBean = new UserBean();
			 userBean.setUserName(iTalkName);
			 userBean.setPassword(iTalkpwd);
			 userBean = userService.loginUser(userBean);
			 if(userBean!=null) {
				 session.setAttribute("userName", userBean.getUserName());
				 long userId = userBean.getUserId();
				 session.setAttribute("userId", userId);
				 TopicService topicService = new TopicServiceImpl();
				 TopicBean topicBean = new TopicBean();
				 topicBean.setUserId(userId);
				 List<TopicBean> topicList = topicService.getObjectList(topicBean); 			
				 request.setAttribute("topicList", topicList);
				 request.getRequestDispatcher("/frame/iTalk.jsp")
						.forward(request, response);			
			 }*/
    		 //鉴定 cookie 结束 
        	 
        	 String contextPath  = request.getContextPath();
        	 String currentPath = request.getRequestURI(); 		//当前正在请求的路径
        	 //System.out.println("contextPath:"+contextPath+" currentPath:"+currentPath);
             response.sendRedirect(contextPath  + redirectURl);
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
         
         /*if (!checkUserPopedom(request, response, contextPath, currentPath)) {     //检查当前访问的路径是否包含在此用户的权限列表中，如果不存在return出去，不进行下一步的调用
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
		// 得到允许的角色,这个参数是由web.xml里的allowRole所指定   
		//allowRole = filterConfig.getInitParameter("allowRole");    
		redirectURl = "/login.jsp"; 
		
	}
	
	
}
