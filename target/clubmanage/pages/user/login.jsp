<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="${pageContext.request.contextPath}/static/images/user_images/pande.png">
    <title>Login</title>
</head>
     <link href="${pageContext.request.contextPath}/static/css/login.css" type="text/css" rel="stylesheet" />
	<!-- js files -->
	<script src="${pageContext.request.contextPath}/static/js/login.js"></script>
	<!-- /js files -->
</head>
<body>
    <div class="wrap">
        <div class="container">
            <h1>欢迎</h1>
            <c:if test="${requestScope.error1 =='loginerror' }"><font color=red >用户名或密码错误</font></c:if>
            
            <form name="myform" action="${pageContext.request.contextPath}/Login" method="post">
<%--            	<%if ${return_uri}"!=null) {%>--%>
<%--				<input type="hidden" name="return_uri" value="<%="${return_uri}"%>"/>--%>
<%--				<%} %>--%>
                <input name="username" type="text" placeholder="登录名"value="${requestScope.user.getUserName()}"/>
                <input name="userpass" type="password" placeholder="密码" />
                <input type="submit" value="登录" onclick="return check(this)"/>
                <input name="lru" type="hidden"  value="login"/>
                <input name="log" type="hidden" value="log"/>
            </form>
			<div id="regst">
                如果你还没有账户，请点击&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/pages/user/regist.jsp">注册</a>
            </div>
        </div>
        <ul>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
</body>
</html>