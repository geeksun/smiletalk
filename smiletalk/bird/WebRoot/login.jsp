<%@ page language="java" import="javax.servlet.http.Cookie" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>��¼ - iTalk</title>

</head>
<body>
	<% 
	Cookie cookies[] = request.getCookies(); 
	Cookie cookie = null; 
	String cookieName = null; 
	String userName = "";
	String password = ""; 
	if(cookies!=null){
		for(int i=0;i<cookies.length;i++){
			cookie = cookies[i]; 
			cookieName = cookie.getName();
			if(cookieName.equals("usrCookie")){
				userName = cookie.getValue();
			}
			else if(cookieName.equals("pwdCookie")){
				password = cookie.getValue();
			}
		}	
	}
	
 	%>
	<p></p>
	<p align="center">
	iTalk �û���¼
	</p>
	<form action="talkLogin.action" method="post" name="iTalkLogin">
		<table align="center">
			<tr>
				<td colspan=2 align="center"><font color="red">${userBean.errorMessage}</font></td>
			</tr>
			<tr>
				<td>
					�û�����
				</td>
				<td>
					<input type="text" name="userName" id="userName" value="<%=userName%>" size="12">
				</td>
			</tr>
			<tr>
				<td>
					�� �룺
				</td>
				<td>
					<input type="password" name="password" id="password" value="<%=password%>" size="12">
				</td>
			</tr>
			<tr>
				<td colspan=2><input type="checkbox" name="autoLogin" value="1" checked>��ס��¼״̬&nbsp;<a href="forgetPwd.jsp">��������</a></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="iTalksub" value="��¼ iTalk" >
					<a href="register.jsp">ע�� iTalk</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>