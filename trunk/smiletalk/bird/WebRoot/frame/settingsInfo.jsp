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
<form action="settingsInfo.action" name="settingInfo" enctype="multipart/form-data" method="post">
	<table width="49%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#99CCFF">
		<tr>
			<td align="right">ͷ�� </td><td><IMG width=50 height=50 src="<%=userBean.getPhotoPath()%>" />   <input type="file" name="upload" size="30"></td>
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
			<td align="right">�Ա� </td><td><input type="radio" name="sex" value="1" checked>�� <input type="radio" name="sex" value="0">Ů<input type="radio" name="sex" value="2">����</td>
		</tr>
		<tr align="center" >
			<td align="right">���գ� </td><td align="left"><input type="text" name="birthday" size="30" value="<%=userBean.getBirthday()%>"></td>
		</tr>
		<tr align="center" >
			<td align="right">������ </td><td align="left"><input type="text" name="birthday" size="30" value="<%=userBean.getRegion()%>"></td>
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

