<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提现</title>
<script type="text/javascript" >
function check(){
	 
	  var reducemoney=document.getElementById('reducemoney');
	  var value=document.getElementById('reducemoney').value;
	 
	  if(value<0){
		  alert("提现的钱不能为负数,请重新输入")
		  reducemoney.focus();
		 
	  }

	  else if(isNaN(value))
	{
		  alert("只能为数字,不能有其他字符,请重新输入")
		  reducemoney.focus();
	}

	  
	  
}
</script>
</head>
<body>
<form action="servlet/reducemoney" method="post">
<label for="reducemoney">提现的金额:</label>
<input type="text" value="" name="reducemoney" id="reducemoney" onblur="check()"/>
<input type="submit"  value="提交提现的金额"  name="submit"/> 
</form>
</body>
</html>