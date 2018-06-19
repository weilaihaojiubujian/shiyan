<%@ page language="java" import="java.util.*,java.net.*" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>系统登陆</title>

    <script>
        var a = '<%=request.getParameter("b")%>'
        if (a == 1) {
            alert("登陆成功!" + a);
            window.location.href = ("user.jsp");
        }
        else if (a == 2) {
            alert("请重新登陆!");
        }
        else if (a == 3) {
            alert("管理员登陆成功!");
            window.location.href = ("administrator.jsp");
        }
        else if (a == 4) {
            alert("管理员请重新登陆!");
        }


    </script>
    <link rel="stylesheet" href="css/login.css" type="text/css">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/login.js"></script>
</head>
<body>

<img id="title_img"  src="img/title2.png">
<div >
    <img id="loginForm_img" src="img/loginForm.png">
    <form action="servlet/denlu" method="post" align="center">
        <label for="username">用户名:</label>
        <input class="text" type="text" name="username" id="username" value="" size="35">
        <span id="user_span"></span>
        <br>
        <br>
        <label for="password">密&nbsp;&nbsp;码:</label>
        <input class="text" type="password" name="password" id="password" value="" size="35">
        <span id="password_span"></span>
        <br>
        <br>
        <tr>
            <td colspan="2"><input type="checkbox" name="isUseCookie" checked="checked"/>十天内记住我的登录状态</td>
        </tr>
        <br>
        <input type="radio" name="user" checked="checked" value="用户">用户
        <input type="radio" name="user" value="管理员">管理员<br>
        <input id="button-submit" class="button" type="submit" value="登录" name="submit"/>
        <input id="bottem-reigster" class="button" type="button" value="注册"onclick="jumpToRegister()" ><%--暂时写成button，后续js记得注册跳转到zhuce.jsp--%>
    </form>
</div>
</body>
</html>