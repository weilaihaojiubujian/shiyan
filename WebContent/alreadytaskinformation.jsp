<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="bean.task"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已完成的任务的具体信息</title>
</head>
<body>


<% 
      task t=(task)session.getAttribute("task");
	  int tid=t.getTid();
	  String taskname =t.getTaskname();
	  String introduce = t.getIntroduce();
	  double price=t.getPrice();

	  java.util.Date date=t.getDate();
	  
out.println("序号:"+tid+"<br>");
out.println("任务名:"+taskname+"<br>");
out.println("任务介绍:"+introduce+"<br>");
out.println("可获金额:"+price+"<br>");
out.println("发布日期:"+date+"<br>");

%>



</body>
</html>