<%@ page contentType="text/html; charset=gbk" %> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title></title>
	</head>
	<body>
		<%
			String path = request.getContextPath();
			String guest = (String)session.getAttribute("userName");
			guest = guest == null?"guest":guest;
		 %>
		 
		 <pre> 		<%=guest%>£¬ »¶Ó­ÄúÊ¹ÓÃ iTalk						  <a href="newTalk.action">Home</a>&nbsp;<a href="storageTalk.action">Profile</a>&nbsp;<a href="">Find People</a>&nbsp;<a href="settingTalk.action">Settings</a>&nbsp;<a href="">Help</a>&nbsp;<%if(guest!="guest"){%><a href="exitTalk.action">Sign out</a><%}else{%><a href="<%=path%>/login.jsp">Sign in</a><%}%></pre>
		 
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="FFBB00">
            <tr>
              <td bgcolor="FFFFE6" style="padding:5px 10px 5px 20px "><strong> top</strong></td>
            </tr>
         </table>
	</body>
</html>

