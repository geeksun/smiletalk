<%@ page language="java"  import="java.util.*,com.bird.domain.*" pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<jsp:include page="top.jsp"/>
</style>
<% 
	String username = (String)session.getAttribute("userName");
	String path = request.getContextPath();
	if(username==null){
 %>
	����û�е�¼������<a href="<%=path%>/login.jsp">��¼ iTalk</a>
	<% 
	}
	else{
	UserBean userBean = (UserBean)request.getAttribute("userBean");
	%>
<body>
<p></p>
������Ϣ��
<form action="settingInfo.action" name="iTalk" method="post">
	<table width="49%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#99CCFF">
		<tr>
			<td align="right">ͷ�� </td><td><input type="file" name="headPhoto"></td>
		</tr>
		<tr>
			<td align="right">���˿ռ䣺 </td><td></td>
		</tr>
		<tr>
			<td align="right">
				<span class="style1">�سƣ�</span></td><td><font color="#9900FF"><%=userBean.getUserName()%></font>
			</td>
		</tr>
		<tr>
			<td align="right">�Ա� </td><td></td>
		</tr>
		<tr align="center" >
			<td align="right">���գ� </td><td></td>
		</tr>
		<tr align="center" >
			<td align="right">������ </td><td></td>
		</tr>
		<tr align="center" >
			<td align="right">
				<span class="style1">ע��ʱ�䣺</span></td><td align="left"><font color="#9900FF"><%=userBean.getRegTime()%></font>
			</td>
		</tr>
		
		
		<tr align="center">
			<td colspan="2"><input type="submit" value=" �� �� "></td>
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

