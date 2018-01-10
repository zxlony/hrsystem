<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看我的个人信息</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/emp/updateEmp">
	<input type="hidden" name="uid" value="${sessionScope.user.uid}"/>
	<input type="hidden" name="pid" value="${requestScope.emp.pid}"/>
	<input type="hidden" name="type" value="${requestScope.emp.type}"/>
	<table border="1" width="680" cellpadding="10" cellspacing="0" align="center">
		<tr>
			<td colspan="4" align="center">个人信息</td>
		</tr>
		<tr>
			<td>真实姓名</td>
			<td>${requestScope.emp.ename}</td>
			<td>性别</td>
			<td>${requestScope.emp.sex}</td>
		</tr>
		<tr>
			<td>年龄</td>
			<td><input type="text" name="age" value="${requestScope.emp.age}"/></td>
			<td>学历</td>
			<td><input type="text" name="education" value="${requestScope.emp.education}"/></td>
		</tr>
		<tr>
			<td>联系方式</td>
			<td><input type="text" name="phone" value="${requestScope.emp.phone}"/></td>
			<td>e-mail</td>
			<td><input type="text" name="email" value="${requestScope.emp.email}"/></td>
		</tr>
		<tr>
			<td>应聘职位</td>
			<td>${requestScope.emp.station}</td>
			<td>政治面貌</td>
			<td><input type="text" name="status" value="${requestScope.emp.status}"/></td>
		</tr>
		<tr>
			<td>入职时间</td>
			<td><f:formatDate value="${requestScope.emp.hireDate}" pattern="yyyy-MM-dd HH:mm:SS"/></td>
			<td>兴趣爱好</td>
			<td><input type="text" name="hobby" value="${requestScope.emp.hobby}"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="保存"/></td>
			<td colspan="2" align="center"><input type="button" value="返回" onclick="javascript:history.back(-1);"/></td>
		</tr>
	</table>
	<p align="center" style="color:red">${error}</p>
	</form>
</body>
</html>