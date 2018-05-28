<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="bean.task"%>
 <%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已接受的任务</title>

</head>
<body>
已接受的任务:
<%
List<task> q=null;
q=(List<task>)session.getAttribute("alreadytask");
for(task t:q){
	int tid=t.getTid();
	String taskname =t.getTaskname();
	 String introduce = t.getIntroduce();
	 double price=t.getPrice();
	 int accept=t.getAccept();
	 java.util.Date date=t.getDate();
	 double progress=t.getProgress();
	 out.println("序号:"+tid+"<br>");
	 out.println("任务名:"+taskname+"<br>");
	 out.println("任务介绍:"+introduce+"<br>");
	 out.println("可获金额:"+price+"<br>");
	 out.println("发布日期:"+date+"<br>");
	 if(accept==0){
	 	 out.println("任务状态:未接受<br>");
	 }
	 else{
	 	 out.println("任务状态:已接受<br>");
	 }
	 out.println("任务完成程度:"+progress+"<br>"); 	 
}

%>

<a href="signin.jsp">签到</a>
</body>
</html>