<%@ page language="java"  import="java.util.*,com.bird.domain.*,com.bird.util.*" pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="top.jsp"/>
<style>
.style1 {
	color: green; 
	font-weight: bold;
}
</style>
 
<body><br>
	<table width="49%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#99CCFF">
		<c:forEach var="topicBean" items="${topicList}" >
		<tr align="center" >
			<td align="left">
				<span class="style1">${topicBean.userName}</span>  <font color="#9900FF">${topicBean.topicTime}</font>
			</td>
		</tr>
		<tr>
			<td>
				${topicBean.topicContent}
			</td>
		</tr>
		</c:forEach>
	</table>
</body>

<p align="center">
<%@ include file="foot.jsp" %>
</p>