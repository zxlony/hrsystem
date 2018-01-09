<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看应聘者</title>
</head>
<body>
	<table border="1" cellpadding="10" cellspacing="0" align="center" width="450">
		<tr>
			<td>应聘者</td>
			<td>面试时间</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${requestScope.applies}" var="apply">
		<tr>
			<td>${apply.uname}</td>
			<td><f:formatDate value="${apply.interviewTime}" pattern="yyyy-MM-dd"/></td>
			<td><a href="${pageContext.request.contextPath}/apply/mgrInterview?uname=${apply.uname}&aid=${apply.aid}&uid=${sessionScope.user.uid}">
			面试</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>