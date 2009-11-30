<%@ page language="java"  import="java.util.*,com.bird.domain.*,com.bird.util.*" pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<jsp:include page="top.jsp"/>
<style>
.style1 {
	color: green; 
	font-weight: bold;
}
</style>
 
<% 
	String username = (String)session.getAttribute("userName");
	String path = request.getContextPath();
	if(username==null){
 %>
	您还没有登录，请先登录
	<% 
	}
	else{
	%>
<% 
	List topicList = (List)request.getAttribute("topicList");
%>

<!-- ×* -->
<body><br>
	<table width="49%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#99CCFF">
		<%
		   if(topicList!=null){
		   	for(int i=0;i<topicList.size();i++){
		   		TopicBean tbean = (TopicBean)topicList.get(i);
		   		if(tbean!=null){
		%>
		<tr align="center" >
			<td align="left">
				<span class="style1"><%=tbean.getUserName()%></span>  <font color="#9900FF"><%=tbean.getTopicTime()%></font>
			</td>
		</tr>
		<tr>
			<td>
				<%= tbean.getTopicContent()%>
			</td>
		</tr>
		<% 
				}
			}
		}
		 %>
	</table>
	 <% 
	   }
	 %>
</body>

<p align="center">
<%@ include file="foot.jsp" %>
</p>