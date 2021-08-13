<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
    <script src="static/js/jquery.min.js"></script>

</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：投票管理&nbsp;&nbsp;>&nbsp;&nbsp;所有投票</td>
  </tr>

  <tr>
    <td align="left" valign="top">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
        <th align="center" valign="middle" class="borderright">发起人姓名</th>
        <th align="center" valign="middle" class="borderright">题目内容</th>
          <th align="center" valign="middle" class="borderright">开始时间</th>
          <th align="center" valign="middle" class="borderright">结束时间</th>
          <th align="center" valign="middle" class="borderright">赞成选项内容</th>
          <th align="center" valign="middle" class="borderright">拒绝选项内容</th>
      </tr>
     
      <c:forEach items="${votes}" var="vote" varStatus="status">
      <tr class="bggray" onMouseOut="this.style.backgroundColor='#f9f9f9'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom"> ${vote.userName}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${vote.voteContent}</td>
          <td align="center" valign="middle" class="borderright borderbottom"><fmt:formatDate value="${vote.startDate}" pattern="yyyy/MM/dd "/></td>
          <td align="center" valign="middle" class="borderright borderbottom"><fmt:formatDate value="${vote.endDate}" pattern="yyyy/MM/dd "/></td>
          <td id="${'yesitemnum'.concat(vote.voteId)}"  align="center" valign="middle" class="borderright borderbottom yesitemnum">
              <a id="${'yesitem'.concat(vote.voteId)}"  style="color: #8A0B00" target="mainFrame" onFocus="this.blur()" class="add yesitem" >${vote.voteYesitem}</a>
              <div id="${'hiddenid'.concat(vote.voteId)}" hidden="hidden">${vote.voteId}</div>
          </td>
          <td id="${'noitemnum'.concat(vote.voteId)}"  align="center" valign="middle" class="borderright borderbottom noitemnum">
              <a id="${'noitem'.concat(vote.voteId)}"   target="mainFrame" onFocus="this.blur()" class="add noitem">${vote.voteNoitem}</a>
              <div id="${'hiddenid'.concat(vote.voteId)}" hidden="hidden">${vote.voteId}</div>
          </td>
      </tr>
      </c:forEach>
     
    </table>
    
    </td>
  </tr>
    <c:if test="${requestScope.loginsize=='a'}">
  <tr>
    <td align="left" valign="top" class="fenye">共有${votepage.total} 条记录，当前第${votepage.pageNum}页
        &nbsp; &nbsp; &nbsp;
         		<a href="SelectAllVoteAuditing?startnum=1">首页</a>
        <c:if test="${votepage.pageNum>1}" ><a href="SelectAllVoteAuditing?startnum=${votepage.prePage}">上一页</a></c:if>
        <c:if test="${votepage.pageNum==1}" ><a href="SelectAllVoteAuditing?startnum=1">上一页</a></c:if>
        <c:if test="${votepage.pageNum<votepage.pages}" ><a href="SelectAllVoteAuditing?startnum=${votepage.nextPage}">下一页</a></c:if>
        <c:if test="${votepage.pageNum==votepage.pages}" ><a href="SelectAllVoteAuditing?startnum=${votepage.pages}">下一页</a></c:if>
         		<a href="SelectAllVoteAuditing?startnum=${votepage.pages}">尾页</a><br>
    </td>
  </tr>
    </c:if>
    <tr>   <td><div align="center" style="color: #8A0B00">${requestScope.msg}</div></td></tr>
        </br>
        <c:if test="${requestScope.msg1=='vote'}">
      <td width="90%" style="color: #8A0B00" align="center" valign="middle">
          <form method="post" action="SelectAllVoteAuditing?startnum=1">
              <input name="" type="submit" value="重置" class="text-but">
          </form>
      </td>
        </c:if>
</table>
</body>
<script type="text/javascript">
    $(document).ready(function(){
        $("a.yesitem").click(function (){
            var voteid = $(this).next().text()
            var votedate = null;
            $.ajaxSettings.async = false;
            $.getJSON("JoinVoteItem?item=1&id="+voteid,function (date){
                votedate = date;
            })
            $.ajaxSettings.async = true;
                console.log(parseFloat(votedate.yesNumber.toString()).toFixed(3))
                // $(this).parent().html("");
                var nextdom = $(this).parent().next();
                var str = "";
                var percentage = ((parseFloat(votedate.yesNumber.toString()).toFixed(2)/parseFloat(votedate.joinedNumber.toString()).toFixed(2))*100).toFixed(2) + '%';
                // document.getElementById("#yesitem").innerHTML = ((date.yesNumber/date.joindeNumber)*100).toFixed(2) + '%';
                str = '<div align="left" style="width:100%;box-sizing:border-box;height: 34px;line-height: 34px;margin-top: 5px;">'
                    // + '<div style="float: left;height: 34px;width:70px;line-height: 34px;">'
                    // +'</div>'
                    +'<div style="position: relative;margin-top:10px;float: left;height: 15px;background: rgba(76,132,255,1);width: ' + percentage + '">'
                    +'</div>'
                    +'<div style="position: absolute;margin-top:1px;float: left;height: 3px;">'+percentage+'</div>'

                    + '</div>';
                $(this).parent().html(str);
                // $("#noitemnum").html("");
                var str1 = "";
                var percentage1 = (100-(parseFloat(votedate.yesNumber.toString()).toFixed(2)/parseFloat(votedate.joinedNumber.toString()).toFixed(2))*100).toFixed(2) + '%';
                // document.getElementById("#yesitem").innerHTML = ((date.yesNumber/date.joindeNumber)*100).toFixed(2) + '%';
                str1 = '<div align="left" style="width:100%;box-sizing:border-box;height: 34px;line-height: 34px;margin-top: 5px;">'
                    // + '<div style="float: left;height: 34px;width:70px;line-height: 34px;">'
                    // +'</div>'
                    +'<div style="position: relative;margin-top:10px;float: left;height: 15px;background: rgba(76,132,255,1);width: ' + percentage1 + '">'
                    +'</div>'
                    +'<div style="position: absolute;margin-top:1px;float: left;height: 3px;">'+percentage1+'</div>'

                    + '</div>';
                $(nextdom).html(str1);
        });
        $("a.noitem").click(function (){
            var voteid = $(this).next().text()
            var votedate = null;
            $.ajaxSettings.async = false;
            $.getJSON("JoinVoteItem?item=0&id="+voteid,function (date){
                votedate = date;
            })
            $.ajaxSettings.async = true;
            console.log(parseFloat(votedate.yesNumber.toString()).toFixed(3))
            // $(this).parent().html("");
            var prevdom = $(this).parent().prev();
            var str = "";
            var percentage = ((parseFloat(votedate.yesNumber.toString()).toFixed(2)/parseFloat(votedate.joinedNumber.toString()).toFixed(2))*100).toFixed(2) + '%';
            // document.getElementById("#yesitem").innerHTML = ((date.yesNumber/date.joindeNumber)*100).toFixed(2) + '%';
            str = '<div align="left" style="width:100%;box-sizing:border-box;height: 34px;line-height: 34px;margin-top: 5px;">'
                // + '<div style="float: left;height: 34px;width:70px;line-height: 34px;">'
                // +'</div>'
                +'<div style="position: relative;margin-top:10px;float: left;height: 15px;background: rgba(76,132,255,1);width: ' + percentage + '">'
                +'</div>'
                +'<div style="position: absolute;margin-top:1px;float: left;height: 3px;">'+percentage+'</div>'

                + '</div>';
            $(prevdom).html(str);
            // $("#noitemnum").html("");
            var str1 = "";
            var percentage1 = (100-(parseFloat(votedate.yesNumber.toString()).toFixed(2)/parseFloat(votedate.joinedNumber.toString()).toFixed(2))*100).toFixed(2) + '%';
            // document.getElementById("#yesitem").innerHTML = ((date.yesNumber/date.joindeNumber)*100).toFixed(2) + '%';
            str1 = '<div align="left" style="width:100%;box-sizing:border-box;height: 34px;line-height: 34px;margin-top: 5px;">'
                // + '<div style="float: left;height: 34px;width:70px;line-height: 34px;">'
                // +'</div>'
                +'<div style="position: relative;margin-top:10px;float: left;height: 15px;background: rgba(76,132,255,1);width: ' + percentage1 + '">'
                +'</div>'
                +'<div style="position: absolute;margin-top:1px;float: left;height: 3px;">'+percentage1+'</div>'

                + '</div>';
            $(this).parent().html(str1);
        });
    });
</script>
</html>