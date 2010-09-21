<%@ page language="java"  pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<% 
	String email = (String)request.getAttribute("email");
	String mailSite = (String)request.getAttribute("mailSite");
%>
<p>
	邮件已经发送成功，请到<a href="<%=mailSite%>"  target="_blank"><%=email%></a>查看。

</p>