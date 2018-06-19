<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户</title>
    <link href="css/admin.css" type="text/css" rel="stylesheet">
</head>
<body>
<div id="contanier">
    <div id="heading"></div>
    <div id="content">
        <div id="left_content">
            <ul class="nav">
                <li><a class="on" href="user.jsp">首　　页</a></li>
                <li><a href="releasetask.jsp" target="content_frame">发布任务</a></li>
                <li><a href="task.jsp" target="content_frame">查看未接受任务</a></li>
                <li><a href="servlet/alreadytask" target="content_frame">查看已接受的任务</a></li>
                <li><a href="completetask.jsp" target="content_frame">查看已完成的任务</a></li>
                <li><a href="releasetaskbyuser.jsp" target="content_frame">查看发布的任务</a></li>
                <li><a href="servlet/userinformation" target="content_frame">查看用户的信息</a></li>
                <li><a href="addmoney.jsp" target="content_frame">充值</a></li>
                <li><a href="logout.jsp" target="content_frame">退出系统</a></li>
                <li><a></a></li>
                <li><a></a></li>
                <li><a></a></li>
                <li><a></a></li>
                <li><a></a></li>
                <li><a></a></li>
                <li><a></a></li>
                <li><a></a></li>
                <li><a></a></li>
                <li><a></a></li>
            </ul>
        </div>
        <div id="right_content">
            <iframe name="content_frame"></iframe>
        </div>
    </div>
    <div id="footing"></div>
</div>
</body>
</html>