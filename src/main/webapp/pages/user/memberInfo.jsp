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
    <script>
        $(function (){
            $("#name").blur(function () {
                //1 获取用户名
                var username = this.value;
                $.getJSON("memberInfoGetName?username=" + username,function (data) {
                    console.log(1==data)
                    if (1 == data) {
                        $("span.errorMsg").text("用户名已存在！");
                        document.getElementById('name').focus();
                    } else if (2 == data){
                        $("span.errorMsg").text("用户名可用！");
                    }
                    else {
                        $("span.errorMsg").text("用户名未改变！");
                    }
                });
            });
            // $("#stuid").blur(function () {
            //     //1 获取用户学号
            //     var studentid = this.value;
            //     $.getJSON("memberInfoGetStudentId?studentid=" + studentid,function (data) {
            //         console.log(1==data)
            //         if (1 == data) {
            //             $("span.errorMsg").text("学号已存在！");
            //             document.getElementById('stuid').focus();
            //         } else if (2 == data){
            //             $("span.errorMsg").text("学号可用！");
            //         }
            //         else {
            //             $("span.errorMsg").text("学号未改变！");
            //         }
            //     });
            // });
        })
    </script>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：用户管理&nbsp;&nbsp;>&nbsp;&nbsp;用户信息</td>
  </tr>
  <tr>
    <td align="left" valign="top" id="addinfo">
    <a  href="${pageContext.request.contextPath}/joinIndex"   class="">返回首页</a><div style="color: #8A0B00">${requestScope.errormessage}
    ${requestScope.msg}${requestScope.upd}</div>
        <span style="color: #8A0B00" class="errorMsg">
              <b>${ requestScope.msg }</b>
            </span>
<%--         <c:if test="${param.rs =='namewrong' }"><font -size="4px"; color=red>&nbsp;&nbsp;&nbsp;<b>没有此用户，请先添加</b></font></c:if>
	    <c:if test="${param.rs =='success' }"><font -size="4px"; color=blue>&nbsp;&nbsp;&nbsp;<b>更新成功</b></font></c:if>
    	<c:if test="${param.rs =='fail' }"><font -size="4px"; color=red>&nbsp;&nbsp;&nbsp;<b>更新失败，请重新尝试</b></font></c:if>
    	<c:if test="${param.rs =='wrong' }"><font -size="4px"; color=red>&nbsp;&nbsp;&nbsp;<b>旧密码错误</b></font></c:if>
 --%>    
 	</td>
  </tr>
  <tr>
    <td align="left" valign="top">
       <!-- 上传文件时 要改enctype="multipart/from-data-->
    <form action="MemberInfoUpdate" method="post" enctype="multipart/form-data">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr style="height:80px;">
        <td align="center" valign="middle" class="borderright borderbottom bggray">
          <img src="${pageContext.request.contextPath}${sessionScope.user.userImagepath}" width="60px" height="60px" style="border-radius: 50%;">
        </td>
         <td align="left" valign="middle" class="borderright borderbottom main-for" colspan="3">
            <input name="header" type="file" value="" >
         </td>
      </tr>

      <tr>
        <td align="left" valign="middle" class="borderright borderbottom main-for" colspan="4" style="border-left:none; border-right:none;"></td>
      </tr>

      <tr>
        <td align="right" valign="middle" class="borderright borderbottom bggray">姓名：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <input id="name" type="text" name="userName" value="${sessionScope.user.getUserName() }" class="text-word">
        </td>
        <td align="right" valign="middle" class="borderright borderbottom bggray">学号：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
<%--          <input id="stuid" type="text" name="studentId" value="${sessionScope.user.studentId }" class="text-word">--%>
        <div>${sessionScope.user.studentId }</div>
        </td>
      </tr>
        <tr>
        <td align="right" valign="middle" class="borderright borderbottom bggray">性别：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <input type="text" name="sex" value="${sessionScope.user.sex}" class="text-word">


        <td align="right" valign="middle" class="borderright borderbottom bggray">年级：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <input type="text" name="grade" value="${sessionScope.user.grade }" class="text-word">
        </tr>
      <tr>
        <td align="right" valign="middle" class="borderright borderbottom bggray">学院：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <input type="text" name="college" value="${sessionScope.user.college }" class="text-word">
        </td>

        <td align="right" valign="middle" class="borderright borderbottom bggray">邮箱：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <input type="text" name="email" value="${sessionScope.user.email }" class="text-word">
      </tr>
      <tr>
        <td align="right" valign="middle" class="borderright borderbottom bggray">联系方式：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <input type="text" name="phone" value="${sessionScope.user.phone }" class="text-word">
        </td>


        <td align="right" valign="middle" class="borderright borderbottom bggray">加入的社团：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
<%--        <input type="text" name="jcom" value="${user.joinedClub }" class="text-word">--%>
          <div>${sessionScope.user.joinedClub }</div>
        </td>
        </tr>
       
      <tr>
      	<td>
      		 <input name="ope" type="hidden" value="minfo"/>
      	</td>
      </tr>
      
      <tr>
        <td align="center" valign="middle" class="borderright borderbottom main-for" colspan="2" style="padding-left:38%; border-right:none;">
          <input name="" type="submit" value="更新" class="text-but" >
        </td>

      </tr>

    </table>
    </form>
    </td>
    </tr>
</table>
</body>
</html>