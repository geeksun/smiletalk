<%@ page language="java"  import="java.util.*,com.bird.vo.*" pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<jsp:include page="top.jsp"/>

<% 
	String username = (String)session.getAttribute("username");
	String path = request.getContextPath();
	if(username==null){
 %>
	您还没有登录，请先<a href="<%=path%>/login.html">登录 iTalk</a>
	<% 
	}
	else{
	 %>
	 <script src="<%=path%>/js/prototype.js"></script> 
<% 
	List topicList = (List)request.getAttribute("topicList");
 %>

<!-- ×* -->
<form action="NewTalk.htm" name="iTalk" method="post">
	<table width="40%"  align="center">
		<tr align="center" >
			<td>What are you doing?record here↓                     还可以输入<span id="validNum">140</span>字</td>
		</tr>
		<tr  align="center" >
			<td>
				<textarea name="talkTopic" id="talkTopic" rows="4" cols="60" maxlength='140' onKeyDown="checkLength()"
				 onKeyUp="checkLength()" onPaste="checkLength()"></textarea>
			</td>
		</tr>
		<tr align="center">
			<td><input type="button" onclick="justTalk()" value="Talk" ></td>
		</tr>
		
		<%
		   if(topicList!=null){
		   	for(int i=0;i<topicList.size();i++){
		   		TopicBean tbean = (TopicBean)topicList.get(i);
		   		if(tbean!=null){
		%>
		<tr align="center" >
			<td align="left">
				<font color="red"><%=tbean.getUsername()%></font>  <font color="blue"><%=tbean.getTopicTime()%></font> Speaking
			</td>
		</tr>
		<tr align="center" >
			<td>
				<%= tbean.getTopicContent()%>
				<hr>
			</td>
		</tr>
		<% 
				}
			}
		}
		 %>
	</table>
	<input type="hidden" name="iTalkAct" value="iTalkTopic">
</form>
 <% 
   }
 %>
<script>
	function checkLength(){
		var value = document.getElementById("talkTopic").value;
		if(value.length>140){
			document.getElementById("talkTopic").value=document.getElementById("talkTopic").value.substr(0, 140);
		}else{
			document.getElementById("validNum").innerHTML = 140 - value.length;
		}
	}	 
	function checkTalk(){
		var a = document.iTalk.talkTopic;
        if(a.value.length > 140)
		{
		   alert("输入的长度不能超过140个字符!");
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