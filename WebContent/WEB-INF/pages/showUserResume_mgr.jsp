<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>面试应聘者</title>
</head>
<body>
<fieldset style="width: 650px;margin: 0 auto;">
	<legend>简历详情</legend>
	<table border="1" width="600" cellpadding="10" cellspacing="0" align="center">
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
			<td colspan="4" align="center"><input type="button" value="录用" 
			onclick="location.href='${pageContext.request.contextPath}/apply/hire?uid1=${requestScope.resume.uid}&uid2=${sessionScope.user.uid}'"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="不录用" 
			onclick="location.href='${pageContext.request.contextPath}/apply/noHire?uid1=${requestScope.resume.uid}&uid2=${sessionScope.user.uid}'"/>
			</td>
		</tr>
	</table>
</fieldset>
</body>
</html>