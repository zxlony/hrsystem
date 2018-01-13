<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员查看员工信息</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("#shang").hide();
		$(".shang").click(function(){
			$("#shang").show();
		})
		$(".quxiao").click(function(){
			$("#shang").hide();
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
<form action="${pageContext.request.contextPath}/rap/insert?uid=${requestScope.emp.uid}&ename=${requestScope.emp.ename}" method="post">
<fieldset style="width: 650px;margin: 0 auto;" id="shang">
	<table cellpadding="10" cellspacing="0" align="center">
	<tr>
		<td colspan="2" align="center"><h2>赏</h2></td>
	</tr>
	<tr>
		<td>奖赏理由</td>
		<td><input type="text" name="cause"/></td>
	</tr>
	<tr>
		<td>奖　　金</td>
		<td><input type="number" name="money"/></td>
	</tr>
	<tr>
		<td>时　　间</td>
		<td><input type="date" name="rptime"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="确认"/></td>
	</tr>
	</table>
</fieldset>
</form>
</body>
</html>