<%@ page language="java" pageEncoding="gbk" contentType="text/html; charset=gbk"%>

<jsp:include page="frame/top.jsp"/>

<%
	String path = request.getContextPath();
%>
<script src="<%=path%>/js/common.js"></script>

<p>
</p>
<br>
<p>
</p>
<br>
<p>
</p>
<br>
<p align="center" valign="middle">
<form name="forgetPwdForm" action="forgetPwd.action" method="post">
	<table>
		<tr>
			<td>
				请输入你的注册邮箱：<input type="text" id="email" name="email" size="30">
			</td>
		</tr>
		<tr>
			<td align="center"><br>
				<input type="button" onclick="checkEmail()" value=" 提  交 ">
			</td>
		</tr>
	</table>
</form>
</p>
<p>
<br>
</p>
<br>
<p>
</p>
<br>
<p>
<br>
</p>

<p align="center">
<%@ include file="frame/foot.jsp" %>
</p>

<script>
	function checkEmail(){
		var elem = document.getElementById("email");
		if(trim(elem.value)==''){
			alert("输入值为空，请输入有效值！");
			elem.focus();
			return;
		}
		else if(validateEmail(elem) == 1){
			alert("电子邮件格式不正确!");
			elem.focus();
			return;
		}else{
			document.forgetPwdForm.submit();
		}
	}
	function validateEmail(obj){
		var str = obj.value;
		if(!checkByteLength(str,1,50)) return 1;
			var patn = /^\w[-._\w]*\w@\w[-._\w]*\w\.\w{2,6}$/;
		if(patn.test(str)){
			return 0;
		}else{
			return 1; //incorrect format
		}
	}
	function checkByteLength(str,minlen,maxlen) {
		if (str == null) return false;
		var l = str.length;
		var blen = 0;
		for(i=0; i<l; i++) {
			if ((str.charCodeAt(i) & 0xff00) != 0) {
				blen ++;
			}
			blen ++;
		}
		if (blen > maxlen || blen < minlen) {
			return false;
		}
		return true;
	} 
</script>