<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
#searchmain{ font-size:12px;}
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF; float:left}
#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(${pageContext.request.contextPath}/static/images/admin_image/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
#search a.add{ background:url(${pageContext.request.contextPath}/static/images/admin_image/main/add.jpg) no-repeat -3px 7px #548fc9; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF; float:right}
#search a:hover.add{ text-decoration:underline; color:#d2e9ff;}
#main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
#main-tab th{ font-size:12px; background:url(${pageContext.request.contextPath}/static/images/admin_image/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
#main-tab td{ font-size:12px; line-height:40px;}
#main-tab td a{ font-size:12px; color:#548fc9;}
#main-tab td a:hover{color:#565656; text-decoration:underline;}
.bordertop{ border-top:1px solid #ebebeb}
.borderright{ border-right:1px solid #ebebeb}
.borderbottom{ border-bottom:1px solid #ebebeb}
.borderleft{ border-left:1px solid #ebebeb}
.gray{ color:#dbdbdb;}
td.fenye{ padding:10px 0 0 0; text-align:right;}
.bggray{ background:#f9f9f9}
</style>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：用户管理&nbsp;&nbsp;>&nbsp;&nbsp;用户列表</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	         <form method="post" action="SelectOneUser">
	         <span>成员：</span>
	         <input type="text" name="username" placeholder="请输入要查找的用户名字" value="" class="text-word">
	         <input type="hidden" name="search" value="member"/>
	         <input name="" type="submit" value="查询" class="text-but">
	         </form>
         </td>
<%--  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="${pageContext.request.contextPath}/pages/user/regist.jsp" target="mainFrame" onFocus="this.blur()" class="add">新增成员</a></td>--%>
  		</tr>
	</table>
    </td>
  </tr>
  
  <tr>
    <td align="left" valign="top">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
        <th align="center" valign="middle" class="borderright">学号</th>
        <th align="center" valign="middle" class="borderright">姓名</th>
        <th align="center" valign="middle" class="borderright">性别</th>
        <th align="center" valign="middle" class="borderright">权限</th>
        <th align="center" valign="middle" class="borderright">年级</th>
        <th align="center" valign="middle" class="borderright">学院</th>
        <th align="center" valign="middle" class="borderright">电话</th>
        <th align="center" valign="middle" class="borderright">邮箱</th>
        <th align="center" valign="middle" class="borderright">已加入社团</th>
        <th align="center" valign="middle">操作</th>
      </tr>
     
      <c:forEach items="${users}" var="useritem" varStatus="status">
      <tr class="bggray" onMouseOut="this.style.backgroundColor='#f9f9f9'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom"> ${useritem.studentId}</td>
        <td align="center" valign="middle" class="borderright borderbottom">
            <a href="${pageContext.request.contextPath}/JoinUserInfo?username=${useritem.userName}">${useritem.userName}</a></td>
        <td align="center" valign="middle" class="borderright borderbottom">${useritem.sex }</td>
        <td align="center" valign="middle" class="borderright borderbottom">
        <c:choose>
                   <c:when test="${useritem.manageId == 0}">普通用户</c:when>
                   <c:when test="${useritem.manageId == 1}">社团管理员</c:when>
                   <c:otherwise>超级管理员</c:otherwise>
        </c:choose>
               </td>
        <td align="center" valign="middle" class="borderright borderbottom">${useritem.grade}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${useritem.college}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${useritem.phone}</td>
		<td align="center" valign="middle" class="borderright borderbottom">${useritem.email}</td>
		<td align="center" valign="middle" class="borderright borderbottom">${useritem.joinedClub}</td>
        <td align="center" valign="middle" class="borderbottom">
            <a href="${pageContext.request.contextPath}/JoinUpdateOne?username=${useritem.userName}" target="mainFrame" onFocus="this.blur()" class="add">编辑</a><span class="gray">&nbsp;|&nbsp;</span>
            <a href="DelectOneUser?username=${useritem.userName}&startnum=1"  target="mainFrame" onFocus="this.blur()" class="add" onclick="return confirm('确定删除吗？')">删除</a></td>
      </tr>
      </c:forEach>
     
    </table>
    
    </td>
  </tr>
    <c:if test="${requestScope.loginsize=='a'}">
  <tr>
    <td align="left" valign="top" class="fenye">共有${userpage.total} 条记录，当前第${userpage.pageNum}页
        &nbsp; &nbsp; &nbsp;
         		<a href="QueryAll?startnum=1">首页</a>
        <c:if test="${userpage.pageNum>1}" ><a href="QueryAll?startnum=${userpage.prePage}">上一页</a></c:if>
        <c:if test="${userpage.pageNum==1}" ><a href="QueryAll?startnum=1">上一页</a></c:if>
        <c:if test="${userpage.pageNum<userpage.pages}" ><a href="QueryAll?startnum=${userpage.nextPage}">下一页</a></c:if>
        <c:if test="${userpage.pageNum==userpage.pages}" ><a href="QueryAll?startnum=${userpage.pages}">下一页</a></c:if>
         		<a href="QueryAll?startnum=${userpage.pages}">尾页</a><br>

    </td>
  </tr>
    </c:if>
    <tr>   <td><div align="center" style="color: #8A0B00">${requestScope.msg}</div></td></tr>
        </br>
        <c:if test="${requestScope.msg1=='user'}">
      <td width="90%" style="color: #8A0B00" align="center" valign="middle">
          <form method="post" action="QueryAll?startnum=1">
              <input name="" type="submit" value="重置" class="text-but">
          </form>
      </td>
        </c:if>
</table>
</body>
</html>