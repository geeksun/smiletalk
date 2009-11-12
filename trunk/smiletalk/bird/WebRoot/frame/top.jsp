<%@ page contentType="text/html; charset=gbk" %> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title></title>
	</head>
	<body>
		<%
			String path = request.getContextPath();
			String guest = (String)session.getAttribute("username");
			guest = guest == null?"guest":guest;
		 %>
		 
		 <pre> <%=guest%>£¬ »¶Ó­ÄúÊ¹ÓÃ iTalk											  		<a href="<%=path%>/login.jsp">µÇÂ¼iTalk</a></pre>
		 
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="FFBB00">
            <tr>
              <td bgcolor="FFFFE6" style="padding:5px 10px 5px 20px "><strong> top</strong></td>
            </tr>
         </table>
	</body>
</html>

