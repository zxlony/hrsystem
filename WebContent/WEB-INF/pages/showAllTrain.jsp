<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员查看培训</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$(".del").click(function(){
			var flag = confirm("是否确认删除？");
			if(flag){
				return true;
			}
			return false;
		})
	})
</script>
</head>
<body>
	<table border="1" cellpadding="10" cellspacing="0" align="center">
		<tr>
			<td>培训内容</td>
			<td>培训时间</td>
			<td>培训部门</td>
			<td colspan="2" align="center">操作</td>
		</tr>
		<c:forEach items="${requestScope.trains}" var="train">
		<tr>
			<td>${train.tname}</td>
			<td><f:formatDate value="${train.time}" pattern="yyyy-MM-dd"/></td>
			<td>${train.dept.dname}</td>
			<td><a href="${pageContext.request.contextPath}/train/delTrain?tid=${train.tid}" name="del">删除</a></td>
			<td><a href="${pageContext.request.contextPath}/train/updateTrain?tid=${train.tid}">更新</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>