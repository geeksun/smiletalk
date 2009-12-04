<%@ page contentType="text/html; charset=gbk" %> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title></title>
		<style type="text/css">
		<!--
		.STYLE2 {font-size: 12px}
		-->
		</style>
	</head>
	<body>
		<%
			String path = request.getContextPath();
			String guest = (String)session.getAttribute("userName");
			guest = guest == null?"guest":guest;
		 %>
		
		<p align=center>
<table width="90%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><img src="<%=path%>/images/beta/logo.JPG" alt="logo" width="212" height="65" /><br><%=guest%>，欢迎您使用 iTalk</td>
    <td valign="bottom" width="75%" align="right">
        <a href="homeTalk.action">Home</a>&nbsp;<a href="storageTalk.action">Profile</a>&nbsp;<a href="findPeople.jsp">Find People</a>&nbsp;<a href="settingsTalk.action">Settings</a>&nbsp;<a href="">Help</a>&nbsp;<%if(guest!="guest"){%><a href="exitTalk.action">Sign out</a><%}else{%><a href="<%=path%>/login.jsp">Sign in</a><%}%>
    </td>
  </tr>
</table>
<table width="780" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="15%">&nbsp;</td>
    <td class="STYLE2">点滴记录 存储人生</td>
    <td width="71%"><hr size="1" /></td>
  </tr>
</table>
</p>
		
	</body>
</html>



