<%@ page language="java" import="javax.servlet.http.Cookie" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<html>
<head>
<title>登录 - iTalk</title>

</head>
<body>
	<% 
	Cookie cookies[] = request.getCookies(); 
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
	
 	%>
	<p></p>
	<p align="center">
	iTalk 用户登录
	</p>
	<form action="talkLogin.action" method="post" name="iTalkLogin">
		<table align="center">
			<tr>
				<td>
					用户名：
				</td>
				<td>
					<input type="text" name="userName" id="iTalkName" value="<%=iTalkName%>" size="12">
				</td>
			</tr>
			<tr>
				<td>
					密 码：
				</td>
				<td>
					<input type="password" name="password" id="iTalkpwd" value="<%=iTalkpwd%>" size="12">
				</td>
			</tr>
			<tr>
				<td colspan=2><input type="checkbox" name="autoLogin" value="1" checked>记住登录状态&nbsp;<a href="forgetPwd.jsp">忘记密码</a></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="iTalksub" value="登录 iTalk" >
					<a href="register.jsp">注册 iTalk</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>