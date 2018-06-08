<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>签订合同</title>
</head>
<body>
合同：<%
int aid=(int)session.getAttribute("aid");
String agreementname=(String)session.getAttribute("agreementname");
String agreementintroduce=(String)session.getAttribute("agreementintroduce");
out.print("合同序号:"+aid+"<br>");
out.print("合同名:"+agreementname+"<br>");
out.print("合同内容:"+agreementintroduce+"<br>");
%>
<a href="servlet/signagreement">签订合同</a>
<a href="task.jsp">返回</a>
</body>
</html>