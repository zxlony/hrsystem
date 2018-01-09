<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看反馈信息</title>
</head>
<body>
	<table border="1" cellpadding="10" cellspacing="0" align="center">
		<tr>
			<td colspan="6" align="center">反馈信息</td>
		</tr>
		<tr>
			<td>投递时间</td>
			<td>查看状态</td>
			<td>面试状态</td>
			<td>面试时间</td>
			<td>是否录用</td>
			<td>操作</td>
		</tr>
		<c:if test="${!empty requestScope.apply}">
		<tr>
			<td><f:formatDate value="${requestScope.apply.deliveryTime}" pattern="yyyy-MM-dd"/></td>
			<td>${requestScope.apply.checkStatus}</td>
			<td>${requestScope.apply.interviewStatus}</td>
			<td><f:formatDate value="${requestScope.apply.interviewTime}" pattern="yyyy-MM-dd"/></td>
			<td>未录用</td>
			<td><a href="${pageContext.request.contextPath}/apply/interview?aid=${requestScope.apply.aid}">确认面试</a></td>
		</tr>
		</c:if>
		<tr>
			<td colspan="6" align="center"><input type="button" value="返回" onclick="javascript:history.back(-1);"/></td>
		</tr>
	</table>
</body>
</html>