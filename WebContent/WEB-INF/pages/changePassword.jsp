<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/userView.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	$(":password[name='oldPsd2']").blur(function(){
		var pwd1=$(this).val();
		var pwd2=$(":hidden[name='oldPsd1']").val();
		if(pwd1!=pwd2){
			$(".name").text("密码不对！");
			$(":submit").attr("disabled",true);
		}else{
			$(".name").text("");
			if($(".psd").text()==""){
				$(":submit").attr("disabled",false);
			}
		}
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
</script>
<style type="text/css">
	span{
		color:#666;
		font-size: 12px;
	}
</style>
</head>
<body>
	<p>当前用户:${sessionScope.user.uname}</p>
	<div id="left">
		<ul>
			<li><a href="#">反馈</a></li>
			<li><a href="${pageContext.request.contextPath}/resume/lookResume?uid=${sessionScope.user.uid}">查看简历</a></li>
			<li><a href="#">招聘信息</a></li>
			<li><a href="${pageContext.request.contextPath}/user/changePwd">修改密码</a></li>
			<li><a href="#">其它</a></li>
			<li><a href="#">退出</a></li>
		</ul>
	</div>
	<div id="right">
		<form action="${pageContext.request.contextPath}/user/updatePwd">
			<fieldset style="height:100%;width: 420px;">
			<legend>修改密码</legend>
			<table align="center" cellpadding="10" cellspacing="0"  width="380">
				<tr>
					<td align="right" width="25%">原密码：
					<input type="hidden" name="oldPsd1" value="${sessionScope.user.password}"/></td>
					<td><input type="password" name="oldPsd2" />&nbsp;<span class="name"></span></td>
				</tr>
				<tr>
					<td align="right">新密码：</td>
					<td><input type="password" name="psd" /></td>
				</tr>
				<tr>
					<td align="right">密码确认:</td>
					<td><input type="password" name="password" />&nbsp;<span class="psd"></span></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="确认修改" /></td>
				</tr>
			</table>
			</fieldset>
		</form>
	</div>
</body>
</html>