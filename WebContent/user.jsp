<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户</title>
<script type="text/javascript" src="a.js"></script>
<link rel="stylesheet" href="a.css" type="text/css" />

</head>
<body>

<ul class="nav">
    <li><a class="on" href="user.jsp">首　　页</a></li>
   <li><a href="#">任务</a>
    	<ul class="subNav">
        	<li><a href="releasetask.jsp">发布任务</a></li>
             <li><a href="task.jsp">查看未接受任务</a></li>
             <li><a href="servlet/alreadytask">查看已接受的任务</a></li>
            <li><a href="completetask.jsp">查看已完成的任务</a></li>
             <li><a href="releasetaskbyuser.jsp">查看发布的任务</a></li>
        </ul>
    </li>

   <li><a href="servlet/userinformation">查看用户的信息</a></li>
    <li><a href="addmoney.jsp">充值</a></li>
   <li> <a href="logout.jsp">退出系统</a> </li>
</ul>

</body>
</html>