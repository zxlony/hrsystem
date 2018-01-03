<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/register" method="post">
		<table align="center" cellpadding="10" cellspacing="0" border="1">
			<tr>
				<td colspan="2"><h2>登 录</h2></td>
			</tr>
			<tr>
				<td colspan="2">${error}</td>
			</tr>
			<tr>
				<td>用 户 名：</td>
				<td><input type="text" name="uname" /></td>
			</tr>
			<tr>
				<td>密　码：</td>
				<td><input type="password" name="psd" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="登录" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" value="取消" /></td>
			</tr>
			<tr>
				<td colspan="2"><p>快来加入我们吧！<a href="${pageContext.request.contextPath}/register.jsp">注册</a></p></td>
			</tr>
		</table>
	</form>
</body>
</html>