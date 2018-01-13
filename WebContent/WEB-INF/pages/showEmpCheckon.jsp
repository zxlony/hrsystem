<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看我的考勤</title>
</head>
<body>
<div style="width: 650px;margin:0 auto;">
	<form action="${pageContext.request.contextPath}/checkon/lookEmpCheckon">
		<input type="hidden" name="uid" value="${requestScope.uid}">
		<select name="year">
			<option value="2016" <c:if test="${year==2016}">selected="selected"</c:if>>2016</option>
			<option value="2017" <c:if test="${year==2017}">selected="selected"</c:if>>2017</option>
			<option value="2018" <c:if test="${year==2018}">selected="selected"</c:if>>2018</option>
		</select>
		<select name="month">
			<option value="01" <c:if test="${month==01}">selected="selected"</c:if>>01</option>
			<option value="02" <c:if test="${month==02}">selected="selected"</c:if>>02</option>
			<option value="03" <c:if test="${month==03}">selected="selected"</c:if>>03</option>
			<option value="04" <c:if test="${month==04}">selected="selected"</c:if>>04</option>
			<option value="05" <c:if test="${month==05}">selected="selected"</c:if>>05</option>
			<option value="06" <c:if test="${month==06}">selected="selected"</c:if>>06</option>
			<option value="07" <c:if test="${month==07}">selected="selected"</c:if>>07</option>
			<option value="08" <c:if test="${month==08}">selected="selected"</c:if>>08</option>
			<option value="09" <c:if test="${month==09}">selected="selected"</c:if>>09</option>
			<option value="10" <c:if test="${month==10}">selected="selected"</c:if>>10</option>
			<option value="11" <c:if test="${month==11}">selected="selected"</c:if>>11</option>
			<option value="12" <c:if test="${month==12}">selected="selected"</c:if>>12</option>
		</select>
		<input type="submit" value="查询" />&nbsp;
		该月目前缺勤：${requestScope.absence}天
	</form>
	<table border="1" cellpadding="10" cellspacing="0" width="550">
		<tr>
			<th>员工</th>
			<th>上班时间</th>
			<th>下班时间</th>
			<th>出勤状态</th>
		</tr>
		<c:if test="${empty requestScope.checkons}">
			<tr>
				<td colspan="4" align="center">暂无考勤</td>
			</tr>
		</c:if>
		<c:if test="${!empty requestScope.checkons}">
		<c:forEach items="${requestScope.checkons}" var="check">
			<tr>
				<td>${check.ename}</td>
				<td><f:formatDate value="${check.startTime}" pattern="yyyy-MM-dd HH:mm:SS"/></td>
				<td><f:formatDate value="${check.endTime}" pattern="yyyy-MM-dd HH:mm:SS"/></td>
				<td>${check.status}</td>
			</tr>
		</c:forEach>
		</c:if>
		<tr>
			<td colspan="4" align="center"><input type="button" value="返回" onclick="location.href='${pageContext.request.contextPath}/checkon/back'"/></td>
		</tr>
	</table>
</div>
</body>
</html>