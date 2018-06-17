<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@page import="bean.user"%>
 <%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线用户数和用户信息</title>
<script src="jquery-3.3.1.min.js"></script>
    <script>  
   
    var k;
  
    function call($value) {
  	

    	if(document.getElementById("92").value==null)
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
      		  url:"servlet/checkuser",
              data:{key:$value},
              type:"POST",
              dataType:"TEXT",
              success:function(data){
            	  var json=eval("("+data+")");
            
            	 
            	  var size = json.length;
            	 
            	  k=json[0];
            	  for(i=1;i<=90;i++){
            		  $("#"+""+i+"").hide();
            	  }
            	  for(var i=1;i<size-1;i=i+6){
            	      var nextNode = json[i];
            	      var lastNode=json[i+1];
            	      var thirdNode=json[i+2];
            	      var fourNode=json[i+3];
            	      var fifthNode=json[i+4];
            	      var sixNode=json[i+5];
            	      var x=i;
            	      var y=i+1;
            	      var z=9+(i-1)/2;
            	      var n=i+2;
            	      var m=i+3;
            	      var c=i+4;
            	      var v=i+5;
            	      document.getElementById("0").innerHTML=$value;
            	      document.getElementById(""+x+"").innerHTML=($value-1)*15+(i+1)/2;
            	      document.getElementById(""+y+"").innerHTML=lastNode;           	   
            	      document.getElementById(""+n+"").innerHTML=thirdNode;
            	      document.getElementById(""+m+"").innerHTML=fourNode;
            	      document.getElementById(""+c+"").innerHTML=fifthNode;
            	      document.getElementById(""+v+"").innerHTML=sixNode;
            	      $("#"+""+v+"").show();
            	      $("#"+""+x+"").show();
            	      $("#"+""+y+"").show();
            	      $("#"+""+n+"").show();
            	      $("#"+""+m+"").show();
            	      $("#"+""+c+"").show();
            	     
              }
             document.getElementById("93").innerHTML=json[i];
             if(json[i]==0){
            	 document.getElementById("0").innerHTML=0;
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
</head>
<body>

用户总数为:${count }
用户工作总数为:<label id="93" value=""></label><br><br>

<body onload="call(1)">



<br><br>

<%for(int i=1;i<90;i=i+6) {%>
<a id="<%=i%>"></a>&emsp;&emsp;<a href=""  id="<%=i+1%>"></a>&emsp;&emsp;<a id="<%=i+2%>"></a>&emsp;&emsp;<a id="<%=i+3%>"></a>&emsp;&emsp;<a id="<%=i+4%>"></a>&emsp;&emsp;<a id="<%=i+5%>"></a><br>

<%} %>




 <br>
<br>
第<a id="0"></a>页<br>
<button type="button" onclick="call(1)">首页</button>
<button type="button" onclick="call(getnum1())" >上一页</button>
<button type="button" onclick="call(getnum())" >下一页</button>
<button type="button" onclick="p()" id="91" value="">尾页</button><br>
<label id="92" value=""></label>
</body>
</html>