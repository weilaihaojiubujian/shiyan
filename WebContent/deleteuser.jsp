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
   
    var k;
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
    function call($value) {
  	

    	if(document.getElementById("107").value==null)
    	{
    		
    		init($value);
    	}
    	else{
    		init1($value);
    	}
  	}
    
   
    function init($value) {
    	clear();
    	
      	$.ajax({
      		  url:"servlet/checkalluser",
              data:{key:$value},
              type:"POST",
              dataType:"TEXT",
              success:function(data){
            	  var json=eval("("+data+")");
            
            	 
            	  var size = json.length;
            	 
            	  k=json[0];
            	  for(i=1;i<=105;i++){
            		  $("#"+""+i+"").hide();
            	  }
            	  for(var i=1;i<size;i=i+6){
            		  var nextNode = json[i];
            	      var lastNode=json[i+1];
            	      var thirdNode=json[i+2];
            	      var fourNode=json[i+3];
            	      var fifthNode=json[i+4];
            	      var sixNode=json[i+5];
            	      var x=i;
            	      var y=i+1;
            	      var z=91+(i-1)/6
            	      var n=i+2;
            	      var m=i+3;
            	      var c=i+4;
            	      var v=i+5;
            	      document.getElementById("0").innerHTML=$value;
            	      document.getElementById(""+x+"").innerHTML=($value-1)*15+(i-1)/6+1;
            	      document.getElementById(""+y+"").innerHTML=lastNode;
            	     
            	      document.getElementById(""+z+"").value=nextNode;
            	      document.getElementById(""+n+"").innerHTML=thirdNode;
            	      document.getElementById(""+m+"").innerHTML=fourNode;
            	      document.getElementById(""+c+"").innerHTML=fifthNode;
            	      document.getElementById(""+v+"").innerHTML=sixNode;
            	      $("#"+""+z+"").show();

            	      $("#"+""+v+"").show();
            	      $("#"+""+x+"").show();
            	      $("#"+""+y+"").show();
            	      $("#"+""+n+"").show();
            	      $("#"+""+m+"").show();
            	      $("#"+""+c+"").show();
            	     
              }
             
              }
      	
      	
      	
      	});
    	
    }
    function init1($value) {
    	clear();
    	document.getElementById("107").value=$value;
    	var $valu=document.getElementById("keyword").value;
      	$.ajax({
      		  url:"servlet/searchuser",
              data:{key:$value,keyvalue:$valu},
              type:"POST",
              dataType:"TEXT",
              success:function(data){
            	  var json=eval("("+data+")");
          
            	 
            	  var size = json.length;
            	 
            	  k=json[0];
            	  for(i=1;i<=105;i++){
            		  $("#"+""+i+"").hide();
            	  }
            	  for(var i=1;i<size;i=i+6){
            		  var nextNode = json[i];
            	      var lastNode=json[i+1];
            	      var thirdNode=json[i+2];
            	      var fourNode=json[i+3];
            	      var fifthNode=json[i+4];
            	      var sixNode=json[i+5];
            	      var x=i;
            	      var y=i+1;
            	      var z=91+(i-1)/6;
            	      var n=i+2;
            	      var m=i+3;
            	      var c=i+4;
            	      var v=i+5;
            	      document.getElementById("0").innerHTML=$value;
            	      document.getElementById(""+x+"").innerHTML=($value-1)*15+(i-1)/6+1;
            	      document.getElementById(""+y+"").innerHTML=lastNode;
            	      
            	      document.getElementById(""+z+"").value=nextNode;
            	      document.getElementById(""+n+"").innerHTML=thirdNode;
            	      document.getElementById(""+m+"").innerHTML=fourNode;
            	      document.getElementById(""+c+"").innerHTML=fifthNode;
            	      document.getElementById(""+v+"").innerHTML=sixNode;
            	      $("#"+""+z+"").show();

            	      $("#"+""+v+"").show();
            	      $("#"+""+x+"").show();
            	      $("#"+""+y+"").show();
            	      $("#"+""+n+"").show();
            	      $("#"+""+m+"").show();
            	      $("#"+""+c+"").show();
            	     
              }
             
              }
      	
      	
      	
      	});
    	
    }
    function getnum(){
    	var x=document.getElementById("0").innerHTML;
    	var j=1;
    	if(x==k){
    		alert("已经是最后一页了");
    		var y=Number(x);
    		return y;
    	}
    	else{
    		var y=Number(j)+Number(x);
        
        	return y;
    	}
    	
    	
    	
    }
    function getnum1(){
    	var x=document.getElementById("0").innerHTML;
    	var j=1;
    	if(x==1){
    		alert("已经第一页了");
    		var y=Number(x);
    		return y;
    	}
    	else{
    		var y=Number(x)-Number(j);
        	
        	return y;
    	}
    	
    	
    	
    }
    function clearContent() {
    	  var contentTableBody = document.getElementById("content_table_body");
    	  var size = contentTableBody.childNodes.length;
    	  for(var i=size-1;i>=0;i--){
    	      contentTableBody.removeChild(contentTableBody.childNodes[i]);
    	  }

    	}
    function clear() {

  	  for(var i=1-1;i<=8;i++){
  		document.getElementById(""+i+"").innerHTML="";
  	  }

  	}
    	//输入框失去焦点 清空
    	function keywordBlur() {
    	  clearContent();
    	}
    	function p(){
    		call(k);
    	}
    </script>
     <script>
        var a=<%=request.getParameter("b")%>;
        if(a==1){
            alert("恭喜你,删除用户成功!");
            parent.location.href=("administrator.jsp");
        }
    </script>
    <link rel="stylesheet" type="text/css" href="css/table.css">
    <link rel="stylesheet" type="text/css" href="css/button.css">
    <link rel="stylesheet" type="text/css" href="css/deleteUser.css">
</head>
<body onload="call(1)">


<input type="text" size="50" id="keyword" name="keyword" onkeyup="getMoreContents()"
     onblur="keywordBlur()" onfocus="getMoreContents()"/>
     <input type="submit"  value="查找"  name="submit" width="50px" onclick="init1(1)"/> 
     <%--内容展示区域--%>
     <div id="popdiv">
       <table id="content_table" bgcolor="#FFFAFA" border="0" cellspacing="0" cellpadding="0">
         <tbody id="content_table_body">
         <%--动态查询出来的数据,显示在此--%>

         </tbody>
       </table>

     </div>
<br><br>
<form action="servlet/deleteuser" method="post">
    <table>
        <tr>
            <th>用户序号</th>
            <th>用户名</th>
            <th>地址</th>
            <th>银行账号</th>
            <th>身份证</th>
            <th>余额</th>
            <th></th>
        </tr>
        <%
            for (int i = 1; i < 90; i = i + 6) {
        %>

        <tr>
            <td><a id="<%=i%>"></a></td>
            <td><a href="" id="<%=i+1%>"></a></td>
            <td><a id="<%=i+2%>"></a></td>
            <td><a id="<%=i+3%>"></a></td>
            <td><a id="<%=i+4%>"></a></td>
            <td><a id="<%=i+5%>"></a></td>
            <td><input type="checkbox" value="" name="list" id="<%=91+(i-1)/6 %>"/></td>
        </tr>

        <%
            }
        %>
    </table>
    <div>
    <input type="submit" id="deleteButton" value="删除用户" name="submit" onclick="return confirmOper()"/>
    </div>
</form>


<br>
<br>
<div>
    第<a id="0"></a>页<br>
    <button type="button" class="button" onclick="call(1)">首页</button>
    <button type="button" class="button" onclick="call(getnum1())">上一页</button>
    <button type="button" class="button" onclick="call(getnum())">下一页</button>
    <button type="button" class="button" onclick="p()" id="106" value="">尾页</button>
    <br>
    <label id="107" value=""></label>
</div>
 </body>
</html>