<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提交任务进度</title>
<script type="text/javascript" >
function check(){
	 
	  var progress=document.getElementById('progress');
	  var value=document.getElementById('progress').value;
	 
	  if(value<0){
		  alert("任务进度不能为负数,请重新输入")
		  progress.focus();
		 
	  }
	  else if(value>100)
	 {
		  alert("任务进度最大为100,请重新输入")
		  progress.focus();
	 }
	  else if(value>=0 &&value<=100)
	{
		  
	}
	  else
	{
		  alert("只能为数字,不能有其他字符,请重新输入")
		  progress.focus();
	}
	  
	  
}
</script>
</head>
<body>
<form action="servlet/updateprogress" method="post">
<label for="progress">任务完成程度:</label>
<input type="text" value="" name="progress" id="progress" onblur="check()"/>
<input type="submit"  value="提交任务完成程度"  name="submit"/> 
</form>
</body>
</html>