<%@ page language="java"  pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="top.jsp"/>

<% 
	String path = request.getContextPath();
	String photoPath = (String)request.getAttribute("photoPath");
	String userName = (String)request.getAttribute("userName");
 %>

<script type="text/javascript" src="<%=path%>/js/jquery-1.3.1.js"></script>
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
          		<form action="" name="iTalk" method="post">
				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr align="center" >
						<td>What are you doing?record here��                     ����������<span id="validNum">140</span>��</td>
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
          <table id="dynamic" width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
          </table>
          <table id="nextnode" width="98%" border="0" align="right" cellpadding="0" cellspacing="0">
          </table>
          
     <script>
     function addTable() {
	 	var content = document.iTalk.topicContent.value;
	 	
		var row1 = dynamic.insertRow();
		var cell1=row1.insertCell();
		cell1.colSpan=2;
		cell1.height=2;
		cell1.innerHTML="<hr size=\"1\" noshade=\"noshade\" style=\"border:1px #cccccc dotted;\">";
		var row2 = dynamic.insertRow();
		var cell2=row2.insertCell();
		cell2.width=52;
		cell2.valign=top;
		cell2.innerHTML="<img src=\"<%=photoPath%>\" width=\"52\" height=\"53\" />";
		var cell3=row2.insertCell();
		cell3.valign=top;
		var innerContent = "<table width=\"98%\" border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\"><tr>";
		var a = "<td height=\"18\" colspan=\"2\" bgcolor=\"#EAF3FA\" class=\"STYLE3\"><span class=\"STYLE2\"><strong><%=userName%></strong></span></td>";
		var b = "</tr><tr><td class=\"STYLE2\">"+content+"</td></tr><tr><td><span class=\"STYLE7\">"+"�ո�"+"</span> <span class=\"STYLE8\">����</span> <span class=\"STYLE2\">by:</span><span class=\"STYLE8\"><%=userName%></span></td></tr>";
		var c = "<tr><td align=\"right\"></td></tr></table>";
		cell3.innerHTML=innerContent+a+b+c;
		
		//cell3.appendChild(table);
	}
	function addTable2() {
	 	var content = document.iTalk.topicContent.value;
	 	
		var row1 = dynamic.insertRow();
		var cell1=row1.insertCell();
		cell1.colSpan=2;
		cell1.height=2;
		cell1.innerHTML="<hr size=\"1\" noshade=\"noshade\" style=\"border:1px #cccccc dotted;\">";
		var row2 = dynamic.insertRow();
		var cell2=row2.insertCell();
		cell2.width=52;
		cell2.valign=top;
		cell2.innerHTML="<img src=\"<%=photoPath%>\" width=\"52\" height=\"53\" />";
		var cell3=row2.insertCell();
		cell3.valign=top;
		var innerContent = "<table width=\"98%\" border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\"><tr>";
		var a = "<td height=\"18\" colspan=\"2\" bgcolor=\"#EAF3FA\" class=\"STYLE3\"><span class=\"STYLE2\"><strong><%=userName%></strong></span></td>";
		var b = "</tr><tr><td class=\"STYLE2\">"+content+"</td></tr><tr><td><span class=\"STYLE7\">"+"�ո�"+"</span> <span class=\"STYLE8\">����</span> <span class=\"STYLE2\">by:</span><span class=\"STYLE8\"><%=userName%></span></td></tr>";
		var c = "<tr><td align=\"right\"></td></tr></table>";
		cell3.innerHTML=innerContent+a+b+c;
		
		//cell3.appendChild(table);
	}
	function temp(){
		var time = '�ո�';
		var row3 = nextnode.insertRow();
		var cell4 = row3.insertCell();
		cell4.colSpan=2;	
		cell4.height=18;
		cell4.bgColor = "#EAF3FA";
		cell4.className="STYLE3";
		cell4.innerHTML="<span class=\"STYLE2\"><strong><%=userName%></strong></span>";
		var cell5=row3.insertCell();
		cell5.className="STYLE2";
		cell5.innerHTML = content;
		var cell6=row3.insertCell();
		cell6.className="STYLE7";
		cell6.innerHTML="<span class=\"STYLE7\">" + time + "</span> <span class=\"STYLE8\">����</span> <span class=\"STYLE2\">by:</span><span class=\"STYLE8\"><%=userName%></span>";
		var cell7=row3.insertCell();
		cell7.align="right";
		//cell7.innerHTML="<a href='javascript:reply('<%=userName%>')'>�ظ�</a>&nbsp;<a href='javascript:transmit('<%=userName%>')'>ת��</a>";
		//cell3.innerHTML = nextnode.innerHTML;
	}
     </script>
            <c:forEach var="topicBean" items="${topicList}">
              <table id="talk${topicBean.topicId}" width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
		        <td colspan="2" height="2"><hr size="1" noshade="noshade" style="border:1px #cccccc dotted;"></td>
		      </tr>
                  <tr>
                    <td width="52" valign="top"><img src="${topicBean.photoPath}" width="52" height="53" /></td>
                    <td valign="top">
                    <table width="98%" border="0" align="right" cellpadding="0" cellspacing="0">
                       <tr>
                          <td height="18" colspan="2" bgcolor="#EAF3FA" class="STYLE3"><span class="STYLE2"><strong>${topicBean.userName}</strong></span></td>
                       </tr>
                       <tr>
                          <td class="STYLE2">${topicBean.topicContent}</td>
                       </tr>
                       <tr>
                          <td><span class="STYLE7">${topicBean.topicTime}</span> <span class="STYLE8">����</span> <span class="STYLE2">by:</span><span class="STYLE8">${topicBean.userName}</span></td>
                       </tr>
                       <tr>
	                    	<td align="right">
	                    	<c:if test="${topicBean.userName!=userBean.userName}">
	                    	<a href="javascript:reply('${topicBean.userName}')">�ظ�</a>&nbsp;<a href="javascript:transmit('${topicBean.userName}')">ת��</a>
	                    	</c:if>
	                    	</td>
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
		str = a.value.replace(/\s+/g,"");	//�Ƿ�Ϊ��
		//str = a.value.replace(/<.*>/g, "");	//ȥ��������
		//str = toTxt(str);
		//str = a.value.replace(/</g, "&lt;");
		if(str==''){
			//alert("���벻��Ϊ��!");
			a.value = '';
			a.focus();
			document.getElementById("validNum").innerHTML = 140;
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
			var content = jQuery("#topicContent").val();
			content = encodeURI(content);
			jQuery.ajax({
		         url:"<%=path%>/newTalk.action",
		         data:{content:content},
		         cache:false,
			   method:'post',
		         error:function(XMLHttpRequest, textStatus, errorThrown){
		         	alert(xhr.status);
		         	if(XMLHttpRequest.status == 404) {
		         	    alert('404');
				    // 404 error
				}
				else if(XMLHttpRequest.status == 403) {
				    alert('403');
				    // 403 error
				}
				else {
				    // default error
				    alert(textStatus);
				    //alert("error occured!!!");
				} 
		         },
		         success:function(data){
		          if(data=="1"){
		          	//alert("�����ɹ�");
		          	addTable();
		          }else{
		          	alert("����ʧ��");
		          }
		         }
		    });
		}
	}
	function reply(element){
		var topicContent = document.getElementById("topicContent");
		topicContent.value = "RT " + element + ":";
		topicContent.focus();
	}
	function transmit(element){
		var topicContent = document.getElementById("topicContent");
		topicContent.value = "ZT " + element + ":";
		topicContent.focus();
	}
	function toTxt(str){  
	    var RexStr = /\<|\>|\"|\'|\&/g;
	    str = str.replace(RexStr,   
	        function(MatchStr){   
	            switch(MatchStr){   
	                case "<":   
	                    return "&lt;";   
	                    break;   
	                case ">":   
	                    return "&gt;";   
	                    break;   
	                case "\"":   
	                    return "&quot;";   
	                    break;   
	                case "'":   
	                    return "&#39;";   
	                    break;   
	                case "&":   
	                    return "&amp;";   
	                    break;   
	                default :   
	                    break;   
	            }   
	        }   
	    )   
	    return str;   
	}
</script>         
<p align="center">
<%@ include file="foot.jsp" %>
</p>
