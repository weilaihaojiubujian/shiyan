<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
             <%@page import="bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同的具体信息</title>
</head>
<body>
<% 
agreement t =(agreement)session.getAttribute("agreement");
int aid=t.getAid();
String agreementname =t.getAgreementname();
String agreementintroduce =t.getAgreementintroduce();

out.println("序号:"+aid+"<br>");
out.println("任务名:"+agreementname+"<br>");
out.println("任务介绍:"+agreementintroduce+"<br>");


%>
</body>
</html>