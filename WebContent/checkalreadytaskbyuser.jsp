<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="bean.task"%>
 <%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看已被接受的任务</title>
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
      		url:"servlet/searchalready",
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
      		  url:"servlet/checkalreadytaskbyuser",
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
            	  for(var i=1;i<size-1;i=i+7){
            	      var nextNode = json[i];
            	      var lastNode=json[i+1];
            	      var thirdNode=json[i+2];
            	      var fourNode=json[i+3];
            	      var fifthNode=json[i+4];
            	      var sixNode=json[i+5];
            	      var sevenNode=json[i+6];
            	      var x=i;
            	      var y=i+1;
            	     
            	      var n=i+2;
            	      var m=i+3;
            	      var c=i+4;
            	      var v=i+5;
            	      var b=i+6;
            	      document.getElementById("0").innerHTML=$value;
            	      document.getElementById(""+x+"").innerHTML=($value-1)*15+(i-1)/7+1;
            	      document.getElementById(""+y+"").innerHTML=lastNode;
            	      document.getElementById(""+y+"").href="servlet/checkalreadytaskinformation?list="+nextNode+"";
            	      document.getElementById(""+n+"").innerHTML=thirdNode;
            	      document.getElementById(""+m+"").innerHTML=fourNode;
            	      document.getElementById(""+c+"").innerHTML=fifthNode;
            	    
            	      document.getElementById(""+c+"").href="servlet/checkuserinformation?lis="+fifthNode+"";
            	      document.getElementById(""+v+"").innerHTML=sixNode;
            	      document.getElementById(""+b+"").innerHTML=sevenNode;
            	      document.getElementById(""+b+"").href="servlet/checkuserinformation?lis="+sevenNode+"";
            	      $("#"+""+v+"").show();
            	      $("#"+""+x+"").show();
            	      $("#"+""+y+"").show();
            	      $("#"+""+n+"").show();
            	      $("#"+""+m+"").show();
            	      $("#"+""+c+"").show();
            	      $("#"+""+b+"").show();
            	  }
             
              }
      	
      	
      	
      	});
    	
    }
    function init1($value) {
    	clear();
    	document.getElementById("107").value=$value;
    	var $valu=document.getElementById("keyword").value;
      	$.ajax({
      		  url:"servlet/searchalreadytask",
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
            	  for(var i=1;i<size-1;i=i+7){
            	      var nextNode = json[i];
            	      var lastNode=json[i+1];
            	      var thirdNode=json[i+2];
            	      var fourNode=json[i+3];
            	      var fifthNode=json[i+4];
            	      var sixNode=json[i+5];
            	      var sevenNode=json[i+6];
            	      var x=i;
            	      var y=i+1;
            	    
            	      var n=i+2;
            	      var m=i+3;
            	      var c=i+4;
            	      var v=i+5;
            	      var b=i+6;
            	      document.getElementById("0").innerHTML=$value;
            	      document.getElementById(""+x+"").innerHTML=($value-1)*15+(i-1)/7+1;
            	      document.getElementById(""+y+"").innerHTML=lastNode;
            	      document.getElementById(""+y+"").href="servlet/checkalreadytaskinformation?list="+nextNode+"";
            	      document.getElementById(""+n+"").innerHTML=thirdNode;
            	      document.getElementById(""+m+"").innerHTML=fourNode;
            	      document.getElementById(""+c+"").innerHTML=fifthNode;
            	    
            	      document.getElementById(""+c+"").href="servlet/checkuserinformation?lis="+fifthNode+"";
            	      document.getElementById(""+v+"").innerHTML=sixNode;
            	      document.getElementById(""+b+"").innerHTML=sevenNode;
            	      document.getElementById(""+b+"").href="servlet/checkuserinformation?lis="+sevenNode+"";
            	      $("#"+""+v+"").show();
            	      $("#"+""+x+"").show();
            	      $("#"+""+y+"").show();
            	      $("#"+""+n+"").show();
            	      $("#"+""+m+"").show();
            	      $("#"+""+c+"").show();
            	      $("#"+""+b+"").show();
            	  
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
    <link href="css/table.css" type="text/css" rel="stylesheet">
    <link href="css/button.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/checkAlreadyTaskByUser.css">
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


<table>
    <tr>
        <th>任务序号</th>
        <th>任务名</th>
        <th>价格</th>
        <th>发布日期</th>
        <th>发布人序号</th>
        <th>任务完成进度</th>
        <th>接受任务人的序号</th>
    </tr>
    <%
        for (int i = 1; i < 105; i = i + 7) {
    %>


    <tr>
        <td><a id="<%=i%>"></a></td>
        <td><a href="" id="<%=i+1%>"></a></td>
        <td><a id="<%=i+2%>"></a></td>
        <td><a id="<%=i+3%>"></a></td>
        <td><a id="<%=i+4%>"></a></td>
        <td><a id="<%=i+5%>"></a></td>
        <td><a id="<%=i+6%>"></a></td>
    </tr>

    <%
        }
    %>
</table>



<div>
    第<a id="0"></a>页<br>
    <button class="button" type="button" onclick="call(1)">首页</button>
    <button class="button" type="button" onclick="call(getnum1())">上一页</button>
    <button class="button" type="button" onclick="call(getnum())">下一页</button>
    <button class="button" type="button" onclick="p()" id="106" value="">尾页</button>
    <br>
    <label id="107" value=""></label>
</div>
</body>
</html>