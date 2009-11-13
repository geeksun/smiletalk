<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册 -- italk</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/register.css" />
<script src="<%=path%>/js/prototype140.js"></script>
<script src="<%=path%>/js/common.js"></script>
<script>
	function checkEmail(successid,elem,id){
		if(trim(elem.value)==''){
			return false;
		}
		else if(validateEmail(elem) == 1){
			showError(successid,id
			,"&nbsp;&nbsp;&nbsp;<font color='red'>电子邮件格式不正确!</font>");
			return false;
		}else{
			showSuccess(successid,id);
			return true;
		}
	}
	function checkUser(successid,elem,id){
		if(checkUserName(successid,elem,id)){
			$(id).innerHTML = "<img border=0 src='<%=path%>/images/gif/ajax-loader.gif'/>";
			var url = "<%=path%>/checkUserName";
			var pars = "iTalkName="+$("iTalkName").value;
			new Ajax.Request(url,{
				method:'post',
				parameters:pars,
				onSuccess:function(transport){
					if("fail" == transport.responseText){
						showError(successid,id,"&nbsp;&nbsp;&nbsp;<font color='red'>该用户已经存在</font>");
						return false;
					}else{
					 	showSuccess(successid,id);
						return true;
					}
				}
			});
		}
	}
	function checkUserName(successid,elem,id){
		if(trim(elem.value)==''){
			return false;
		}
		else if(validateUsername(elem) == 1){
			showError(successid,id,"<font color='red'>&nbsp;&nbsp;&nbsp;5-20个字符，一旦注册成功会员名不能修改。</font>");
			return false;
		}else{
			showSuccess(successid,id);
			return true;
		}
	}
	function checkPassword(successid,elem,id){
		if(elem.value==''){
			return false;
		}
		else if(validateUsername(elem) == 1){
			showError(successid,id
			,"&nbsp;&nbsp;&nbsp;<font color='red'>5-20个字符，不能与用户名相同。</font>");
			return false;
		}else{
			showSuccess(successid,id);
			return true;
		}
	}
	function validateUsername(obj){
		var str = obj.value;
		var patn = /^[a-zA-Z0-9]+$/;
		if(!checkByteLength(str,5,20)) return 1;
		if(!patn.test(str)){
			return 1;
		}
		return 0; 
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
	function showSuccess(successid,id)
	{	
		$(successid).innerHTML="<img src='<%=path%>/images/reg/ok.gif'></img>";
		$(id).innerHTML="填写正确";
		$(id).className="note";
	}
</script>
</head>
<body>
	<p align="center">
		注册italk
	</p>
	<form action="iTalkRegister.htm" method="post" name="iTalkRegister">
	<table align="center">
	<tr>
		<td align=right><span id="email_img"></span>电子邮箱:<font color=red>*</font></td>
		<td><input type=text id="iTalkemail" name="iTalkemail" onBlur="checkEmail('email_img',this,'email_condition')"
		 onFocus="doEnhance('email_condition');">
		</td>
		<td>
		<div id="email_condition" class="note">
			请输入您常用的邮箱，方便日后找回密码。
		</div>
		</td>
	</tr>
	<tr>
		<td align=right><span id="username_img"></span>用户名:<font color=red>*</font></td>
		<td><input type=text id="iTalkName" name="iTalkName" onFocus="doEnhance('username_condition');" 
		onBlur="checkUser('username_img',this,'username_condition')"></td>
		<td width="256" class="bg1">
			<div class="note" id="username_condition">
				5-20个字符，一旦注册成功会员名不能修改。
			</div>
		</td>
	</tr>
	<tr>
		<td align=right><span id="password_img"></span>密码:<font color=red>*</font></td>
		<td><input type=password id="iTalkpwd" name="iTalkpwd" onBlur="checkPassword('password_img',this,'password_condition')"
		onFocus="doEnhance('password_condition');"  size=22></td>
		<td>
		<div class="note" id="password_condition">
		5-20个字符 <font color="red">(注意：不能与用户名相同)</font>
		</div>
		</td>
	</tr>
	<tr align="center">
		<td colspan="2">
			<input type="submit" name="iTalksub" value="注册 iTalk">
		</td>
	</tr>
	<input type="hidden" name="iTalkAct" value="iTalkRegister">
  </table>
  </form>
</body>
</html>