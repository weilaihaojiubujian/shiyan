<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布合同</title>
</head>
<body>
<form  action="servlet/releaseagreement"method="post">
     <table>
     <tr>
      <td><label for="agreementname">合同名:</label></td>
      <td><input type="text"  name="agreementname" id="agreementname" value="" /></td>
      </tr>
      <tr>
      <td><label for="agreementintroduce">合同介绍:</label></td>
      <td><input type="text"  name="agreementintroduce" id="agreementintroduce" value="" /></td>
      </tr>  
    
       
     </table>    
  
           <input type="submit"  value="签订合同"  name="submit""/> 
             
   
</form>
</body>
</html>