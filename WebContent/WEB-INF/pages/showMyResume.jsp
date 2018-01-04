<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看我的简历</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("select[name='jobApplied']").change(function(){
			$("select[name='jobApplied'] option").each(function(id,item){
				if($(this).attr("selected")){
					$("select[name='post']").hide();
					$("select[name='post']").eq(id).show();
				}
			})
		})
		$("select[name='jobApplied']").change();
	})

</script>

</head>
<body>
	<p>当前用户:${sessionScope.user.uname}</p>
	<c:if test="${empty requestScope.resume}">
	<form action="${pageContext.request.contextPath}/resume/insertResume">
	<table border="1" width="500" cellpadding="10" cellspacing="0" align="center">
		<tr>
			<td colspan="4" align="center">简　　历</td>
		</tr>
		<tr>
			<td>真实姓名</td>
			<td><input type="text" name="name" value="请输入真实姓名"/></td>
			<td>性别</td>
			<td>
				<input type="radio" name="sex" value="男"/>男&nbsp;&nbsp;
				<input type="radio" name="sex" value="女"/>女
			</td>
		</tr>
		<tr>
			<td>年龄</td>
			<td><input type="text" name="age" value="请输入"/></td>
			<td>学历</td>
			<td>
				<select name="education">
					<option value="博士">博士</option>
					<option value="硕士">硕士</option>
					<option value="本科">本科</option>
					<option value="大专">大专</option>
					<option value="高中">高中</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>联系方式</td>
			<td><input type="text" name="phone" value="请输入联系方式"/></td>
			<td>e-mail</td>
			<td><input type="text" name="email" value="请输入邮箱"/></td>
		</tr>
		<tr>
			<td>应聘职位</td>
			<td>
				<select name="jobApplied">
					<c:forEach items="${sessionScope.depts}" var="dept">
						<option value="${dept.dname}">${dept.dname}</option>
					</c:forEach>
				</select>
				<!-- 多个select -->
				<c:forEach items="${sessionScope.depts}" var="dept">
					<select name="post">
						<c:forEach items="${dept.posts}" var="p">
							<option value="${p.pid }">${p.pname}</option>
						</c:forEach>
					</select>
				</c:forEach>			
			</td>
			<td>政治面貌</td>
			<td>
				<select name="status">
					<option value="博士">普通群众</option>
					<option value="硕士">共青团员</option>
					<option value="本科">中共党员</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>上份工作</td>
			<td><input type="text" name="lastJob" value="请输入工作名称"/></td>
			<td>工作经验</td>
			<td><input type="text" name="experience" value="请输入几年工作经验"/></td>
		</tr>
		<tr>
			<td>期望薪资</td>
			<td>
				<select name="expectSalary">
					<option value="20000以上">20000以上</option>
					<option value="15000-20000">15000-20000</option>
					<option value="10000-15000">10000-15000</option>
					<option value="7000-10000">7000-10000</option>
					<option value="5000-7000">5000-7000</option>
					<option value="3000-5000">3000-5000</option>
					<option value="3000以下">3000以下</option>
				</select>
			</td>
			<td>兴趣爱好</td>
			<td><input type="text" name="hobby" value="请输入兴趣爱好"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="保存"/></td>
			<td colspan="2" align="center"><input type="button" value="返回" onclick="javascript:history.back(-1);"/></td>
		</tr>
	</table>
	</form>
	</c:if>
</body>
</html>