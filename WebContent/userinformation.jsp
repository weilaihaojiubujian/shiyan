<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="bean.user"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
    <link rel="stylesheet" type="text/css" href="css/userInformation.css">
    <%--<link rel="stylesheet" type="text/css" href="css/button.css">--%>
    <script src="js/userInformation.js"></script>
     <script>
        var a=<%=request.getParameter("b")%>;
        if(a==1){
            alert("恭喜你,提现成功!");
            parent.location.href=("user.jsp");
        }else if(a==0)  {
            alert("提现失败!");
        }
        else if(a==2){
            alert("恭喜你,充值成功!");
            parent.location.href=("user.jsp");
        }else if(a==3)  {
            alert("充值失败!");
        }
    </script>
</head>
<body>
<div id="bg">
    <div id="title">
        <h1>我的信息</h1>
    </div>
    <%
        user u = new user();
    %>
    <div id="content">
        <p id="p1"><i>用户名称:</i><%=session.getAttribute("username") %>
        </p>
        <p id="p2"><i>家庭地址</i>:<%=session.getAttribute("address") %>
        </p>
        <p id="p3"><i>银行账户</i>:<%=session.getAttribute("bankaccount") %>
        </p>
        <p id="p4"><i>身份证号</i>:<%=session.getAttribute("card") %>
        </p>
        <p id="p5"><i>拥有金额</i>:<%=session.getAttribute("money") %>
        </p>
        <form id="addForm" action="servlet/addmoney" method="post">
            <input type="text" value="" name="addmoney" id="addmoney" class="text">
            <input type="submit" value="确认充值金额" class="button" onclick="return confirmOpe()" name="submit">
        </form>
        <form id="reduceForme" action="servlet/reducemoney" method="post">
            <input type="text" class="text" value="" name="reducemoney" id="reducemoney" >
            <input type="submit" class="button" value="确认提现金额" name="submit" onclick="return confirmOpe2()">
        </form>
    </div>

</div>
</body>
</html>