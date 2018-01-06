<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
	<legend>简历详情</legend>
	<table border="1" width="680" cellpadding="10" cellspacing="0" align="center">
		<tr>
			<td>姓名</td>
			<td>${requestScope.resume.name}</td>
			<td>性别</td>
			<td>${requestScope.resume.sex}</td>
		</tr>
		<tr>
			<td>年龄</td>
			<td>${requestScope.resume.age}</td>
			<td>学历</td>
			<td>${requestScope.resume.education}</td>
		</tr>
		<tr>
			<td>手机</td>
			<td>${requestScope.resume.phone}</td>
			<td>e-mail</td>
			<td>${requestScope.resume.email}</td>
		</tr>
		<tr>
			<td>应聘职位</td>
			<td>${requestScope.resume.jobApplied}</td>
			<td>政治面貌</td>
			<td>${requestScope.resume.status}</td>
		</tr>
		<tr>
			<td>上份工作</td>
			<td>${requestScope.resume.lastJob}</td>
			<td>工作经验</td>
			<td>${requestScope.resume.experience}</td>
		</tr>
		<tr>
			<td>期望薪资</td>
			<td>${requestScope.resume.expectSalary}</td>
			<td>兴趣爱好</td>
			<td>${requestScope.resume.hobby}</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="button" value="面试"/></td>
			<td colspan="2" align="center"><input type="button" value="返回" onclick="javascript:history.back(-1);"/></td>
		</tr>
	</table>
</fieldset>
<fieldset>
	<p align="center">
		<input type="date"/>
	</p>
</fieldset>
</body>
</html>