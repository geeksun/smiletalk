<%@ page language="java"  import="java.util.*,com.bird.vo.*,com.bird.util.*" pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<jsp:include page="top.jsp"/>
<style>
.style1 {
	color: green;
	font-weight: bold;
}
</style>
<% 
		//����һ��formhash,�㷨�����Լ�����������ظ��Ϳ����ˣ�������sessionid+ʱ���Longֵ����ϼ���ֵ
		//String formhash = MD5.toMD5(Long.toString(new Date().getTime()));
		Random ran = new Random();
		String formhash = String.valueOf(ran.nextInt());
		//��ȡ��ǰsession�����hashCode���ϣ��˴�ʹ����Set�������жϡ�
		Set<String> formhashSession = (Set<String>) session.getAttribute("formhashSession");
		if (formhashSession == null) {
		    formhashSession = new HashSet<String>();
		}
		// ����ظ�����
		while (formhashSession.contains(formhash)) {
		    //formhash = MD5.toMD5(Long.toString(new Date().getTime()));
		    formhash = String.valueOf(ran.nextInt());
		}
		// ���浽session����
		formhashSession.add(formhash);
		// ����
		session.setAttribute("formhashSession", formhashSession);
 %>
<% 
	String username = (String)session.getAttribute("username");
	String action = (String)request.getAttribute("action");
	String path = request.getContextPath();
	if(username==null){
 %>
	����û�е�¼������<a href="<%=path%>/login.html">��¼ iTalk</a>
	<% 
	}
	else{
	 %>
<% 
	List topicList = (List)request.getAttribute("topicList");
%>

<!-- ��* -->
<body >
<form action="NewTalk.htm" name="iTalk" method="post">
	<table width="49%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#99CCFF">
		<tr align="center" >
			<td>What are you doing?record here��                     ����������<span id="validNum">140</span>��</td>
		</tr>
		<tr  align="center" >
			<td>
				<textarea name="talkTopic" id="talkTopic" rows="4" cols="60" maxlength='140' onKeyDown="checkLength()"
				 onKeyUp="checkLength()" onPaste="checkLength()" style="overflow:hidden"></textarea>
			</td>
		</tr>
		<tr align="center">
			<td><input type="button" onclick="justTalk()" value="  Talk  " ></td>
		</tr>
		
		<%
		   if(topicList!=null){
		   	for(int i=0;i<topicList.size();i++){
		   		TopicBean tbean = (TopicBean)topicList.get(i);
		   		if(tbean!=null){
		%>
		<tr align="center" >
			<td align="left">
				<span class="style1"><%=tbean.getUsername()%></span>  <font color="#9900FF"><%=tbean.getTopicTime()%></font>
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
	<input type="hidden" name="iTalkAct" value="iTalkTopic">
	<input type="hidden" name="formhash" id="formhash" value="<%=formhash%>" />
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