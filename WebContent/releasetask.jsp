<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布任务</title>
</head>
<body>

  <form  action="servlet/releasetask"method="post">
     <table>
     <tr>
      <td><label for="taskname">任务名:</label></td>
      <td><input type="text"  name="taskname" id="taskname" value="" /></td>
      </tr>
      <tr>
      <td><label for="introduce">任务介绍:</label></td>
      <td><input type="text"  name="introduce" id="introduce" value="" /></td>
      </tr>  
       <tr>
      <td><label for="price">可获金额:</label></td>
      <td><input type="number"  name="price" id="price" value="" /></td>
      </tr> 
      <tr>
      <td><label for="date">发布日期:</label></td>
      <td><input type="text"  name="date" id="date" value="" /></td>
      </tr>
       
     </table>    
  
           <input type="submit"  value="发布任务"  name="submit""/> 
             
    
 </table>
</form> 
</body>
</html>