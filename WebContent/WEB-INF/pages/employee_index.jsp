<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工界面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/employeeView.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
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
	<input type="hidden" value="${requestScope.msg.msg}" class="message">
	<div id="left">
		<ul>
			<li><a href="${pageContext.request.contextPath}/#">个人信息</a></li>
			<li><a href="#">我的考勤</a></li>
			<li><a href="#">我的奖惩</a></li>
			<li><a href="#">部门职位</a></li>
			<li><a href="#">我的薪资</a></li>
			<li><a href="${pageContext.request.contextPath}/user/changePwd">修改密码</a></li>
			<li><a href="#">其它</a></li>
			<li><a href="${pageContext.request.contextPath}/login.jsp" class="exit">退出</a></li>
		</ul>
	</div>
	<div id="right"></div>
</body>
</html>