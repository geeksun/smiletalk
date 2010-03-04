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
          <table id="basic" width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
          </table>
          <table id="dynamic" width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
          </table>
          
     <script>
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
		var b = "</tr><tr><td class=\"STYLE2\">"+content+"</td></tr><tr><td><span class=\"STYLE7\">"+"刚刚"+"</span> <span class=\"STYLE8\">生活</span> <span class=\"STYLE2\">by:</span><span class=\"STYLE8\"><%=userName%></span></td></tr>";
		var c = "<tr><td align=\"right\"></td></tr></table>";
		cell3.innerHTML=innerContent+a+b+c;
	 }
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
		
		var ttable = document.createElement("table");
		var tbody = document.createElement("tbody");
		ttable.width = "98%";
	    ttable.border = 0; 
		ttable.align="right";
		ttable.cellPadding=0;
		ttable.cellSpacing=0;
		
		var tr = document.createElement("tr");
		var td = document.createElement("td");
		td.height=18;
		td.colSpan=2;
		td.bgColor="#EAF3FA";
		td.className="STYLE3";
		td.innerHTML="<span class=\"STYLE2\"><strong><%=userName%></strong></span>";
		tr.appendChild(td);
		tbody.appendChild(tr); 
		var tr2 = document.createElement("tr");
		var td2 = document.createElement("td");
		td2.className="STYLE2";
		td2.innerHTML=content;
		tr2.appendChild(td2);
		tbody.appendChild(tr2); 
		var tr3 = document.createElement("tr");
		var td3 = document.createElement("td");
		td3.innerHTML="<span class=\"STYLE7\">刚刚</span> <span class=\"STYLE8\">生活</span> <span class=\"STYLE2\">by:</span><span class=\"STYLE8\"><%=userName%></span>";
		tr3.appendChild(td3);
		tbody.appendChild(tr3); 
		var tr4 = document.createElement("tr");
		var td4 = document.createElement("td");
		td4.align="right";
		tr4.appendChild(td4);
		tbody.appendChild(tr4); 
		ttable.appendChild(tbody);
		
		cell3.appendChild(ttable);
		var basic = document.getElementById("basic");
		//var dynamic = document.getElementById("dynamic");
		var dynamic = document.createElement("dynamic");
		newNode.innerHTML = "This is a test";
		basic.insertBefore(dynamic, basic.childNodes[0]);
	}

     </script>
            <c:forEach var="topicBean" items="${topicList}">
              <table id="talk_${topicBean.topicId}" width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
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
                          <td><span class="STYLE7">${topicBean.topicTime}</span> <span class="STYLE8">生活</span> <span class="STYLE2">by:</span><span class="STYLE8">${topicBean.userName}</span></td>
                       </tr>
                       <tr>
	                    	<td align="right">
	                    	<c:if test="${topicBean.userName!=userBean.userName}">
	                    	<a href="javascript:reply('${topicBean.userName}')">回复</a>&nbsp;<a href="javascript:transmit('${topicBean.userName}')">转发</a>
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
		str = a.value.replace(/\s+/g,"");	//是否为空
		//str = a.value.replace(/<.*>/g, "");	//去掉尖括号
		//str = toTxt(str);
		//str = a.value.replace(/</g, "&lt;");
		if(str==''){
			//alert("输入不可为空!");
			a.value = '';
			a.focus();
			document.getElementById("validNum").innerHTML = 140;
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
		          	//alert("发帖成功");
		          	addTable();
		          }else{
		          	alert("发帖失败");
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
