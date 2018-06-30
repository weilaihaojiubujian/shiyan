<%@ page language="java" import="java.util.*,java.net.*" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<%
    request.setCharacterEncoding("utf-8");
%>
<head>
    <meta charset="utf-8">
    <title>系统注册</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/register.js"></script>
    <link href="css/register.css" rel="stylesheet" type="text/css">
    <script>
        var a=<%=request.getParameter("a")%>;
        if(a==1){
            alert("恭喜你,注册成功!");
            window.location.href=("denlu.jsp");
        }else if(a==0)  {
            alert("用户名重复,请重新输入!");
        }
    </script>
</head>



<body>
<%@page import="java.sql.*" %>


<div id="registerDiv">
    <img id="register_img" src="img/register.png">
    <div id="registerFormDiv">

         <form action="servlet/zhuce" method="post">
            <label for="username">&nbsp;&nbsp;用户名:</label>
            <input class="text" type="text" name="username" id="username" value="">
            <span id="uspan"></span>
            <br>
            <br>
            <label for="password">&nbsp;&nbsp;密&nbsp;&nbsp;码:</label>
            <input class="text" type="password" name="password" id="password" value="">
            <span id="psdspan"></span>
            <br>
            <br>

            <label for="password">确认密码:</label>
            <input class="text" type="password" name="password" id="confirm" value="">
            <span id="confirmSpan"></span>
            <br>
            <br>

            <label for="address">&nbsp;&nbsp;地&nbsp;&nbsp;址:</label>
            <input class="text" type="text" name="address" id="address" value="">
            <span id="addspan"></span>
            <br>
            <br>

            <label for="bankaccount" id="bank_label">银行账户:</label>
            <input class="text" type="text" name="bankaccount" id="bankaccount" value="">
            <span id="bkspan"></span>
            <br>
            <br>

            <label for="card">&nbsp;&nbsp;身份证:</label>
            <input class="text" type="text" name="card" id="card" value="">
            <span id="cspan"></span>
            <br>
            <br>

            <input type="submit" id="button-submit" value="确认信息,注册" name="submit" class="button">
            <%--<br>--%>
            <%--<br>--%>
            <input type="button" id="backToLogin" value="已有账号，返回登录！" class="button" onclick="backLogin()">
        </form>
    </div>
</div>
</body>
</html>