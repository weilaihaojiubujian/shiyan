<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="bean.task"%>
 <%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已完成的任务</title>
</head>
<body>
<%
int pageSize=4;
int pageCount;
int showPage;
List<task> q=null;
 q=(List<task>)session.getAttribute("listcompletetask");
 int size=q.size();

 pageCount=(size%pageSize==0)?(size/pageSize):(size/pageSize+1);
 if(pageCount==0)
 {
	  pageCount++;
 }
 String integer=request.getParameter("showPage");
 if(integer==null){
  integer="1";
 }
 try{showPage=Integer.parseInt(integer);
 }catch(NumberFormatException e){
  showPage=1;
 }
 if(showPage<=1){
  showPage=1;
 }
 if(showPage>=pageCount){
  showPage=pageCount;
 }
%>

<%  for(int i = (showPage-1)*pageSize; i <showPage*pageSize && i<size ; i++)
 {
	task t = (task) q.get(i);
	 int tid=t.getTid();
	 String taskname =t.getTaskname();

	  
 
out.println("序号:"+(i+1)+"<br>");%>
<a href="servlet/checkcompletetaskinformation?list=<%=t%>" ><% out.println("任务名:"+taskname+"<br><br><br>");
%></a>
<% 
} %>



<br>
 第<%=showPage %>页（共<%=pageCount %>页）
 <br>
 <a href="completetask.jsp?showPage=1">首页</a>
 <a href="completetask.jsp?showPage=<%=showPage-1%>">上一页</a>
<% //根据pageCount的值显示每一页的数字并附加上相应的超链接
  for(int i=1;i<=pageCount;i++){
 %>
   <a href="completetask.jsp?showPage=<%=i%>"><%=i%></a>
<% }
 %> 
 <a href="completetask.jsp?showPage=<%=showPage+1%>">下一页</a>
 <a href="completetask.jsp?showPage=<%=pageCount%>">末页</a>
 <form action="" method="get">
  跳转到第<input type="text" name="showPage" size="4">页
  <input type="submit" name="submit" value="跳转">
 </form> 
</body>
</html>