<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改招聘信息</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
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
	<p>当前用户:${sessionScope.user.uname}</p>
	<c:if test="${empty requestScope.recruit}">
	<form action="${pageContext.request.contextPath}/recruit/insertRecruit">
	<table border="1"  cellpadding="10" cellspacing="0" align="center">
		<tr>
			<td colspan="2" align="center"><h2>添加招聘信息</h2></td>
		</tr>
		<tr>
			<td>招聘岗位</td>
			<td>
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
			</td>
		</tr>
		<tr>
			<td>岗位需求</td>
			<td><textarea rows="6" cols="18" name="description"></textarea></td>
		</tr>
		<tr>
			<td>面试地址</td>
			<td><input type="text" name="address" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="保存"/>&nbsp;&nbsp;&nbsp;
				<input type="button" value="返回" onclick="javascript:history.back(-1);"/>
			</td>
		</tr>
	</table>
	</form>
	</c:if>
	
	<c:if test="${!empty requestScope.recruit}">
	<form action="${pageContext.request.contextPath}/recruit/update">
	<input type="hidden" name="rid" value="${requestScope.recruit.rid}">
	<table border="1"  cellpadding="10" cellspacing="0" align="center">
		<tr>
			<td colspan="2" align="center"><h2>修改招聘信息</h2></td>
		</tr>
		<tr>
			<td>招聘岗位</td>
			<td>
				<select name="job">
					<c:forEach items="${requestScope.depts}" var="dept">
						<c:if test="${deptStr==dept.dname}">
							<option value="${dept.dname}" selected="selected">${dept.dname}</option>
						</c:if>
						<c:if test="${deptStr!=dept.dname}">
							<option value="${dept.dname}">${dept.dname}</option>
						</c:if>
					</c:forEach>
				</select>
				<!-- 多个select -->
				<c:forEach items="${requestScope.depts}" var="dept">
					<select class="po">
						<c:forEach items="${dept.posts}" var="p">
							<c:if test="${postStr==p.pname}">
								<option value="${p.pname}" selected="selected">${p.pname}</option>
							</c:if>
							<c:if test="${postStr!=p.pname}">
								<option value="${p.pname}">${p.pname}</option>
							</c:if>
						</c:forEach>
					</select>
				</c:forEach>			
			</td>
		</tr>
		<tr>
			<td>岗位需求</td>
			<td><textarea rows="6" cols="18" name="description">${requestScope.recruit.description}</textarea></td>
		</tr>
		<tr>
			<td>面试地址</td>
			<td><input type="text" name="address" value="${requestScope.recruit.address}" /></td>
		</tr>
		<tr>
			<td>发布时间</td>
			<td><f:formatDate value="${requestScope.recruit.pubdate}" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="更新"/>&nbsp;&nbsp;&nbsp;
				<input type="button" value="返回" onclick="javascript:history.back(-1);"/>
			</td>
		</tr>
	</table>
	</form>
	</c:if>
</body>
</html>