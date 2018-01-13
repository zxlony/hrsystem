<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看所有在职员工</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("#transfer").hide();
		var job=$("select[name='job']").val();
		if(job!=null){
			$("#transfer").show();
		}
		
		$("select[name='job']").change(function(){
			$("select[name='job'] option").each(function(id,item){
				if($(this).attr("selected")){
					$("select.po").each(function(){
						$(this).attr("name","");
					})
					$("select.po").hide();
					$("select.po").eq(id).show();
					$("select.po").eq(id).attr("name","post");
				}
			})
		})
		$("select[name='job']").change();
	})

</script>
</head>
<body>
	<table border="1" cellpadding="10" cellspacing="0" align="center" width="550">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td colspan="4" align="center">操作</td>
		</tr>
		<c:forEach items="${requestScope.emps}" var="emp">
		<tr>
			<td>${emp.eid}</td>
			<td><a href="${pageContext.request.contextPath}/emp/lookAemp?uid=${emp.uid}">${emp.ename}</a></td>
			<td><a href="${pageContext.request.contextPath}/emp/transfer?uid=${emp.uid}">人事调动</a></td>
			<td><a href="${pageContext.request.contextPath}/checkon/lookEmpCheckon?uid=${emp.uid}">考勤</a></td>
			<td><a href="${pageContext.request.contextPath}/#">工资发放</a></td>
			<td><a href="${pageContext.request.contextPath}/#">开除</a></td>
		</tr>
		</c:forEach>
	</table>
	<br/>
	<div id="transfer" style="width:300px; height:150px; margin:0 auto;padding: 10px; text-align:center; border: 2px solid #999;">
	<h3>请选择调动的部门职位</h3>
	<form action="${pageContext.request.contextPath}/emp/staff">
		<input type="hidden" value="${requestScope.uid}" name="uid"/>
		<select name="job">
			<c:forEach items="${requestScope.depts}" var="dept">
				<option value="${dept.dname}">${dept.dname}</option>
			</c:forEach>
		</select>
		<!-- 多个select -->
		<c:forEach items="${requestScope.depts}" var="dept">
			<select class="po">
				<c:forEach items="${dept.posts}" var="p">
					<option value="${p.pname}">${p.pname}</option>
				</c:forEach>
			</select>
		</c:forEach>	
		<input type="submit" value="确认调动"/>
	</form>
	</div>
</body>
</html>