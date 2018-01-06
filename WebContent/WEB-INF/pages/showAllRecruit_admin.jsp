<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看所有招聘信息-管理员</title>
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
			<td>招聘职位</td>
			<td>岗位需求</td>
			<td>面试地址</td>
			<td>发布时间</td>
			<td colspan="2" align="center">操作</td>
		</tr>
		<c:forEach items="${requestScope.recruits}" var="recruit">
		<tr>
			<td>${recruit.job}</td>
			<td>${recruit.description}</td>
			<td>${recruit.address}</td>
			<td><f:formatDate value="${recruit.pubdate}" pattern="yyyy-MM-dd"/></td>
			<td><a href="${pageContext.request.contextPath}/recruit/delRecruit?rid=${recruit.rid}" name="del">删除</a></td>
			<td><a href="${pageContext.request.contextPath}/recruit/updateRecruit?rid=${recruit.rid}">更新</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>