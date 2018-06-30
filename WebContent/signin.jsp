<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>签到</title>
 <script>
        var a=<%=request.getParameter("b")%>;
        if(a==1){
            alert("恭喜你,开始签到成功!");
            parent.location.href=("user.jsp");
        }else if(a==0)  {
            alert("开始签到失败,请重试!");
        }
        else if(a==2){
        	 alert("恭喜你,结束签到成功!");
        	 window.location.href=("updateprogress.jsp");
        }
        else if(a==3){
        	alert("结束签到失败,请重试!");
       }
        
    </script>
</head>
<body>
<a href="servlet/beginsignin">开始签到</a>
<a href="servlet/endsignin">结束签到</a>
</body>
</html>