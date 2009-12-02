<%@ page language="java"  import="java.util.*,com.bird.domain.*" pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="top.jsp"/>
</style>
<body>
<p>

</p>
<c:set var="userBean" value="${userBean}" scope="page" ></c:set>
<form action="settingsInfo.action" name="settingInfo" enctype="multipart/form-data" method="post">
	<table width="49%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#99CCFF">
		<tr>
			<td colspan=2>基本信息</td>
		</tr>
		<tr>
			<td align="right">头像： </td><td><IMG width=50 height=50 src="${userBean.photoPath}" />   <input type="file" name="upload" size="30"></td>
		</tr>
		<tr>
			<td align="right">个人空间： </td><td>${userBean.userName}</td>
		</tr>
		<tr>
			<td align="right">
				<span class="style1">呢称：</span></td><td><font color="#9900FF"><input type="text" name="userName" value="${userBean.userName}"></font><font color=red>*</font>
			</td>
		</tr>
		<tr>
			<td align="right">性别： </td><td><input type="radio" name="sex" value="1" <c:if test="${userBean.sex=='1'}">checked</c:if> checked>男 <input type="radio" name="sex" value="0" <c:if test="${userBean.sex=='0'}">checked</c:if>>女<input type="radio" name="sex" value="2" <c:if test="${userBean.sex=='2'}">checked</c:if>>保密</td>
		</tr>
		<tr align="center" >
			<td align="right">生日： </td><td align="left"><input type="text" name="birthday" size="30" value="${userBean.birthday}"></td>
		</tr>
		<tr align="center" >
			<td align="right">地区： </td><td align="left"><input type="text" name="region" size="30" value="${userBean.region}"></td>
		</tr>
		<tr align="center" >
			<td align="right">
				<span class="style1">注册时间：</span></td><td align="left"><font color="#9900FF">${userBean.regTime}</font>
			</td>
		</tr>
		
		<tr align="center">
			<td colspan="2"><input type="submit" value=" 保 存 "></td>
		</tr>
	</table>
	
</form>
</body>
<p align="center">
<%@ include file="foot.jsp" %>
</p>
