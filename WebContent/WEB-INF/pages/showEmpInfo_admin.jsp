<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员查看员工信息</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("#mianshi").hide();
		$(".mianshi").click(function(){
			$("#mianshi").show();
		})
	})
</script>
</head>
<body>
<fieldset style="width: 650px;margin: 0 auto;">
	<legend>员工信息</legend>
	<table border="1" width="600" cellpadding="10" cellspacing="0" align="center">
		<tr>
			<td>姓名</td>
			<td>${requestScope.emp.ename}</td>
			<td>性别</td>
			<td>${requestScope.emp.sex}</td>
		</tr>
		<tr>
			<td>年龄</td>
			<td>${requestScope.emp.age}</td>
			<td>学历</td>
			<td>${requestScope.emp.education}</td>
		</tr>
		<tr>
			<td>联系方式</td>
			<td>${requestScope.emp.phone}</td>
			<td>邮箱</td>
			<td>${requestScope.emp.email}</td>
		</tr>
		<tr>
			<td>入职时间</td>
			<td><f:formatDate value="${requestScope.emp.hireDate}" pattern="yyyy-MM-dd HH:mm:SS"/></td>
			<td>职位</td>
			<td>${requestScope.emp.station}</td>
		</tr>
	</table>
	<p align="center">
		<input type="button" value="赏" class="shang"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="取消" class="quxiao"/>
	</p>
</fieldset>
<form action="${pageContext.request.contextPath}/apply/updateApply?aid=${requestScope.apply.aid}" method="post">
<fieldset style="width: 650px;margin: 0 auto;" id="mianshi">
	<p align="center">
		<input type="date" name="interviewTime"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="确认"/>
	</p>
</fieldset>
</body>
</html>