<%@ page language="java"  pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<% 
	String email = (String)request.getAttribute("email");
	String mailSite = (String)request.getAttribute("mailSite");
%>
<p>
	�ʼ��Ѿ����ͳɹ����뵽<a href="<%=mailSite%>"  target="_blank"><%=email%></a>�鿴��

</p>