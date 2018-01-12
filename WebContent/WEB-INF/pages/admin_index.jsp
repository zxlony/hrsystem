<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员界面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adminView.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/adminView.js"></script>
</head>
<body>
<div id="box">
    <div id="nav">
        <ul>
        	<li onmouseover="display(this)" onmouseout="hide(this)">
                <a href="javascript:;">招聘管理</a>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/recruit/addRecruit">增加招聘信息</a></li>
                    <li><a href="${pageContext.request.contextPath}/recruit/lookRecruit">查看招聘信息</a></li>
                    <li><a href="${pageContext.request.contextPath}/apply/lookApply">查看已投简历</a></li>
                </ul>
            </li>
            <li onmouseover="display(this)" onmouseout="hide(this)">
                <a href="${pageContext.request.contextPath}/dept/admQueryAll">部门管理</a>
            </li>
            <li onmouseover="display(this)" onmouseout="hide(this)">
                <a href="javascript:;">培训管理</a>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/train/add">增加培训</a></li>
                    <li><a href="${pageContext.request.contextPath}/train/lookTrain">查看培训</a></li>
                </ul>
            </li>
            <li onmouseover="display(this)" onmouseout="hide(this)">
                <a href="javascript:;">员工管理</a>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/emp/lookOnEmp">在职员工</a></li>
                    <li><a href="${pageContext.request.contextPath}/emp/lookLeaveEmp">离职员工</a></li>
                </ul>
            </li>
            <li onmouseover="display(this)" onmouseout="hide(this)">
                <a href="#">奖惩管理</a>
            </li>
            <li onmouseover="display(this)" onmouseout="hide(this)">
                <a href="javascript:;">薪资管理</a>
                <ul>
                    <li><a href="#">查看薪资</a></li>
                    <li><a href="#">查看工资异议</a></li>
                </ul>
            </li>
            <li onmouseover="display(this)" onmouseout="hide(this)">
                <a href="#">退出</a>
            </li>
        </ul>
    </div>
    <div id="content"></div>
</div>
</body>
</html>