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
			<td colspan=2>������Ϣ</td>
		</tr>
		<tr>
			<td align="right">ͷ�� </td><td><IMG width=50 height=50 src="${userBean.photoPath}" />   <input type="file" name="upload" size="30"></td>
		</tr>
		<tr>
			<td align="right">���˿ռ䣺 </td><td>${userBean.userName}</td>
		</tr>
		<tr>
			<td align="right">
				<span class="style1">�سƣ�</span></td><td><font color="#9900FF"><input type="text" name="userName" value="${userBean.userName}"></font><font color=red>*</font>
			</td>
		</tr>
		<tr>
			<td align="right">�Ա� </td><td><input type="radio" name="sex" value="1" <c:if test="${userBean.sex=='1'}">checked</c:if> checked>�� <input type="radio" name="sex" value="0" <c:if test="${userBean.sex=='0'}">checked</c:if>>Ů<input type="radio" name="sex" value="2" <c:if test="${userBean.sex=='2'}">checked</c:if>>����</td>
		</tr>
		<tr align="center" >
			<td align="right">���գ� </td><td align="left"><input type="text" name="birthday" size="30" value="${userBean.birthday}"></td>
		</tr>
		<tr align="center" >
			<td align="right">������ </td><td align="left"><input type="text" name="region" size="30" value="${userBean.region}"></td>
		</tr>
		<tr align="center" >
			<td align="right">
				<span class="style1">ע��ʱ�䣺</span></td><td align="left"><font color="#9900FF">${userBean.regTime}</font>
			</td>
		</tr>
		
		<tr align="center">
			<td colspan="2"><input type="submit" value=" �� �� "></td>
		</tr>
	</table>
	
</form>
</body>
<p align="center">
<%@ include file="foot.jsp" %>
</p>
