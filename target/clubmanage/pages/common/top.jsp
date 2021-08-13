<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台页面头部</title>
<link rel="icon" href="${pageContext.request.contextPath}/static/images/user_images/pande.png">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/css.css" />
</head>
<body onselectstart="return false" oncontextmenu=return(false) style="overflow-x:hidden;">
<!--禁止网页另存为-->
<noscript><iframe scr="*.htm"></iframe></noscript>
<!--禁止网页另存为-->
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="header">
  <tr>
    <td rowspan="2" align="left" valign="top" id="logo"><img src="${pageContext.request.contextPath}/static/images/user_images/xiaohui.png" width="74" height="74"></td>
    <td align="left" valign="bottom">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="left" valign="bottom" id="header-name">掌上社团</td>
        <td align="right" valign="top" id="header-right">
        	<a href="${pageContext.request.contextPath}/loginOut" target="_top"  class="admin-out" >注销</a>
	        <a href="${pageContext.request.contextPath}/pages/manager/manager_update.jsp" target="mainFrame" onFocus="this.blur()" class="admin-reset">修改密码</a>
            <a href="${pageContext.request.contextPath}/pages/manager/main.jsp" target="mainFrame" onFocus="this.blur()" class="admin-home">管理首页</a>
        	<a href="${pageContext.request.contextPath}/joinIndex"  target="_top" onFocus="this.blur()" class="admin-index">网站首页</a>
            <span>
<!-- 日历 -->
<SCRIPT type=text/javascript src="${pageContext.request.contextPath}/static/js/clock.js"></SCRIPT>
<SCRIPT type=text/javascript>showcal();</SCRIPT>
            </span>
        </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="left" valign="bottom">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="left" valign="top" id="header-admin">后台管理系统</td>
        <td align="left" valign="bottom" id="header-menu">

        </td>
      </tr>
    </table></td>
  </tr>
</table>

</body>
</html>