<%@ page language="java" pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="top.jsp"/>

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
          <td colspan="2">
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="5"></td>
                </tr>
          </table>
              <c:forEach var="topicBean" items="${topicList}">
                <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
		           <td colspan="2" height="2"><hr size="1" noshade="noshade" style="border:1px #cccccc dotted;"></td>
		      </tr>
                  <tr>
                    <td width="52" valign="top"><img src="${topicBean.photoPath}" width="52" height="53" /></td>
                    <td valign="top"><table width="98%" border="0" align="right" cellpadding="0" cellspacing="0">
                        <tr>
                          <td height="18" colspan="2" bgcolor="#EAF3FA" class="STYLE3"><span class="STYLE2"><strong>${topicBean.userName}</strong></span></td>
                        </tr>
                        <tr>
                          <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0" height="5">
                              <tr>
                                <td></td>
                              </tr>
                            </table>
                              <table width="95%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                  <td class="STYLE2">${topicBean.topicContent}</td>
                                </tr>
                              </table>
                            <table width="95%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                  <td><span class="STYLE7">${topicBean.topicTime}</span> <span class="STYLE8">����</span> <span class="STYLE2">by:</span><span class="STYLE8">${topicBean.userName}</span></td>
                                </tr>
                            </table></td>
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
          
<p align="center">
<%@ include file="foot.jsp" %>
</p>
