package com.bird.interceptor;

/*
import com.ambow.log.db.DataBaseUtil;
import com.ambow.log.timer.LogProcess;
import com.ambow.log.util.LogUtil;
import com.ambow.log.vo.ActionModuleVo;
import com.ambow.log.vo.OperateLogVo;
*/
import java.net.URLDecoder;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.bird.domain.UserBean;
import com.bird.util.ConstantUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class LogInterceptor extends AbstractInterceptor {

	@Override
	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String method = invocation.getProxy().getMethod();
		
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		
		final Map<String, Object> parameters = invocation
        .getInvocationContext().getParameters();
		StringBuilder sb_key = new StringBuilder();
		StringBuilder sb_value = new StringBuilder();
		/**
	    for(Map.Entry<String,Object> entry:parameters.entrySet()){
        	String key = (String) entry.getKey();
        	// check key
        	if(LogUtil.isAvailable(key)){
            	//sb.append("key:");
        		sb_key.append(key);
        		sb_key.append("，");
            	
        		if(entry.getValue() instanceof String[]){
        			String[] values = (String[]) entry.getValue();
                	//sb.append("value:");
                	for(String value:values){
                		sb_value.append(value);
                		sb_value.append("，");
                	}
        		}else{
                	System.out.println("entry.getValue():"+entry.getValue());
        			sb_value.append(entry.getValue());
            		sb_value.append("，");
        		}
        	}
        }
	    String parameterStr = sb_key.toString();
	    if(!LogUtil.isBlank(parameterStr)){
	    	parameterStr = parameterStr.substring(0, parameterStr.length()-1);
	    	parameterStr = URLDecoder.decode(parameterStr, "UTF-8");
	    }
	    String valueStr = sb_value.toString();
	    if(!LogUtil.isBlank(valueStr)){
	    	valueStr = valueStr.substring(0, valueStr.length()-1);
	    	valueStr = URLDecoder.decode(valueStr, "UTF-8");
	    }
	    
	    String ip = request.getRemoteAddr();
	    
	    // 判断用户是否已登录
		UserBean user = (UserBean) session.get(ConstantUtil.USER);
		
        if (user != null) {
        	String url = request.getRequestURI();
        	ActionModuleVo actionModuleVo = DataBaseUtil.findActionModule(url);
        	if(actionModuleVo!=null){		
        		// operate log
        		OperateLogVo operLog = new OperateLogVo();
        		operLog.setOptId(String.valueOf(user.getUserId()));
        		StringBuilder logContent = new StringBuilder();
        		logContent.append("用户");
        		logContent.append(user.getUserName());
        		logContent.append("访问模块\"");
        		logContent.append(actionModuleVo.getActionCn());
        		logContent.append("\"，访问的URL是\"");
        		logContent.append(url);
        		logContent.append("\"，方法是\"");
        		logContent.append(method);
        		logContent.append("\"，参数\"");
        		logContent.append(parameterStr);
        		logContent.append("\"，参数值\"");
        		logContent.append(valueStr);
        		logContent.append("\"");
        		operLog.setOptContent(logContent.toString());
        		operLog.setOptTime(new Date());
            	operLog.setIpAddress(ip);
            	operLog.setUrl(url);
            	operLog.setModuleId(actionModuleVo.getModuleId());
            	
            	LogProcess.logList.add(operLog);
        	}
        }
        */
        return invocation.invoke();
	}

}
