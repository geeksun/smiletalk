<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<%
	String path = request.getContextPath();
	String validate = (String)request.getAttribute("validate");
	validate = validate==null?"":validate;
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ע�� -- italk</title> 
<link rel="stylesheet" type="text/css" href="<%=path%>/css/register.css" />
<script src="<%=path%>/js/prototype140.js"></script> 
<script src="<%=path%>/js/common.js"></script>
<script>
	function checkUniqueEmail(successid,elem,id){
		if(checkEmail(successid,elem,id)){
			$(id).innerHTML = "<img border=0 src='<%=path%>/images/gif/ajax-loader.gif'/>";
			var url = "<%=path%>/checkUniqueEmail.action";
			var pars = "email="+$("email").value;
			new Ajax.Request(url,{
				method:'post',
				parameters:pars,
				onSuccess:function(transport){
					if("fail" == transport.responseText){
						showError(successid,id,"&nbsp;&nbsp;&nbsp;<font color='red'>�������Ѿ�����</font>");
						return false;
					}else{
					 	showSuccess(successid,id);
						return true;
					}
				}
			});
		}
	}
	function checkEmail(successid,elem,id){
		if(trim(elem.value)==''){
			return false;
		}
		else if(validateEmail(elem) == 1){
			showError(successid,id
			,"&nbsp;&nbsp;&nbsp;<font color='red'>�����ʼ���ʽ����ȷ!</font>");
			return false;
		}else{
			showSuccess(successid,id);
			return true;
		}
	}
	function checkUser(successid,elem,id){
		if(checkUserName(successid,elem,id)){
			$(id).innerHTML = "<img border=0 src='<%=path%>/images/gif/ajax-loader.gif'/>";
			var url = "<%=path%>/checkUserName.action";
			var pars = "userName="+$("userName").value;
			new Ajax.Request(url,{
				method:'post',
				parameters:pars,
				onSuccess:function(transport){
					if("fail" == transport.responseText){
						showError(successid,id,"&nbsp;&nbsp;&nbsp;<font color='red'>���û��Ѿ�����</font>");
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
		else if(validateUserName(elem) == 1){
			showError(successid,id,"<font color='red'>&nbsp;&nbsp;&nbsp;5-20���ַ���һ��ע��ɹ���Ա�������޸ġ�</font>");
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
		else if(validateUserName(elem) == 1){
			showError(successid,id
			,"&nbsp;&nbsp;&nbsp;<font color='red'>5-20���ַ����������û�����ͬ��</font>");
			return false;
		}else{
			showSuccess(successid,id);
			return true;
		}
	}
	function checkPasswordConfirm(successid,elem,id){
		if(validateUserName($("password")) == 0)
		{
			if($("password").value == elem.value){
				showSuccess(successid,id);
				return true;
			}else
			{
				showError(successid,id
				,"&nbsp;&nbsp;&nbsp;<font color='red'>������������벻��ͬ��������������������롣</font>");
				return false;
			}
		}else{
			$(id).className="note";
		}
	}
	function validateUserName(obj){
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
		$(id).innerHTML="��д��ȷ";
		$(id).className="note";
	}
</script>
</head>
<body>
	<p align="center">
		ע��italk<%=validate%>
	</p>
	<form action="talkRegister.action" method="post" name="iTalkRegister">
	<table align="center">
	<tr>
		<td width="10%" align=right><span id="username_img"></span></td>
		<td align=right>�û��س�:<font color=red>*</font></td>
		<td><input type=text id="userName" name="userName" onFocus="doEnhance('username_condition');" 
		onBlur="checkUser('username_img',this,'username_condition')"></td>
		<td width="256" class="bg1">
			<div class="note" id="username_condition">
				5-20���ַ���һ��ע��ɹ���Ա�������޸ġ�
			</div>
		</td>
	</tr>
	<tr>
		<td width="10%" align=right><span id="email_img"></span></td>
		<td  align=right>Email:<font color=red>*</font></td>
		<td><input type=text id="email" name="email" onBlur="checkUniqueEmail('email_img',this,'email_condition')"
		 onFocus="doEnhance('email_condition');">
		</td>
		<td>
		<div id="email_condition" class="note">
			�����������õ����䣬�����պ��һ����롣
		</div>
		</td>
	</tr>
	<tr>
		<td width="10%" align=right><span id="password_img"></span></td>
		<td align=right>��¼����:<font color=red>*</font></td>
		<td><input type=password id="password" name="password" onBlur="checkPassword('password_img',this,'password_condition')"
		onFocus="doEnhance('password_condition');"  size=22></td>
		<td>
		<div class="note" id="password_condition">
		5-20���ַ� <font color="red">(ע�⣺�������û�����ͬ)</font>
		</div>
		</td>
	</tr>
	<tr>
		<td width="10%" align=right><span id="confirm_password_img"></span></td>
		<td align=right>����ȷ��:<font color=red>*</font></td>
		<td><input  type=password id="iTalkconpwd" name="iTalkconpwd" onFocus="doEnhance('confirm_password_condition');"
		 onBlur="checkPasswordConfirm('confirm_password_img',this,'confirm_password_condition')"  size=22></td>
		 <td width="256" class="bg1">
			<div class="note" id="confirm_password_condition">��������һ��������д�����롣</div>
		</td>
	</tr>
	<tr align="center">
		<td colspan="3">
			<input type="button" value="ע�� iTalk"  onclick="register()" />
		</td>
	</tr>
  </table>
  </form>
  <script type="text/javascript">
  	function register(){
    	if(checkUserName('username_img',$("userName"),'username_condition')
			&& checkEmail('email_img',$("email"),'email_condition')
			&& checkPassword('password_img',$("password"),'password_condition')
			&& checkPasswordConfirm('confirm_password_img',$("iTalkconpwd"),'confirm_password_condition')
			){
				var form = document.iTalkRegister;
				form.submit();
			}
	}
  </script>
</body>
</html>