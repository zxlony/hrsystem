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
						$(".name").text("用户名已存在！");
						$(":submit").attr("disabled",true);
					}else{
						$(".name").text("");
						if($(".psd").text()==""){
							$(":submit").attr("disabled",false);
						}
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
				if($(".name").text()==""){
					$(":submit").attr("disabled",false);
				}
			}
		})
	})
	
	function res(){
		var name1=$(":text[name='uname']").val();
		var psd3=$(":password[name='psd']").val();
		var psd4=$(":password[name='password']").val();
		if(name1==""){
			alert("用户名不能为空！");
			return false;
		}
		if(psd3==""||psd4==""){
			alert("密码不能为空！")
			return false;
		}
		return true;
	}
</script>
<style type="text/css">
	span{
		color:#666;
		font-size: 12px;
	}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/register" method="post" onsubmit="return res()">
		<table align="center" cellpadding="10" cellspacing="0" border="1" width="380">
			<tr>
				<td colspan="2" align="center"><h2>注册</h2></td>
			</tr>
			<tr>
				<td align="right" width="25%">用 户 名</td>
				<td><input type="text" name="uname" />&nbsp;<span class="name"></span></td>
			</tr>
		<tr>
				<td align="right">设置密码</td>
				<td><input type="password" name="psd" /></td>
			</tr>
			<tr>
				<td align="right">确认密码</td>
				<td><input type="password" name="password" />&nbsp;<span class="psd"></span></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="注册" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="reset" value="取消" /></td>
			</tr>
		</table>
	</form>
</body>
</html>