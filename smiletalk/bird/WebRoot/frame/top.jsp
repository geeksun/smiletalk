<%@ page contentType="text/html; charset=gbk"  import="java.util.*,com.bird.domain.*" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<style type="text/css">
		<!--
		.STYLE2 {font-size: 12px}
		-->
		</style>

		<%
			String userName = null;
			String path = request.getContextPath();
			UserBean userBean = (UserBean)session.getAttribute("user");
			if(userBean!=null){
				userName = userBean.getUserName();
			}
			
		 %>
		
		<p align=center>
<table width="90%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><img src="<%=path%>/images/beta/logo.JPG" alt="logo" width="212" height="65" /><br><% if(userName!=null){  %>  <%=userName%>，欢迎您使用 iTalk<% } %></td>
    <td valign="bottom" width="75%" align="right">																																						
        <a href="homeTalk.action">Home</a>&nbsp;<a href="storageTalk.action">Profile</a>&nbsp;<a href="findPeople.jsp">Find People</a>&nbsp;<a href="settingsTalk.action">Settings</a>&nbsp;<a href="<%=path%>/help.html" target="_blank">Help</a>&nbsp;<%if(userName!=null){%><a href="exitTalk.action">Sign out</a><%}else{%><a href="<%=path%>/login.jsp">Sign in</a><%}%>
    	<a href="randomBrowse.action">随便看一下</a>
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



