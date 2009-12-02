<html>

</style>

	您还没有登录，请先<a href="/login.jsp">登录 iTalk</a>
	
<body>
<p></p>
基本信息：
<form action="settingInfo.action" name="settingInfo" enctype="multipart/form-data" method="post">
	<table width="49%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#99CCFF">
		<tr>
			<td align="right">头像： </td><td><IMG width="0 height=" 0 src=""/>   <input type="file" name="headPhoto" size="30"/></td>
		</tr>
		<tr>
			<td align="right">个人空间： </td><td></td>
		</tr>
		<tr>
			<td align="right">
				<span class="style1">呢称：</span></td><td><font color="#9900FF">&lt;%=userBean.getUserName()%&gt;</font>
			</td>
		</tr>
		<tr>
			<td align="right">性别： </td><td><input type="radio" name="sex" value="1"/>男 <input type="radio" name="sex" value="0"/>女</td>
		</tr>
		<tr align="center">
			<td align="right">生日： </td><td></td>
		</tr>
		<tr align="center">
			<td align="right">地区： </td><td></td>
		</tr>
		<tr align="center">
			<td align="right">
				<span class="style1">注册时间：</span></td><td align="left"><font color="#9900FF">&lt;%=userBean.getRegTime()%&gt;</font>
			</td>
		</tr>
		
		
		<tr align="center">
			<td colspan="2"><input type="submit" value=" 保 存 "/></td>
		</tr>
	</table>
	
</form>
</body></html>