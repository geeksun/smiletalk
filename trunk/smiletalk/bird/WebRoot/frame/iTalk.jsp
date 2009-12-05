<%@ page language="java"  import="java.util.*,com.bird.domain.*" pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="top.jsp"/>

<% 
	String clientToken = (String)request.getAttribute("clientToken");
	clientToken = clientToken==null?"":clientToken;
	String path = request.getContextPath();
 %>

<style type="text/css">
<!--
.STYLE2 {font-size: 12px}
.STYLE3 {color: #0066FF}
.STYLE5 {font-size: 12px; font-weight: bold; }
.STYLE7 {
	font-size: 12px;
	color: #FF9900;
	font-weight: bold;
}
.STYLE8 {color: #0066FF; font-size: 12px; }
-->
</style>

<p align=center>

<table width="780" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>
        <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td colspan="2" height="2"><hr size="1" noshade="noshade" style="border:1px #cccccc dotted;"></td>
          </tr>
          <tr>
          	<td colspan="2" >
          		<form action="homeTalk.action" name="iTalk" method="post">
					<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
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
					</table>
					<input type="hidden" name="clientToken" value="<%=clientToken%>" />
				</form>
          	</td>
          </tr>
          
          <tr>
          <td colspan="2">
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="5"></td>
                </tr>
          </table>
              
              <c:forEach var="topicBean" items="${topicList}">
                <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                	<tr>
		           <td colspan="2" height="2"><hr size="1" noshade="noshade" style="border:1px #cccccc dotted;"></td>
		      </tr>
                  <tr>
                    <td width="52" valign="top"><img src="${topicBean.photoPath}" width="52" height="53" /></td>
                    <td valign="top"><table width="98%" border="0" align="right" cellpadding="0" cellspacing="0">
                        <tr>
                          <td height="18" colspan="2" bgcolor="#EAF3FA" class="STYLE3"><span class="STYLE2"><strong>${topicBean.userName}</strong></span></td>
                        </tr>
                        <tr>
                          <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0" height="5">
                              <tr>
                                <td></td>
                              </tr>
                            </table>
                              <table width="95%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                  <td class="STYLE2">${topicBean.topicContent}</td>
                                </tr>
                              </table>
                            <table width="95%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                  <td><span class="STYLE7">${topicBean.topicTime}</span> <span class="STYLE8">生活</span> <span class="STYLE2">by:</span><span class="STYLE8">${topicBean.userName}</span></td>
                                </tr>
                                <tr>
                                	<td align="center"><a href="#">关注</a>&nbsp;<a href="#">取消关注</a></td>
                                </tr>
                            </table></td>
                          <td width="69"><img src="${userBean.photoPath}" width="69" height="69" /></td>
                        </tr>
                    </table>
                    </td>
                  </tr>
              </table>
            </c:forEach>
              </td>
          </tr>
        </table>
        </td>
        </tr>
        </table>
        </td>
        </tr>
        <tr>
            <td colspan="2" height="2"><hr size="1" noshade="noshade" style="border:1px #cccccc dotted;"></td>
        </tr>
      </table>
   </p>       
          
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
