<%@ page language="java"  import="java.util.*,com.bird.domain.*" pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<jsp:include page="top.jsp"/>
</style>
<% 
	String username = (String)session.getAttribute("userName");
	String path = request.getContextPath();
	if(username==null){
 %>
	您还没有登录，请先<a href="<%=path%>/login.jsp">登录 iTalk</a>
	<% 
	}
	else{
	UserBean userBean = (UserBean)request.getAttribute("userBean");
	%>
<body>
<p></p>
基本信息：
<form action="settingInfo.action" name="iTalk" method="post">
	<table width="49%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#99CCFF">
		<tr>
			<td align="right">头像： </td><td><input type="file" name="headPhoto"></td>
		</tr>
		<tr>
			<td align="right">个人空间： </td><td></td>
		</tr>
		<tr>
			<td align="right">
				<span class="style1">呢称：</span></td><td><font color="#9900FF"><%=userBean.getUserName()%></font>
			</td>
		</tr>
		<tr>
			<td align="right">性别： </td><td></td>
		</tr>
		<tr align="center" >
			<td align="right">生日： </td><td></td>
		</tr>
		<tr align="center" >
			<td align="right">地区： </td><td></td>
		</tr>
		<tr align="center" >
			<td align="right">
				<span class="style1">注册时间：</span></td><td align="left"><font color="#9900FF"><%=userBean.getRegTime()%></font>
			</td>
		</tr>
		
		
		<tr align="center">
			<td colspan="2"><input type="submit" value=" 保 存 "></td>
		</tr>
	</table>
	
</form>
</body>
	 <% 
	   }
	 %>
<p align="center">
<%@ include file="foot.jsp" %>
</p>

