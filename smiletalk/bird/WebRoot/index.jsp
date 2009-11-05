<%@ page contentType="text/html; charset=UTF-8" %> 
<%
	String path = request.getContextPath();
%>
<html>
  <head>
   <title>用户管理</title>
  </head>
 <frameset rows="103,*" cols="*" frameborder="no"   border="0" framespacing="0" >
	  <frame src="<%=path%>/frame/top.jsp" name="top" scrolling="no" id="top" noresize>
      <frame src="<%=path%>/frame/iTalk.jsp" name="left" scrolling="auto" noresize >
	  <frame src="<%=path%>/frame/foot.jsp" name="foot" scrolling="no" id="top" noresize>
 </frameset>
 <noframes>
	<body>
		您的浏览器不支持Frame,无法使用本系统
	</body>
 </noframes>
</html>