<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$(":text[name='uname']").blur(function(){
			var name=$(this).val();
			if(name==""){
				$(".name").text("用户名不能为空！");
				$(":submit").attr("disabled",true);
				return;
			}
			$.ajax({
				url:"${pageContext.request.contextPath}/user/getName",
				type:"post",
				dataType:"text",
				data:{uname:name},
				success:function(data){
					if(data=="1"){
						$(".name").text("");
						$(":submit").attr("disabled",false);
					}else{
						$(".name").text("用户名不存在！");
						$(":submit").attr("disabled",true);
					}
				}
			})
		})
	})
</script>
<style type="text/css">
	p {
		color: red;
	}
	
	a {
		font-size: 25px;
		font-style: italic;
		color: blue;
	}
	
	span {
		color: red;
		font-size: 13px;
	}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/login" method="post">
		<table align="center" cellpadding="10" cellspacing="0" border="1" width="380">
			<tr>
				<td colspan="2" align="center"><h2>登 录</h2></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><span>${error}</span></td>
			</tr>
			<tr>
				<td align="right" width="25%">用 户 名</td>
				<td><input type="text" name="uname" />&nbsp;<span class="name"></span></td>
			</tr>
			<tr>
				<td  align="right">密　码</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="登录" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="reset" value="取消" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><p>
						快来加入我们吧！<a href="${pageContext.request.contextPath}/register.jsp">注册</a>
					</p></td>
			</tr>
		</table>
	</form>
</body>
</html>