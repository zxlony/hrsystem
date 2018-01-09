<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游客界面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/userView.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		alert($(".message").val());
		
		$(".exit").click(function(){
			var flag = confirm("是否确认退出？");
			if(flag){
				return true;
			}
			return false;
		})
	})
</script>
</head>
<body>
	<p>当前用户:${sessionScope.user.uname}</p>
	<c:if test="${!empty requestScope.msgs}">
	<c:forEach items="${requestScope.msgs}" var="msg">
		<input type="hidden" value="${msg.msg}" class="message">
	</c:forEach>
	</c:if>
	<div id="left">
		<ul>
			<li><a href="${pageContext.request.contextPath}/apply/lookMyApply?uname=${sessionScope.user.uname}">反馈</a></li>
			<li><a href="${pageContext.request.contextPath}/resume/lookResume?uid=${sessionScope.user.uid}">查看简历</a></li>
			<li><a href="${pageContext.request.contextPath}/recruit/userLookRecruit">招聘信息</a></li>
			<li><a href="${pageContext.request.contextPath}/user/changePwd">修改密码</a></li>
			<li><a href="#">其它</a></li>
			<li><a href="${pageContext.request.contextPath}/login.jsp" class="exit">退出</a></li>
		</ul>
	</div>
	<div id="right"></div>
</body>
</html>