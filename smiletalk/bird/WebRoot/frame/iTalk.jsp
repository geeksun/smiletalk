<%@ page language="java"  import="java.util.*,com.bird.domain.*,com.bird.util.*" pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="top.jsp"/>
<style>
.style1 {
	color: green;
	font-weight: bold;
}
</style>
<% 
	String clientToken = (String)request.getAttribute("clientToken");
	clientToken = clientToken==null?"":clientToken;
 %>
 
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
qq
<% 
   }
 %>
<body >
<form action="newTalk.action" name="iTalk" method="post">
	<table width="49%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#99CCFF">
		<tr align="center" >
			<td>What are you doing?record here↓                     还可以输入<span id="validNum">140</span>字</td>
		</tr>
		<tr  align="center">
			<td>
				<textarea name="topicContent" id="topicContent" rows="4" cols="60" maxlength='140' onKeyDown="checkLength()"
				 onKeyUp="checkLength()" onPaste="checkLength()" style="overflow:hidden"></textarea>
			</td>
		</tr>
		<tr align="center">
			<td><input type="button" onclick="justTalk()" value="  Talk  " > </td>
		</tr>
		<c:forEach var="topicBean" items="${topicList}" >
		<tr align="center" >
			<td align="left">
				<span class="style1">${topicBean.userName}</span>  <font color="#9900FF">${topicBean.topicTime}</font>
			</td>
		</tr>
		<tr>
			<td>
				${topicBean.topicContent}
			</td>
		</tr>
		</c:forEach>
	</table>
	<input type="hidden" name="clientToken" value="<%=clientToken%>" />
</form>
</body>
 
<script>
	function checkLength(){
		var value = document.getElementById("topicContent").value;
		if(value.length>140){
			document.getElementById("topicContent").value=document.getElementById("topicContent").value.substr(0, 140);
		}else{
			document.getElementById("validNum").innerHTML = 140 - value.length;
		}
	}	 
	function checkTalk(){
		var a = document.iTalk.topicContent;
		str = a.value.replace(/\s+/g,"");
		if(str==''){
			alert("输入不可为空!");
			a.value = '';
			a.focus();
		   	return false;
		}
        if(a.value.length > 140)
		{
		   	alert("输入的长度不能超过140个字符!");
		   	a.focus();
		   	return false;
		}
		return true;
	}
	function justTalk(){
		if(checkTalk()){
			document.iTalk.submit();
		}
	}
</script>
<p align="center">
<%@ include file="foot.jsp" %>
</p>