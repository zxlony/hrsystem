<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主管查看培训通知</title>
</head>
<body>
	<table border="1" cellpadding="10" cellspacing="0" align="center">
		<tr>
			<td>培训内容</td>
			<td>培训时间</td>
		</tr>
		<c:forEach items="${requestScope.trains}" var="train">
		<tr>
			<td>${train.tname}</td>
			<td><f:formatDate value="${train.time}" pattern="yyyy-MM-dd"/></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>