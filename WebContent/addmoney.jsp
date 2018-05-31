<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>充值</title>
<script type="text/javascript" >
function check(){
	 
	  var addmoney=document.getElementById('addmoney');
	  var value=document.getElementById('addmoney').value;
	 
	  if(value<0){
		  alert("充值的钱不能为负数,请重新输入")
		  addmoney.focus();
		 
	  }

	  else if(isNaN(value))
	{
		  alert("只能为数字,不能有其他字符,请重新输入")
		  addmoney.focus();
	}

	  
	  
}
</script>
</head>
<body>
<form action="servlet/addmoney" method="post">
<label for="addmoney">充值的金额:</label>
<input type="text" value="" name="addmoney" id="addmoney" onblur="check()"/>
<input type="submit"  value="提交充值的金额"  name="submit"/> 
</form>
</body>
</html>