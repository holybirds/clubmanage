<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="${pageContext.request.contextPath}/static/images/user_images/pande.png">
    <title>社团管理</title>
</head>
<link href="${pageContext.request.contextPath}/static/css/regist.css" type="text/css" rel="stylesheet" />
<!-- js files -->
<%--<script src="${pageContext.request.contextPath}/static/js/regist.js"></script>--%>
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script>
    $(function () {

        $("#name").blur(function () {
            //1 获取用户名
            var username = this.value;
            $.getJSON("${pageContext.request.contextPath}/getName?username=" + username,function (data) {
                if (data) {
                    $("span.errorMsg").text("用户名已存在！");
                    document.getElementById('name').focus();

                } else {
                    $("span.errorMsg").text("用户名可用！");
                }
            });
        });
        $("#stuid").blur(function () {
            //1 获取学号
            var stuid = this.value;
            $.getJSON("${pageContext.request.contextPath}/CheckStuid?studentid=" + stuid,function (data) {
                if (data) {
                    $("span.errorMsg").text("学号已存在请注册！");
                } else {
                    $("span.errorMsg").text("学号不存在，请联系管理员");
                    document.getElementById('stuid').focus();
                }
            });
        });

        // 给验证码的图片，绑定单击事件
        $("#code_img").click(function () {
            // 在事件响应的function函数中有一个this对象。这个this对象，是当前正在响应事件的dom对象
            // src属性表示验证码img标签的 图片路径。它可读，可写
            // alert(this.src);
            this.src = "${basePath}kaptcha.jpg?d=" + new Date();
        });

        // 给注册绑定单击事件
        $("#submit").click(function () {
            // // 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
            // //1 获取用户名输入框里的内容
            // var usernameText = $("#name").val();
            // //2 创建正则表达式对象
            // var usernamePatt = /^\w{5,12}$/;
            // //3 使用test方法验证
            // if (!usernamePatt.test(usernameText)) {
            //     //4 提示用户结果
            //     $("span.errorMsg").text("用户名不合法！");
            //
            //     return false;
            // }
            // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
            //1 获取用户名输入框里的内容
            var passwordText = $("#password").val();
            //2 创建正则表达式对象
            var passwordPatt = /^\w{5,12}$/;
            //3 使用test方法验证
            if (!passwordPatt.test(passwordText)) {
                //4 提示用户结果
                $("span.errorMsg").text("密码不合法！");

                return false;
            }

            // 验证确认密码：和密码相同
            //1 获取确认密码内容
            var repwdText = $("#passwordAgain").val();
            //2 和密码相比较
            if (repwdText != passwordText) {
                //3 提示用户
                $("span.errorMsg").text("确认密码和密码不一致！");

                return false;
            }

            // 邮箱验证：xxxxx@xxx.com
            //1 获取邮箱里的内容
            var emailText = $("#email").val();
            //2 创建正则表达式对象
            var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
            //3 使用test方法验证是否合法
            if (!emailPatt.test(emailText)) {
                //4 提示用户
                $("span.errorMsg").text("邮箱格式不合法！");

                return false;
            }
            // 验证手机号：必须由数字组成，并且长度为11位
            //1 获取用户名输入框里的内容
            var phoneText = $("#tel").val();
            //2 创建正则表达式对象
            var phonePatt = /^1(3|4|5|7|8)\d{9}$/;
            //3 使用test方法验证
            if (!phonePatt.test(phoneText)) {
                //4 提示用户结果
                $("span.errorMsg").text("手机号格式不合法！");

                return false;
            }
            // 验证学号：必须由数字组成，并且长度为8位
            //1 获取用户名输入框里的内容
            var stuText = $("#stuid").val();
            //2 创建正则表达式对象
            var stuPatt = /^0\d{7}$/;
            //3 使用test方法验证
            if (!stuPatt.test(stuText)) {
                //4 提示用户结果
                $("span.errorMsg").text("学号格式不合法！");

                return false;
            }

            // // 验证码
            // var codeText = $("#code").val();
            //
            // //去掉验证码前后空格
            // // alert("去空格前：["+codeText+"]")
            // codeText = $.trim(codeText);
            // // alert("去空格后：["+codeText+"]")
            //
            // if (codeText == null || codeText == "") {
            //     //4 提示用户
            //     $("span.errorMsg").text("验证码不能为空！");
            //
            //     return false;
            // }

            // 去掉错误信息
            $("span.errorMsg").text("");

        });

    });
</script>
<!-- /js files -->
</head>
<body>
    <div class="wrap">
        <div class="container">
            <h1>注册</h1>
            <span class="errorMsg">
               <font -size="4px"; color=red>&nbsp;&nbsp;&nbsp;<b> ${ requestScope.msg }</b></font>
            </span>
            <form action="${pageContext.request.contextPath}/Regist" method="post" name="myfor">
                <input id="name"  name="userName" type="text" placeholder="用户名" onblur="checkName()"/>
                <input id="password" name="userPass" type="password" placeholder="密码" onblur="checkPassword()"/>
                <input id="passwordAgain" name="rePass" type="password" placeholder="确认密码" onblur="checkPassword();"/>
                <input id="stuid" name="studentId" type="text" placeholder="学号" onblur="checkStuid();"/>
                <input id="sex" name="sex" type="text" placeholder="性别" onblur="checkSex();"/>
                <input id="grade" name="grade" type="text" placeholder="年级" onblur="checkGrade();"/>
                <input id="college" name="college" type="text" placeholder="学院" onblur="checkCollege();"/>
                <input id="email" name="email" type="text" placeholder="邮箱" onblur="checkAddress"/>
                <input id="tel" name="phone" type="text" placeholder="电话" onblur="checkTel();"/>
                <input id="submit" type="submit" value="注 册" onclick="return registCheck(this)"/>
            	<input name="ope" type="hidden"  value="index"/>
            </form>
            <div id="regst">
                如果您已有账号，请点击这里<a href="login.jsp" class="link">登录</a>
            </div>
            
        </div>
        <ul>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>

</body>
</html>