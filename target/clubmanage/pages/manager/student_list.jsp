<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生列表main</title>
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
    <td width="99%" align="left" valign="top">您的位置：用户管理&nbsp;&nbsp;>&nbsp;&nbsp;已导入学生管理</td>
  </tr>
    <tr>
    <td>
        <div>
            <a href="${pageContext.request.contextPath}/SeleceAllStudentByGrade?grade=大一" style="border-style: solid;border-color: #8A0B00;margin-left: 20px;color: #4cae4c" >只查看大一</a>
            <a href="${pageContext.request.contextPath}/SeleceAllStudentByGrade?grade=大二" style="border-style: solid;border-color: #8A0B00;margin-left: 20px;color: #4cae4c">只查看大二</a>
            <a href="${pageContext.request.contextPath}/SeleceAllStudentByGrade?grade=大三" style="border-style: solid;border-color: #8A0B00;margin-left: 20px;color: #4cae4c">只查看大三</a>
            <a href="${pageContext.request.contextPath}/SeleceAllStudentByGrade?grade=大四" style="border-style: solid;border-color: #8A0B00;margin-left: 20px;color: #4cae4c">只查看大四</a>
            <a href="${pageContext.request.contextPath}/DeleteAllStudentByGrade?grade=大一"  onclick="return confirm('确定删除吗？')" style="border-style: solid;color: #4cae4c;border-color: #8A0B00;margin-left: 20px">删除大一年级</a>
            <a href="${pageContext.request.contextPath}/DeleteAllStudentByGrade?grade=大二"  onclick="return confirm('确定删除吗？')" style="border-style: solid;color: #4cae4c;border-color: #8A0B00;margin-left: 20px">删除大二年级</a>
            <a href="${pageContext.request.contextPath}/DeleteAllStudentByGrade?grade=大三"  onclick="return confirm('确定删除吗？')" style="border-style: solid;color: #4cae4c;border-color: #8A0B00;margin-left: 20px">删除大三年级</a>
            <a href="${pageContext.request.contextPath}/DeleteAllStudentByGrade?grade=大四"  onclick="return confirm('确定删除吗？')" style="border-style: solid;color: #4cae4c;border-color: #8A0B00;margin-left: 20px">删除大四年级</a>
            <p style="margin-left: 20px;color: #2c6daa">${requestScope.msg}</p>
        </div>
    </td>
    </tr>
  <tr>
    <td align="left" valign="top">
    <table width="99%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
          <th align="center" valign="middle" class="borderright">学号</th>
        <th align="center" valign="middle" class="borderright">年级</th>
      </tr>
      <c:forEach items="${students }" var="student" varStatus="status">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
             <td align="center" valign="middle" class="borderright borderbottom">${student.studentNameid }</td>
             <td align="center" valign="middle" class="borderright borderbottom">${student.grade }</td>
      </tr>
      </c:forEach>
      
    </table>
    </td>

    </tr>


</table>
</body>
</html>