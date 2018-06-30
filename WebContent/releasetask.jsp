<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布任务</title>
    <link rel="stylesheet" type="text/css" href="css/releaseTask.css">
    <script>
        function confirmOper() {
            var taskName = document.getElementById('taskname');
            var price = document.getElementById('price');
            var introduce = document.getElementById('introduce');
            if (taskName.value == "") {
                alert("任务名不能为空！");
                return false
            } else if (introduce.value == "") {
                alert("任务介绍不能为空!");
                return false;
            } else if (price.value == "") {
                alert("金额不能为空");
                return false;
            } else {
                if (window.confirm("确定发布任务"+taskName.value+"吗?")) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    </script>
        <script>
        var a=<%=request.getParameter("a")%>;
        if(a==1){
            alert("恭喜你,发布任务成功!");
            window.location.href=("releaseagreement.jsp");
        }else if(a==0)  {
            alert("发布任务失败，请重新发布!");
        }
        else if(a==2)  {
            alert("发布任务失败，用户拥有的钱不够，请先充值或减少发布任务的金额再发布任务!");
        }
    </script>
</head>
<body>

<h1>发布任务</h1>
<form action="servlet/releasetask" method="post" align="center">
    <tr>
        <td><label for="taskname">任务名:</label></td>
        <td><input type="text" class="text" name="taskname" id="taskname" value=""/></td>
    </tr>
    <br>
    <br>
    <br>
    <tr>
        <td><label for="introduce">任务简介:</label></td>
        <br>
        <%--<td><input type="textarea" class="text" name="introduce" id="introduce" value=""/></td>--%>
        <textarea style="resize:none" name="introduce" id="introduce" cols="200" rows="32"></textarea>
    </tr>
    <br>
    <br>
    <br>

    <tr>
        <td><label for="price">金额:</label></td>
        <td><input type="number" style="width: 80px" class="text" name="price" id="price" value=""/></td>
    </tr>
    <br>
    <input type="submit" id="fabu" value="发布任务" onclick="return confirmOper()" name="submit">
</form>
</body>
</body>
</html>