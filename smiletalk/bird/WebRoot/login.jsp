<%@ page language="java" import="javax.servlet.http.Cookie" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>��¼ - iTalk</title>

</head>
<body>
	<% 
	Cookie cookies[] = request.getCookies(); 
	Cookie cookie = null; 
	String cookieName = null; 
	String iTalkName = "";
	String iTalkpwd = ""; 
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
 	%>
	<p></p>
	<p align="center">
	iTalk �û���¼
	</p>
	<form action="iTalkLogin.htm" method="post" name="iTalkLogin">
		<table align="center">
			<tr>
				<td>
					�û�����
				</td>
				<td>
					<input type="text" name="iTalkName" id="iTalkName" value="<%=iTalkName%>" size="12">
				</td>
			</tr>
			<tr>
				<td>
					�� �룺
				</td>
				<td>
					<input type="password" name="iTalkpwd" id="iTalkpwd" value="<%=iTalkpwd%>" size="12">
				</td>
			</tr>
			<tr>
				<td colspan=2><input type="checkbox" name="autoLogin" value="1" checked>��ס��¼״̬</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="iTalksub" value="��¼ iTalk" >
					<a href="register.html">ע�� iTalk</a>
				</td>
			</tr>
			<input type="hidden" name="iTalkAct" value="iTalkLogin">
		</table>
	</form>
</body>
</html>