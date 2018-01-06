<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="10" cellspacing="0" align="center">
		<tr>
			<td>应聘者</td>
			<td>投递时间</td>
			<td>查看状态</td>
			<td>面试状态</td>
			<td colspan="2" align="center">操作</td>
		</tr>
		<c:forEach items="${requestScope.applies}" var="apply">
		<tr>
			<td>${apply.uname}</td>
			<td><f:formatDate value="${apply.deliveryTime}" pattern="yyyy-MM-dd"/></td>
			<td>${apply.checkStatus}</td>
			<td>${apply.interviewStatus}</td>
			<td><a href="${pageContext.request.contextPath}/apply/lookResume?uname=${apply.uname}">查看</a></td>
			<td><a href="${pageContext.request.contextPath}/apply/delapply?aid=${apply.aid}" name="del">删除</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>