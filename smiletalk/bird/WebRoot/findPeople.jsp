<%@ page language="java" pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="frame/top.jsp"/>
<%
    String path = request.getContextPath();
%>
<script src="<%=path%>/js/common.js"></script>


<p>
<br>
</p>

<p align=center>
	<form action="findPeople.action" name="findPeopleForm" method="post">
		<table>
			<tr>
				<td>Ҫ�������˵�����:</td><td><input type="text" name="userName" size="30"></td>
			</tr>
			<tr>
				<td align="center" colspan=2><br>
					<input type="button" height=10 onclick="checkInput()" value="  �� һ ��  ">
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
	function checkInput(){
		var elem = document.getElementById("userName");
		if(trim(elem.value)==''){
			alert("����ֵΪ�գ���������Чֵ��");
			elem.focus();
			return;
		}else{
			document.findPeopleForm.submit();
		}
	}
</script>