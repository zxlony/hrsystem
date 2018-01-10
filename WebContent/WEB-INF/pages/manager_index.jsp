<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门主管界面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/managerView.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/adminView.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		var flag = true;
		$(".message").each(function(){
			if($(this).val()=='部门有应聘者，请注意前去面试'){
				if(flag){
					alert($(this).val());
					flag=false;
				}
			}else{
				alert($(this).val());
			}
		})
		
		$(".exit").click(function(){
			var flag = confirm("是否确认退出？");
			if(flag){
				return true;
			}
			return false;
		})
	})
</script>
</head>
<body>
<p>当前用户:${sessionScope.user.uname}</p>
<c:if test="${!empty requestScope.msgs}">
	<c:forEach items="${requestScope.msgs}" var="msg">
		<input type="hidden" value="${msg.msg}" class="message">
	</c:forEach>
</c:if>
<div id="box">
    <div id="nav">
        <ul>
        	<li onmouseover="display(this)" onmouseout="hide(this)">
                <a href="javascript:;">通知管理</a>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/apply/mgrLookUserApply?uid=${sessionScope.user.uid}">面试通知</a></li>
                    <li><a href="${pageContext.request.contextPath}/#">培训通知</a></li>
                </ul>
            </li>
            <li onmouseover="display(this)" onmouseout="hide(this)">
                <a href="#">绩效管理</a>
            </li>
            <li onmouseover="display(this)" onmouseout="hide(this)">
                <a href="${pageContext.request.contextPath}/login.jsp" class="exit">退出</a>
            </li>
        </ul>
    </div>
    <div id="content"></div>
</div>
</body>
</html>