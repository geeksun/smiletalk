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
<form action="newTalk.action" name="iTalk" method="post">
	<table width="49%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#99CCFF">
		<tr align="center" >
			<td align="left">
				<span class="style1">�û���</span><font color="#9900FF"><%=userBean.getUserName()%></font>
			</td>
		</tr>
		<tr align="center" >
			<td align="left">
				<span class="style1">ע��ʱ�䣺</span><font color="#9900FF"><%=userBean.getRegTime()%></font>
			</td>
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

