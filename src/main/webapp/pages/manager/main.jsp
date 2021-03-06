<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主要内容区main</title>
<link rel="icon" href="${pageContext.request.contextPath}/static/images/user_images/pande.png">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/css.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css" />
<style>
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
#main{ font-size:12px;}
#main span.time{ font-size:14px; color:#528dc5; width:100%; padding-bottom:10px; float:left}
#main div.top{ width:100%; background:url(${pageContext.request.contextPath}/static/images/admin_image/main/main_r2_c2.jpg) no-repeat 0 10px; padding:0 0 0 15px; line-height:35px; float:left}
#main div.sec{ width:100%; background:url(${pageContext.request.contextPath}/static/images/admin_image/main/main_r2_c2.jpg) no-repeat 0 15px; padding:0 0 0 15px; line-height:35px; float:left}
.left{ float:left}
#main div a{ float:left}
#main span.num{  font-size:30px; color:#538ec6; font-family:"Georgia","Tahoma","Arial";}
.left{ float:left}
div.main-tit{ font-size:14px; font-weight:bold; color:#4e4e4e; background:url(${pageContext.request.contextPath}/static/images/admin_image/main/main_r4_c2.jpg) no-repeat 0 33px; width:100%; padding:30px 0 0 20px; float:left}
div.main-con{ width:100%; float:left; padding:10px 0 0 20px; line-height:36px;}
div.main-corpy{ font-size:14px; font-weight:bold; color:#4e4e4e; background:url(${pageContext.request.contextPath}/static/images/admin_image/main/main_r6_c2.jpg) no-repeat 0 33px; width:100%; padding:30px 0 0 20px; float:left}
div.main-order{ line-height:30px; padding:10px 0 0 0;}
</style>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="main">
  <tr>
    <td colspan="2" align="left" valign="top">
    <span class="time"><strong>上午好！${sessionScope.user.userName}</strong><u>[
        <c:choose><c:when test="${sessionScope.user.manageId==1}">社长</c:when>
        <c:when test="${sessionScope.user.manageId==2}">超级管理员</c:when>
        <c:otherwise>普通用户</c:otherwise></c:choose>]</u></span>
    <div class="top"><span class="left">当前网站注册人数：<font color="#538ec6"><strong>288</strong></font>人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;超级管理员：<font color="#538ec6"><strong>1</strong></font>人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;社团管理员：<font color="#538ec6"><strong>20</strong></font>人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </span>
    </div>
    <div class="sec">这是您第<span class="num">80</span>次,登录！</div>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top" width="50%">
    <div class="main-tit">社团信息</div>
    <div class="main-con">
     当前入住社团：20 个<br/>
	社团类别：5  种<br/>
	共有成员：1564  人<br/>
	程序编码：UTF-8<br/>
	<br/>
    </div>
    </td>
    <td align="left" valign="top" width="49%">
    <div class="main-tit">网站信息</div>
    <div class="main-con">
     网站访问量：2388 次<br>
     程序编码：UTF-8<br/>
	服务器软件：Apache/8.0.82<br/>
	MYSQL版本：5.5.28<br/>
	使用域名：192.168.1.1 <br/>
	<br/>
    </div>
    </td>
  </tr>
  <tr>
    <td colspan="2" align="left" valign="top">
    <div class="main-corpy">系统提示</div>
    <div class="main-order">1=>如您在使用过程有发现出错请及时与我们取得联系!<br/>
2=>强烈建议您将IE7以上版本或其他的浏览器</div>
    </td>
  </tr>
</table>
<c:if test="${sessionScope.clubname1!=null and sessionScope.user.manageId ==0}">
    <script type="text/javascript">
        window.location.replace("${pageContext.request.contextPath}/UserSelectOneClub?clubname=${sessionScope.clubname1}") ;

    </script>
</c:if>
<c:if test="${sessionScope.noticename1!=null and sessionScope.user.manageId ==0}">
    <script type="text/javascript">
        window.location.replace("${pageContext.request.contextPath}/SelectOneNotice?noticename=${sessionScope.noticename1}") ;

    </script>
</c:if>
<c:if test="${sessionScope.activityname1!=null and sessionScope.user.manageId ==0}">
    <script type="text/javascript">
        window.location.replace("${pageContext.request.contextPath}/UserSelectOneActivity?activityname=${sessionScope.activityname1}") ;

    </script>
</c:if>
</body>
</html>