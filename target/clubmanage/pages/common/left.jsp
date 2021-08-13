<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧导航menu</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/css.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/sdmenu.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script type="text/javascript">
	// <![CDATA[
	// var myMenu;
	// window.onload = function() {
	// 	myMenu = new SDMenu("my_menu");
	// 	myMenu.init();
	// };

    var myMenu;
    $(function() {
      myMenu = new SDMenu("my_menu");
      myMenu.init();
    });
	// ]]>
</script>
<style type=text/css>
html{ SCROLLBAR-FACE-COLOR: #538ec6; SCROLLBAR-HIGHLIGHT-COLOR: #dce5f0; SCROLLBAR-SHADOW-COLOR: #2c6daa; SCROLLBAR-3DLIGHT-COLOR: #dce5f0; SCROLLBAR-ARROW-COLOR: #2c6daa;  SCROLLBAR-TRACK-COLOR: #dce5f0;  SCROLLBAR-DARKSHADOW-COLOR: #dce5f0; overflow-x:hidden;}
body{overflow-x:hidden; background:url(${pageContext.request.contextPath}/static/images/admin_image/main/leftbg.jpg) left top repeat-y #f2f0f5; width:194px;}
</style>
</head>
<body onselectstart="return false;" ondragstart="return false;" oncontextmenu="return false;">
<div id="left-top">
	<div><img src="${pageContext.request.contextPath}${sessionScope.user.userImagepath}" width="44" height="44" /></div>
    <span>用户：${sessionScope.user.userName }<br>
      角色：<c:choose><c:when test="${sessionScope.user.manageId==1}">社长</c:when>
             <c:when test="${sessionScope.user.manageId==2}">超级管理员</c:when>
            <c:otherwise>普通用户</c:otherwise></c:choose></span>
</div>
    <c:if test="${sessionScope.user.manageId==2}">
    <div style="float: left" id="my_menu" class="sdmenu">
      <div class="collapsed">
        <span>用户管理</span>
        <a href="${pageContext.request.contextPath}/pages/manager/manager_add.jsp" target="mainFrame" onFocus="this.blur()">添加管理员</a>
        <a href="${pageContext.request.contextPath}/pages/manager/manager_update.jsp" target="mainFrame" onFocus="this.blur()">更新密码</a>
        <a href="${pageContext.request.contextPath}/QueryAll?startnum=1" target="mainFrame" onFocus="this.blur()">用户列表</a>
        <a href="${pageContext.request.contextPath}/pages/manager/student_add.jsp" target="mainFrame" onFocus="this.blur()">导入本校学生</a>
        <a href="${pageContext.request.contextPath}/SeleceAllStudent" target="mainFrame" onFocus="this.blur()">已导入学生管理</a>
      </div>
      <div>
        <span>社团及活动管理</span>
        <a href="${pageContext.request.contextPath}/QueryAllClub?startnum=1" target="mainFrame" onFocus="this.blur()">社团列表</a>
        <a href="${pageContext.request.contextPath}/QueryAllActivity?startnum=1" target="mainFrame" onFocus="this.blur()">社团活动列表</a>
      </div>
      <div>
        <span>审核管理</span>
        <a href="${pageContext.request.contextPath}/QueryAllClubCreat?startnum=1" target="mainFrame" onFocus="this.blur()">创建社团审批</a>
        <a href="${pageContext.request.contextPath}/SelectAllVoteAuditing?startnum=1" target="mainFrame" onFocus="this.blur()">发起投票审批</a>
      </div>
      <div>
        <span>新闻公告</span>
        <a href="${pageContext.request.contextPath}/pages/notice/notice_add.jsp" target="mainFrame" onFocus="this.blur()">添加新闻公告</a>
        <a href="${pageContext.request.contextPath}/SelectAllNotice?startnum=1" target="mainFrame" onFocus="this.blur()">更新新闻公告</a>
      </div>
    </div>
    </c:if>
<c:if test="${sessionScope.user.manageId==1}">
  <div style="float: left" id="my_menu" class="sdmenu">
    <div class="collapsed">
      <span>信息管理</span>
      <a href="${pageContext.request.contextPath}/pages/manager/manager_update.jsp" target="mainFrame" onFocus="this.blur()">更新密码</a>
    </div>
    <div>
      <span>社团活动管理</span>
      <a href="${pageContext.request.contextPath}/pages/activity/activity_add.jsp" target="mainFrame" onFocus="this.blur()">添加社团活动</a>
      <a href="${pageContext.request.contextPath}/SelectActivityByUsername" target="mainFrame" onFocus="this.blur()">社团活动列表</a>
    </div>
    <div>
      <span>社团管理</span>
      <a href="${pageContext.request.contextPath}/SelectOneClubJoinByClubManager?startnum=1&clubmanagername=${sessionScope.user.userName}" target="mainFrame" onFocus="this.blur()">加入社团审批</a>
      <a href="${pageContext.request.contextPath}/SelectClubMemberByClubName?startnum=1&clubmanagername=${sessionScope.user.userName}" target="mainFrame" onFocus="this.blur()">当前社团成员</a>
    </div>
    <div>
      <span>投票管理</span>
      <a href="${pageContext.request.contextPath}/pages/userpage/vote_add.jsp" target="mainFrame" onFocus="this.blur()">发起投票</a>
      <a href="${pageContext.request.contextPath}/UserSelectOneVote?username=${sessionScope.user.userName}" target="mainFrame" onFocus="this.blur()">修改投票</a>
      <a href="${pageContext.request.contextPath}/SelectAllVoteState?startnum=1" target="mainFrame" onFocus="this.blur()">所有投票</a>
    </div>
  </div>
</c:if>
<c:if test="${sessionScope.user.manageId==0}">
  <div style="float: left" id="my_menu" class="sdmenu">
    <div class="collapsed">
      <span>信息管理</span>
      <a href="${pageContext.request.contextPath}/pages/manager/manager_update.jsp" target="mainFrame" onFocus="this.blur()">更新密码</a>
    </div>
    <div>
      <span>社团加入管理</span>
      <a href="${pageContext.request.contextPath}/UserQueryAllClub?startnum=1" target="mainFrame" onFocus="this.blur()">社团列表</a>
      <a href="${pageContext.request.contextPath}/SelectOneClubJoin?startnum=1&username=${sessionScope.user.userName}" target="mainFrame" onFocus="this.blur()">社团申请记录</a>
      <a href="${pageContext.request.contextPath}/SelectUserJoinedClub?username=${sessionScope.user.userName}" target="mainFrame" onFocus="this.blur()">已加入社团</a>
      <a href="${pageContext.request.contextPath}/pages/club/club_add.jsp" target="mainFrame" onFocus="this.blur()">社团创建</a>
    </div>
    <div>
      <span>社团活动</span>
      <a href="${pageContext.request.contextPath}/UserQueryAllActivity?startnum=1" target="mainFrame" onFocus="this.blur()">社团活动列表</a>
      <a href="${pageContext.request.contextPath}/SelectUserJoinedActivity?username=${sessionScope.user.userName}" target="mainFrame" onFocus="this.blur()">已参与活动</a>
    </div>
    <div>
      <span>投票管理</span>
      <a href="${pageContext.request.contextPath}/pages/userpage/vote_add.jsp" target="mainFrame" onFocus="this.blur()">发起投票</a>
      <a href="${pageContext.request.contextPath}/UserSelectOneVote?username=${sessionScope.user.userName}" target="mainFrame" onFocus="this.blur()">修改投票</a>
      <a href="${pageContext.request.contextPath}/SelectAllVoteState?startnum=1" target="mainFrame" onFocus="this.blur()">所有投票</a>
    </div>
  </div>
</c:if>
</body>
</html>