<html>

</style>

	����û�е�¼������<a href="/login.jsp">��¼ iTalk</a>
	
<body>
<p></p>
������Ϣ��
<form action="settingInfo.action" name="settingInfo" enctype="multipart/form-data" method="post">
	<table width="49%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#99CCFF">
		<tr>
			<td align="right">ͷ�� </td><td><IMG width="0 height=" 0 src=""/>   <input type="file" name="headPhoto" size="30"/></td>
		</tr>
		<tr>
			<td align="right">���˿ռ䣺 </td><td></td>
		</tr>
		<tr>
			<td align="right">
				<span class="style1">�سƣ�</span></td><td><font color="#9900FF">&lt;%=userBean.getUserName()%&gt;</font>
			</td>
		</tr>
		<tr>
			<td align="right">�Ա� </td><td><input type="radio" name="sex" value="1"/>�� <input type="radio" name="sex" value="0"/>Ů</td>
		</tr>
		<tr align="center">
			<td align="right">���գ� </td><td></td>
		</tr>
		<tr align="center">
			<td align="right">������ </td><td></td>
		</tr>
		<tr align="center">
			<td align="right">
				<span class="style1">ע��ʱ�䣺</span></td><td align="left"><font color="#9900FF">&lt;%=userBean.getRegTime()%&gt;</font>
			</td>
		</tr>
		
		
		<tr align="center">
			<td colspan="2"><input type="submit" value=" �� �� "/></td>
		</tr>
	</table>
	
</form>
</body></html>