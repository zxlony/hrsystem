<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册界面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$(":text[name='uname']").blur(function(){
			var name=$(this).val();
			if(name.length==0){
				$(".name").text("用户名不能为空！");
				$(":submit").attr("disabled",true);
			}
			$.ajax({
				url:"${pageContext.request.contextPath}/user/getName",
				type:"post",
				dataType:"text",
				data:{uname:name},
				success:function(data){
					if(data=="1"){
						$(".name").text("用户名已存在！");
						$(":submit").attr("disabled",true);
					}else{
						$(".name").text("");
						$(":submit").attr("disabled",false);
					}
				}
			})
		})
		
		$(":password[name='password']").blur(function(){
			var psd1=$(":password[name='psd']").val();
			var psd2=$(this).val();
			if(psd1!=psd2){
				$(".psd").text("两次密码不一致");
				$(":submit").attr("disabled",true);
			}else{
				$(".psd").text("");
				$(":submit").attr("disabled",false);
			}
		})
	})
</script>
<style type="text/css">
	span{
		color:#666;
		font-size: 10px;
	}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/register" method="post">
		<table align="center" cellpadding="10" cellspacing="0" border="1">
			<tr>
				<td colspan="2"><h2>注册</h2></td>
			</tr>
			<tr>
				<td>用 户 名：</td>
				<td><input type="text" name="uname" />&nbsp;<span class="name"></span></td>
			</tr>
		<tr>
				<td>设置密码：</td>
				<td><input type="password" name="psd" /></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" name="password" />&nbsp;<span class="psd"></span></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="注册" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" value="取消" /></td>
			</tr>
		</table>
	</form>
</body>
</html>