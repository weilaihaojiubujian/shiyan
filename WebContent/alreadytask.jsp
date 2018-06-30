<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="bean.task"%>
 <%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已接受的任务</title>
  <link type="text/css" rel="stylesheet" href="css/table.css">
    <link type="text/css" rel="stylesheet" href="css/alreadyTask.css">
     
</head>
<body>
已接受的任务:
<%

task t=(task)session.getAttribute("alreadytask");

	int tid=t.getTid();
	String taskname =t.getTaskname();
	 String introduce = t.getIntroduce();
	 double price=t.getPrice();
	 int accept=t.getAccept();
	 java.util.Date date=t.getDate();
	 double progress=t.getProgress();


%>
<table>
    <tr>
        <th>任务序号</th>
        <th>任务名</th>
        <th>任务介绍</th>
        <th>金额</th>
        <th>发布日期</th>
        <th>任务完成程度</th>
        <th>签到</th>
    </tr>
    <tr>
        <td>
            <%=tid%>
        </td>
        <td>
            <%=taskname%>
        </td>
        <td>
            <%=introduce%>
        </td>
        <td>
            <%=price%>
        </td>
        <td>
            <%=date%>
        </td>
        <td>
            <%=progress%>
        </td>
        <td>
            <a href="signin.jsp">签到</a>
        </td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
</table>
</body>
</html>