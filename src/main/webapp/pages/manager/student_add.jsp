<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>导入学生main</title>
    <link rel="icon" href="${pageContext.request.contextPath}/static/images/user_images/pande.png">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/css.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css"/>
    <style>
        body {
            overflow-x: hidden;
            background: #f2f0f5;
            padding: 15px 0px 10px 5px;
        }

        #searchmain {
            font-size: 12px;
        }

        #search {
            font-size: 12px;
            background: #548fc9;
            margin: 10px 10px 0 0;
            display: inline;
            width: 100%;
            color: #FFF
        }

        #search form span {
            height: 40px;
            line-height: 40px;
            padding: 0 0px 0 10px;
            float: left;
        }

        #search form input.text-word {
            height: 24px;
            line-height: 24px;
            width: 180px;
            margin: 8px 0 6px 0;
            padding: 0 0px 0 10px;
            float: left;
            border: 1px solid #FFF;
        }

        #search form input.text-but {
            height: 24px;
            line-height: 24px;
            width: 55px;
            background: url(${pageContext.request.contextPath}/static/images/admin_image/main/list_input.jpg) no-repeat left top;
            border: none;
            cursor: pointer;
            font-family: "Microsoft YaHei", "Tahoma", "Arial", '宋体';
            color: #666;
            float: left;
            margin: 8px 0 0 6px;
            display: inline;
        }

        #search a.add {
            background: url(${pageContext.request.contextPath}/static/images/admin_image/main/add.jpg) no-repeat 0px 6px;
            padding: 0 10px 0 26px;
            height: 40px;
            line-height: 40px;
            font-size: 14px;
            font-weight: bold;
            color: #FFF
        }

        #search a:hover.add {
            text-decoration: underline;
            color: #d2e9ff;
        }

        #main-tab {
            border: 1px solid #eaeaea;
            background: #FFF;
            font-size: 12px;
        }

        #main-tab th {
            font-size: 12px;
            background: url(${pageContext.request.contextPath}/static/images/admin_image/main/list_bg.jpg) repeat-x;
            height: 32px;
            line-height: 32px;
        }

        #main-tab td {
            font-size: 12px;
            line-height: 40px;
        }

        #main-tab td a {
            font-size: 12px;
            color: #548fc9;
        }

        #main-tab td a:hover {
            color: #565656;
            text-decoration: underline;
        }

        #main-tab1 {
            border: 1px solid #eaeaea;
            background: #FFF;
            font-size: 12px;
        }

        #main-tab1 th {
            font-size: 12px;
            background: url(${pageContext.request.contextPath}/static/images/admin_image/main/list_bg.jpg) repeat-x;
            height: 32px;
            line-height: 32px;
        }

        #main-tab1 td {
            font-size: 12px;
            line-height: 40px;
        }

        #main-tab1 td a {
            font-size: 12px;
            color: #548fc9;
        }

        #main-tab1 td a:hover {
            color: #565656;
            text-decoration: underline;
        }

        .bordertop {
            border-top: 1px solid #ebebeb
        }

        .borderright {
            border-right: 1px solid #ebebeb
        }

        .borderbottom {
            border-bottom: 1px solid #ebebeb
        }

        .borderleft {
            border-left: 1px solid #ebebeb
        }

        .gray {
            color: #dbdbdb;
        }

        td.fenye {
            padding: 10px 0 0 0;
            text-align: right;
        }

        .bggray {
            background: #f9f9f9;
            font-size: 14px;
            font-weight: bold;
            padding: 10px 10px 10px 0;
            width: 120px;
        }

        .main-for {
            padding: 10px;
        }

        .main-for input.text-word {
            width: 310px;
            height: 36px;
            line-height: 36px;
            border: #ebebeb 1px solid;
            background: #FFF;
            font-family: "Microsoft YaHei", "Tahoma", "Arial", '宋体';
            padding: 0 10px;
        }

        .main-for select {
            width: 310px;
            height: 36px;
            line-height: 36px;
            border: #ebebeb 1px solid;
            background: #FFF;
            font-family: "Microsoft YaHei", "Tahoma", "Arial", '宋体';
            color: #666;
        }

        .main-for input.text-but {
            width: 100px;
            height: 40px;
            line-height: 30px;
            border: 1px solid #cdcdcd;
            background: #e6e6e6;
            font-family: "Microsoft YaHei", "Tahoma", "Arial", '宋体';
            color: #969696;
            float: left;
            margin: 0 10px 0 0;
            display: inline;
            cursor: pointer;
            font-size: 14px;
            font-weight: bold;
        }

        #addinfo a {
            font-size: 14px;
            font-weight: bold;
            background: url(${pageContext.request.contextPath}/static/images/admin_image/main/addinfoblack.jpg) no-repeat 0 1px;
            padding: 0px 0 0px 20px;
            line-height: 45px;
        }

        #addinfo a:hover {
            background: url(${pageContext.request.contextPath}/static/images/admin_image/main/addinfoblue.jpg) no-repeat 0 1px;
        }
    </style>

</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
    <tr>
        <td width="99%" align="left" valign="top">您的位置：用户管理&nbsp;&nbsp;>&nbsp;&nbsp;导入本校学生</td>
    </tr>

    <tr>
        <td align="left" valign="top" id="addinfo">
            <c:if test="${requestScope.msg =='success' }"><font -size="4px" ; color=red>&nbsp;&nbsp;&nbsp;<b>头像上传成功且</b></font></c:if>
            <c:if test="${requestScope.msg =='fail' }"><font -size="4px" ;
                                                             color=red>&nbsp;&nbsp;&nbsp;<b>头像上传失败且</b></font></c:if>
            <c:if test="${requestScope.clubmsg =='success' }"><font -size="4px" ; color=blue>&nbsp;&nbsp;&nbsp;<b>社团创建成功，请等待审核</b></font></c:if>
            <c:if test="${requestScope.clubmsg =='fail' }"><font -size="4px" ; color=red>&nbsp;&nbsp;&nbsp;<b>社团添加失败，请重新尝试</b></font></c:if>
            <span style="color: #8A0B00" class="errorMsg">
              <strong id="errormsg"></strong>
            </span>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">
            <form method="post" action="StudentAdd" enctype="multipart/form-data" name="form_info">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'"
                        onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="center" valign="middle" class="borderright borderbottom main-for">选择excel文档：</td>
                        <td align="center" valign="middle" class="borderright borderbottom main-for">
                            <input name="student" type="file">
                        </td>
                        <td align="center">
                            <a style="color: #8A0B00" id="addstudent">导入文档数据</a>
                        </td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
    <table width="100%" border="1" cellspacing="0" cellpadding="0" id="main-tab1">
        <thead>
        <tr>
            <th align="center" valign="middle" class="borderright tda">学号</th>
            <th align="center" valign="middle" class="borderright tda">年级</th>
            <th style="color: #8A0B00" align="center" valign="middle"><a id="intosql">上传入系统</a></th>
        </tr>
        </thead>
        <tbody id="studentdate">
        </tbody>
    </table>
</table>
</body>
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script>
    $(function () {
        let studentdate = []
        $("#addstudent").click(function () {
            var form = document.forms.namedItem("form_info");
            var formData = new FormData(form);
            $.ajax({
                type: 'post',
                data: formData,
                url: '${pageContext.request.contextPath}/StudentAdd',
                cache: false,
                contentType: false,
                processData: false,
                async: false,
                dataType: 'json',
                success: function (data) {
                    let i = 0;
                    for (i = 0; i < data.length; i++) {
                        const str = '<tr><td align="center" valign="middle" class="borderright tda">' + data[i].studentNameid + '</td>' +
                            '<td align="center" valign="middle" class="borderright tda">' + data[i].grade + '</td></tr>';
                        $("#studentdate").append(str);
                    }
                    studentdate = JSON.stringify(data)
                }
            })
        });

        $("#intosql").click(function () {
            $.ajax({
                type: 'post',
                data: studentdate,
                url: '${pageContext.request.contextPath}/StudentIntoSql',
                cache: false,
                contentType: 'applicaiton/json',
                processData: false,
                async: false,
                dataType: 'json',
                success: function (data) {
                    $("#errormsg").text(data);
                },
                error: function(response){
                    var msg = JSON.stringify(response.responseText);
                    $("#errormsg").text(msg);

                }
            })
        })
    })
</script>
</html>