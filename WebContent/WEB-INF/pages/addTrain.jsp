<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty requestScope.train}">
	<form action="${pageContext.request.contextPath}/train/insert">
	<table border="1"  cellpadding="10" cellspacing="0" align="center">
		<tr>
			<td colspan="2" align="center"><h2>添加培训</h2></td>
		</tr>
		<tr>
			<td>培训名称</td>
			<td><input type="text" name="tname"></td>
		</tr>
		<tr>
			<td>培训时间</td>
			<td><input type="date" name="time"></td>
		</tr>
		<tr>
			<td>培训部门</td>
			<td>
				<select name="did">
					<c:forEach items="${requestScope.depts}" var="dept">
						<option value="${dept.did}">${dept.dname}</option>
					</c:forEach>
				</select>
			</td>
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
	
	<c:if test="${!empty requestScope.train}">
	<form action="${pageContext.request.contextPath}/train/update">
	<input type="hidden" value="${requestScope.train.tid}" name="tid"/>
	<table border="1"  cellpadding="10" cellspacing="0" align="center">
		<tr>
			<td colspan="2" align="center"><h2>修改培训</h2></td>
		</tr>
		<tr>
			<td>培训名称</td>
			<td><input type="text" name="tname" value="${requestScope.train.tname}"></td>
		</tr>
		<tr>
			<td>培训时间</td>
			<td><input type="date" name="time" value="${requestScope.train.time}"></td>
		</tr>
		<tr>
			<td>培训部门</td>
			<td>
				<select name="did">
					<c:forEach items="${requestScope.depts}" var="dept">
					<c:if test="${requestScope.train.dept.did==dept.did}">
						<option value="${dept.did}" selected="selected">${dept.dname}</option>
					</c:if>
					<c:if test="${requestScope.train.dept.did!=dept.did}">
						<option value="${dept.did}">${dept.dname}</option>
					</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="修改"/>&nbsp;&nbsp;&nbsp;
				<input type="button" value="返回" onclick="javascript:history.back(-1);"/>
			</td>
		</tr>
	</table>
	</form>
	</c:if>
</body>
</html>