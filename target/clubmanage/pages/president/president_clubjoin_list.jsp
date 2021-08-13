<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>社团列表main</title>
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
    <td width="99%" align="left" valign="top">您的位置：社团管理&nbsp;&nbsp;>&nbsp;&nbsp;加入社团审批</td>
  </tr>
  
<%--  <tr>--%>
<%--    <td align="left" valign="top">--%>
<%--    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">--%>
<%--  		<tr>--%>
<%--   		 <td width="90%" align="left" valign="middle">--%>
<%--	         <form method="post" action="SelectOneNotice">--%>
<%--	         <span>社团名：</span>--%>
<%--	         <input type="text" name="noticename"  placeholder="请输入要查找新闻的社团名" value="" class="text-word">--%>
<%--	         <input name="" type="submit" value="查询" class="text-but">--%>
<%--	         </form>--%>
<%--         </td>--%>
<%--&lt;%&ndash;  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="community_add.jsp" target="mainFrame" onFocus="this.blur()" class="add">添加社团</a></td>&ndash;%&gt;--%>
<%--  		</tr>--%>
<%--	</table>--%>
<%--    </td>--%>
<%--  </tr>--%>
  
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
          <th align="center" valign="middle" class="borderright">申请人</th>
        <th align="center" valign="middle" class="borderright">社团名</th>
        <th align="center" valign="middle" class="borderright">申请时间</th>
          <th align="center" valign="middle" class="borderright">已加入社团</th>
          <th align="center" valign="middle" class="borderright">审核状态</th>
        <th align="center" valign="middle">操作</th>
      </tr>
      <c:forEach items="${clubjoins }" var="clubjoin" varStatus="status">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
          <td align="center" valign="middle" class="borderright borderbottom">${clubjoin.userjoinName }</td>
        <td align="center" valign="middle" class="borderright borderbottom">${clubjoin.clubName }</td>
        <td align="center" valign="middle" class="borderright borderbottom"><fmt:formatDate value="${clubjoin.joinDate}" pattern="yyyy/MM/dd "/></td>
        <td align="center" valign="middle" class="borderright borderbottom">${clubjoin.joinedClub }</td>
          <td align="center" valign="middle" class="borderright borderbottom">
              <c:choose>
                  <c:when test="${clubjoin.clubjoinState == 1 }">待审核</c:when>
                  <c:when test="${clubjoin.clubjoinState == 0}">已拒绝</c:when>
                  <c:when test="${clubjoin.clubjoinState == 2}">已同意</c:when>
              </c:choose>
          </td>
          <td align="center" valign="middle" class="borderbottom">
              <c:choose>
                  <c:when test="${clubjoin.clubjoinState == 1 }">
                      <a href="${pageContext.request.contextPath}/DoClubJoinAuditing?auditing=2&clubjoinid=${clubjoin.clubjoinId}"  target="mainFrame" onFocus="this.blur()" class="add" onclick="return confirm('确定同意吗？')">同意</a><span class="gray">&nbsp;|&nbsp;</span>
                  <a href="${pageContext.request.contextPath}/DoClubJoinAuditing?auditing=0&clubjoinid=${clubjoin.clubjoinId}" target="mainFrame" onFocus="this.blur()" class="add"onclick="return confirm('确定拒绝吗？')">拒绝</a>
                  </c:when>
                  <c:when test="${clubjoin.clubjoinState == 0}"><div style="color: #8A0B00">已拒绝</div></c:when>
                  <c:when test="${clubjoin.clubjoinState == 2}"><div style="color: #4cae4c">已同意</div> </c:when>

              </c:choose>
          </td>
      </tr>
      </c:forEach>
      
    </table></td>
    </tr>
    <c:if test="${requestScope.loginsize=='a'}">
  <tr>
      <td align="left" valign="top" class="fenye">共有${clubjoinpage.total} 条记录，当前第${clubjoinpage.pageNum}页
          &nbsp; &nbsp; &nbsp;
          <a href="SelectOneClubJoinByClubManager?startnum=1&clubmanagername=${sessionScope.user.userName}">首页</a>
          <c:if test="${clubjoinpage.pageNum>1}" ><a href="SelectOneClubJoinByClubManager?startnum=${clubjoinpage.prePage}&clubmanagername=${sessionScope.user.userName}">上一页</a></c:if>
          <c:if test="${clubjoinpage.pageNum==1}" ><a href="SelectOneClubJoinByClubManager?startnum=1&clubmanagername=${sessionScope.user.userName}">上一页</a></c:if>
          <c:if test="${clubjoinpage.pageNum<clubjoinpage.pages}" ><a href="SelectOneClubJoinByClubManager?startnum=${clubjoinpage.nextPage}&clubmanagername=${sessionScope.user.userName}">下一页</a></c:if>
          <c:if test="${clubjoinpage.pageNum==clubjoinpage.pages}" ><a href="SelectOneClubJoinByClubManager?startnum=${clubjoinpage.pages}&clubmanagername=${sessionScope.user.userName}">下一页</a></c:if>
          <a href="SelectOneClubJoinByClubManager?startnum=${clubjoinpage.pages}&clubmanagername=${sessionScope.user.userName}">尾页</a>

          <br>
      </td>
  </tr> </c:if>
    <tr>   <td><div align="center" style="color: #8A0B00">${requestScope.msg}</div></td></tr>
          </br>
      <c:if test="${requestScope.msg1=='notice'}">
      <td width="90%" style="color: #8A0B00" align="center" valign="middle">
          <form method="post" action="SelectOneClubJoinByClubManager?startnum=1&clubmanagername=${sessionScope.user.userName}">
              <input name="" type="submit" value="重置" class="text-but">
          </form>
      </td>
      </c:if>

</table>
</body>
</html>