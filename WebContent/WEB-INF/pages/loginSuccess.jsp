<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
<script type="text/javascript">
	function jump(){
		window.location.href="${pageContext.request.contextPath}/user/view";
	}
	setTimeout('jump()',3000);
</script>
<style type="text/css">
	h2{
		color:red;
		text-align:center;
		margin-top: 15px;
	}
	a{
		color: blue;
	}
</style>
</head>
<body>
	<h2>恭喜您，登录成功！　<a href="${pageContext.request.contextPath}/user/view">进入个人界面</a></h2>
	<h2>3秒后自动跳转……</h2>
</body>
</html>