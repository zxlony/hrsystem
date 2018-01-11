<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工查看部门</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	$(".plist").hide();
	$("#dlist li a").each(function(id,item){
		$(this).click(function(){
			$(".plist").hide();
			$(".plist").eq(id).show();
		})
	})
})
</script>
<style type="text/css">
	#content{width: 600px; margin: 0 auto;}
	#dlist,.plist{border: 1px solid black;background: #87ceeb;width: 150px;float: left}
	ul{list-style-type: none;}
	ul li{height: 35px; line-height: 35px;}
</style>
</head>
<body>
<div id="content">
	<div id="dlist">
		<h2 align="center">部门</h2>
		<ul>
		<c:forEach items="${requestScope.depts}" var="dept">
			<li><a href="#">${dept.dname}</a></li>
		</c:forEach>
		</ul>
	</div>
	<c:forEach items="${requestScope.depts}" var="dept">
	<div class="plist">
		<h2 align="center">职位</h2>
		<ul>
		<c:forEach items="${dept.posts}" var="p">
			<li>${p.pname}</li>
		</c:forEach>
		</ul>
	</div>
	</c:forEach>
</div>
</body>
</html>