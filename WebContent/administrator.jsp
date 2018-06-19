<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员</title>
    <link rel="stylesheet" type="text/css" href="css/admin.css">
</head>
<body>
<div id="contanier">
    <div id="heading"></div>
    <div id="content">
        <div id="left_content">
            <ul>
                <li><i><a href="checkuser.jsp" target="content_frame">查看在线用户</a></i></li>
                <li><i><a href="deleteuser.jsp" target="content_frame">删除用户</a></i></li>
                <li><i><a href="checkalreadytaskbyuser.jsp" target="content_frame">查看已被人接受的任务</a></i></li>
                <li><i><a href="checktaskbyuser.jsp" target="content_frame">查看未接受的任务</a></i></li>
                <li><i><a href="checkcompletetaskbyuser.jsp" target="content_frame">查看已完成的任务</a></i></li>
                <li><i><a href="table.jsp" target="content_frame">表格</a></i></li>
                <li><i></i></li>
                <li><i></i></li>
                <li><i></i></li>
                <li><i></i></li>
                <li><i></i></li>
                <li><i></i></li>
                <li><i></i></li>
                <li><i></i></li>
                <li><i></i></li>
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