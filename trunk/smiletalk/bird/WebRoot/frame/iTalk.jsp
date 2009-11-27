<%@ page language="java"  import="java.util.*,com.bird.domain.*,com.bird.util.*" pageEncoding="gbk" contentType="text/html; charset=gbk"%>
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
	����û�е�¼������<a href="<%=path%>/login.jsp">��¼ iTalk</a>
	<% 
	}
	else{
	%>
<% 
	List topicList = (List)request.getAttribute("topicList");
%>

<!-- ��* -->
<body >
<form action="newTalk" name="iTalk" method="post">
	<table width="49%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#99CCFF">
		<tr align="center" >
			<td>What are you doing?record here��                     ����������<span id="validNum">140</span>��</td>
		</tr>
		<tr  align="center">
			<td>
				<textarea name="talkTopic" id="talkTopic" rows="4" cols="60" maxlength='140' onKeyDown="checkLength()"
				 onKeyUp="checkLength()" onPaste="checkLength()" style="overflow:hidden"></textarea>
			</td>
		</tr>
		<tr align="center">
			<td><input type="button" onclick="justTalk()" value="  Talk  " > </td>
		</tr>
		
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
	<input type="hidden" name="clientToken" value="<%=clientToken%>" />
	
</form>
</body>
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
		str = a.value.replace(/\s+/g,"");
		if(str==''){
			alert("���벻��Ϊ��!");
			a.value = '';
			a.focus();
		   	return false;
		}
        if(a.value.length > 140)
		{
		   	alert("����ĳ��Ȳ��ܳ���140���ַ�!");
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