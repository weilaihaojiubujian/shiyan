<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
           <%@page import="bean.user"%>
 <%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除用户</title>
<script src="jquery-3.3.1.min.js"></script>
    <script>  
    function getMoreContents() {
    	  //s首先获取用户的输入
    	  var $content = document.getElementById("keyword");
    	  var $value=document.getElementById("keyword").value;
    	  if ($value==""){
    	      clearContent();
    	      return;
    	  }
    	  

      	$.ajax({
      		url:"servlet/searchalluser",
              data:{keyword:$value},
              type:"POST",
              dataType:"TEXT",
              success:function(data){
            	  var json=eval("("+data+")");
            	 
            	  clearContent();
            	  var size = json.length;
            	  //设置内容
            	  for(var i=0;i<size;i++){
            	      var nextNode = json[i];
            	      var tr = document.createElement("tr");
            	      var td = document.createElement("td");
            	      td.setAttribute("border","0");
            	      td.setAttribute("bgcolor","#FFFAFA");
            	      td.onmouseover=function () {
            	          this.className = 'mouseOver';
            	      };
            	      td.onmouseout=function () {
            	          this.className = 'mouseOut';
            	      };
            	      td.onmousedown= function(){
            	    	  var content = document.getElementById("keyword");
            	    	  var _html = this.innerHTML;
            	    	  content.value = _html;
            	    	  }
            	      var text = document.createTextNode(nextNode);
            	      td.appendChild(text);
            	      tr.appendChild(td);
            	      document.getElementById("content_table_body").appendChild(tr);
              }
             
              }
      	
      	
      	
      	});
    	  
    }
      	
    
    function clearContent() {
    	  var contentTableBody = document.getElementById("content_table_body");
    	  var size = contentTableBody.childNodes.length;
    	  for(var i=size-1;i>=0;i--){
    	      contentTableBody.removeChild(contentTableBody.childNodes[i]);
    	  }

    	}
    	//输入框失去焦点 清空
    	function keywordBlur() {
    	  clearContent();
    	}
    </script>
</head>
<body>
<%
int pageSize=4;
int pageCount;
int showPage;

List<user> q=null;
 q=(List<user>)session.getAttribute("listalluser");
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
<form action="servlet/searchuser" method="post">
<input type="text" size="50" id="keyword" name="keyword" onkeyup="getMoreContents()"
     onblur="keywordBlur()" onfocus="getMoreContents()"/>
     <input type="submit"  value="查找"  name="submit" width="50px"/> 
     <%--内容展示区域--%>
     <div id="popdiv">
       <table id="content_table" bgcolor="#FFFAFA" border="0" cellspacing="0" cellpadding="0">
         <tbody id="content_table_body">
         <%--动态查询出来的数据,显示在此--%>

         </tbody>
       </table>

     </div>
</form><br><br>
用户总数为:<%=size %><br><br><br>
<form action="servlet/deleteuser" method="post">
<%  for(int i = (showPage-1)*pageSize; i <showPage*pageSize && i<size ; i++)
 {
	user u = (user) q.get(i);
	 int uid=u.getUid();
	 String username =u.getUsername();
	 String address = u.getAddress();
	 String bankaccount = u.getBankaccount();
	 String card = u.getCard();
	 %>	

<input type="radio" value="<%= uid%>" name="list"/>	  
 <% 
out.println("序号:"+uid+"<br>");
out.println("用户名:"+username+"<br>");
out.println("用户身份证号:"+card+"<br>");
out.println("用户地址:"+address+"<br>");
out.println("用户银行账号:"+bankaccount+"<br><br><br>");

} %>

<input type="submit"  value="删除用户"  name="submit"/> 
</form>


<br>
 第<%=showPage %>页（共<%=pageCount %>页）
 <br>
 <a href="deleteuser.jsp?showPage=1">首页</a>
 <a href="deleteuser.jsp?showPage=<%=showPage-1%>">上一页</a>
<% //根据pageCount的值显示每一页的数字并附加上相应的超链接
  for(int i=1;i<=pageCount;i++){
 %>
   <a href="deleteuser.jsp?showPage=<%=i%>"><%=i%></a>
<% }
 %> 
 <a href="deleteuser.jsp?showPage=<%=showPage+1%>">下一页</a>
 <a href="deleteuser.jsp?showPage=<%=pageCount%>">末页</a>
 <form action="" method="get">
  跳转到第<input type="text" name="showPage" size="4">页
  <input type="submit" name="submit" value="跳转">
 </form> 
 </body>
</html>