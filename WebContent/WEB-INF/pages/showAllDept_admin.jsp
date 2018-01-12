<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员查看部门</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	$(".plist").hide();
	$(".adddept").hide();
	$(".addpost").hide();
    var pname = $(":text[name='pname']").val();
	if(pname!=""){
		$(":text[name='pname']").parents(".plist").show();
	}
	
	$("#dlist li .dname").each(function(id,item){
		$(this).click(function(){
			$(".plist").hide();
			$(".plist").eq(id).show();
		})
	})
	
	$(".insertdept").click(function(){
		$(".adddept").show();
	})
	
	$(".insertpost").click(function(){
		$(".addpost").show();
	})
})
</script>
<style type="text/css">
	#content{width: 600px; margin: 0 auto;}
	#dlist,.plist{border: 1px solid black;background: #87ceeb;width: 260px;float: left}
	ul{list-style-type: none;}
	ul li{height: 35px; line-height: 35px;}
</style>
</head>
<body>
<div id="content">
	<p style="text-align: center;color: red;">${error}</p>
	<div id="dlist">
		<h2 align="center">部门</h2>
		<ul>
		<c:forEach items="${requestScope.depts}" var="dept">
			<li>
				<a href="#" class="dname">${dept.dname}</a>&nbsp;
				<a href="${pageContext.request.contextPath}/dept/delDept?did=${dept.did}"><img alt="删除" src="${pageContext.request.contextPath}/img/del.png"/></a>&nbsp;
				<a href="${pageContext.request.contextPath}/dept/updateDept?did=${dept.did}"><img alt="修改" src="${pageContext.request.contextPath}/img/update.png"/></a>&nbsp;
			</li>
		</c:forEach>
			<li style="width:50%; margin:5px auto;">
				<a href="#" class="insertdept"><img alt="增加" src="${pageContext.request.contextPath}/img/add.png"/></a>&nbsp;
			</li>
		</ul>
		<c:if test="${empty requestScope.deptmt}">
		<form action="${pageContext.request.contextPath}/dept/addDept" method="post" class="adddept">
			<table cellpadding="8" cellspacing="0">
			<tr>
				<td colspan="2" align="center">增加部门</td>
			</tr>
			<tr>
				<td>部门名称</td>
				<td><input type="text" name="dname"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="增加"></td>
			</tr>
			</table>
		</form>
		</c:if>
		<c:if test="${!empty requestScope.deptmt}">
		<form action="${pageContext.request.contextPath}/dept/update" method="post">
			<input type="hidden" value="${requestScope.deptmt.did}" name="did"/>
			<table cellpadding="8" cellspacing="0">
			<tr>
				<td colspan="2" align="center">修改部门</td>
			</tr>
			<tr>
				<td>部门名称</td>
				<td><input type="text" name="dname" value="${requestScope.deptmt.dname}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="修改"></td>
			</tr>
			</table>
		</form>
		</c:if>
	</div>
	
	<c:forEach items="${requestScope.depts}" var="dept">
	<div class="plist">
		<h2 align="center">职位</h2>
		<ul>
		<c:forEach items="${dept.posts}" var="p">
			<li>
				${p.pname}&nbsp;
				<a href="${pageContext.request.contextPath}/post/delPost?pid=${p.pid}"><img alt="删除" src="${pageContext.request.contextPath}/img/del.png"/></a>&nbsp;
				<a href="${pageContext.request.contextPath}/post/updatePost?pid=${p.pid}"><img alt="修改" src="${pageContext.request.contextPath}/img/update.png"/></a>&nbsp;
			</li>
		</c:forEach>
			<li style="width:50%; margin:5px auto;">
				<a href="#" class="insertpost"><img alt="增加" src="${pageContext.request.contextPath}/img/add.png"/></a>&nbsp;
			</li>
		</ul>
		
		<c:if test="${empty requestScope.jobPost}">
		<form action="${pageContext.request.contextPath}/post/addPost" method="post" class="addpost">
			<input type="hidden" name="did" value="${dept.did}"/>
			<table cellpadding="8" cellspacing="0">
			<tr>
				<td colspan="2" align="center">增加职位</td>
			</tr>
			<tr>
				<td>职位名称</td>
				<td><input type="text" name="pname"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="增加"></td>
			</tr>
			</table>
		</form>
		</c:if>
		<c:if test="${!empty requestScope.jobPost}">
		<c:if test="${dept.did==requestScope.jobPost.did}">
		<form action="${pageContext.request.contextPath}/post/update" method="post">
			<input type="hidden" name="did" value="${dept.did}"/>
			<input type="hidden" name="pid" value="${requestScope.jobPost.pid}"/>
			<table cellpadding="8" cellspacing="0">
			<tr>
				<td colspan="2" align="center">修改职位</td>
			</tr>
			<tr>
				<td>职位名称</td>
				<td><input type="text" name="pname" value="${requestScope.jobPost.pname}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="修改"></td>
			</tr>
			</table>
		</form>
		</c:if>
		</c:if>
		
	</div>
	</c:forEach>
</div>
</body>
</html>