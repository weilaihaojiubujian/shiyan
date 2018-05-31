<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="bean.user"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>
<%
user u = new user();

%>
用户名:<%=session.getAttribute("username") %><br>
地址:<%=session.getAttribute("address") %><br>
银行账户:<%=session.getAttribute("bankaccount") %><br>
身份证号:<%=session.getAttribute("card") %><br>
拥有金额:<%=session.getAttribute("money") %><br>
</body>
</html>