<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF}
#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(${pageContext.request.contextPath}/static/images/admin_image/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
#search a.add{ background:url(${pageContext.request.contextPath}/static/images/admin_image/main/add.jpg) no-repeat 0px 6px; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF}
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
.bggray{ background:#f9f9f9; font-size:14px; font-weight:bold; padding:10px 10px 10px 0; width:120px;}
.main-for{ padding:10px;}
.main-for input.text-word{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; padding:0 10px;}
.main-for select{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666;}
.main-for input.text-but{ width:100px; height:40px; line-height:30px; border: 1px solid #cdcdcd; background:#e6e6e6; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#969696; float:left; margin:0 10px 0 0; display:inline; cursor:pointer; font-size:14px; font-weight:bold;}
#addinfo a{ font-size:14px; font-weight:bold; background:url(${pageContext.request.contextPath}/static/images/admin_image/main/addinfoblack.jpg) no-repeat 0 1px; padding:0px 0 0px 20px; line-height:45px;}
#addinfo a:hover{ background:url(${pageContext.request.contextPath}/static/images/admin_image/main/addinfoblue.jpg) no-repeat 0 1px;}
</style>
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>

</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：社团及活动管理&nbsp;&nbsp;>&nbsp;&nbsp;社团修改</td>
  </tr>
  <tr>
    <td align="left" valign="top" id="addinfo">
    <a  href="${pageContext.request.contextPath}/QueryAllClub?startnum=1"   class="">返回社团列表</a>
<%--      <div style="color: #8A0B00">${requestScope.errormessage}--%>
<%--    ${requestScope.msg}${requestScope.upd}</div>--%>
        <span style="color: #8A0B00" class="errorMsg">
              <b>${ requestScope.msg }</b>
            </span>

 	</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <form action="UpdateClub" method="post" >
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">

      <tr>
        <td align="left" valign="middle" class="borderright borderbottom main-for" colspan="4" style="border-left:none; border-right:none;"></td>
      </tr>

      <tr>
        <td align="right" valign="middle" class="borderright borderbottom bggray">社团名：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
          <div>${club.clubName }</div>
          <input type="hidden" name="clubId" value="${club.clubId}">
        </td>
        <td align="right" valign="middle" class="borderright borderbottom bggray">所属类别：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
          <select name="clubClass" id="level1">
            <option value="1" >&nbsp;&nbsp;科技创新</option>
            <option value="2" >&nbsp;&nbsp;理论研究</option>
            <option value="3" >&nbsp;&nbsp;社会服务</option>
            <option value="4" >&nbsp;&nbsp;文化宣扬</option>
            <option value="5" >&nbsp;&nbsp;体育竞技</option>
          </select>
        </td>
      </tr>
        <tr>
        <td align="right" valign="middle" class="borderright borderbottom bggray">社团宗旨：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <input type="text" name="clubTenet" value="${club.clubTenet}" class="text-word">


        <td align="right" valign="middle" class="borderright borderbottom bggray">社团介绍：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <input type="text" name="clubIntroduction" value="${club.clubIntroduction}" class="text-word">
        </tr>

      <tr>
        <td align="center" valign="middle" class="borderright borderbottom main-for" colspan="2" style="padding-left:38%; border-right:none;">
          <input name="" type="submit" value="修改" class="text-but" >
        </td>

      </tr>

    </table>
    </form>
    </td>
    </tr>
</table>
</body>
</html>