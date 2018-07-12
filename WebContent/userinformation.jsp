<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="bean.user"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
     <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
      <script src="layui/jquery-3.3.1.min.js"></script>
    <%--<link rel="stylesheet" type="text/css" href="css/button.css">--%>
    <script src="js/userInformation.js"></script>
     <script>
        var a =<%=request.getParameter("b")%>;
        if (a == 1) {
            alert("恭喜你,提现成功!");
            parent.location.href = ("user.jsp");
        } else if (a == 0) {
            alert("提现失败!");
        }
        else if (a == 2) {
            alert("恭喜你,充值成功!");
            parent.location.href = ("user.jsp");
        } else if (a == 3) {
            alert("充值失败!");
        }

        function confirmOpe() {
     
            var chose = $("input[name='chose']:checked").val();
            var price = document.getElementById("price");
            if (price.value == "") {
                alert("金额不能为空");
                return false;
            } else if (isNaN(price.value)) {
                alert("请输入数字");
                return false;
            } else if (window.confirm("确定" + chose + price.value + "元吗?")) {
                return true;
            } else {
                return false;
            }
        }

        function change() {
        	var a=document.getElementById("username").removeAttribute("readonly");
        	var b=document.getElementById("address").removeAttribute("readonly");
        	var c=document.getElementById("bankaccount").removeAttribute("readonly");
        	var d=document.getElementById("card").removeAttribute("readonly");
        
        }
    </script>
</head>
<body>
<div id="bg">
    </div>
    <%
        user u = new user();
    %>
    <div id="content" align="center">

        <form class="layui-form" id="form1" action="servlet/updateuserinformation" method="post">
            <div class="layui-form-item">
                <label class="layui-form-label">用户名称</label>
                <div class="layui-input-block">
                    <input type="text" readonly name="username" id="username" value="<%=session.getAttribute("username") %>"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">家庭地址</label>
                <div class="layui-input-block">
                    <input type="text" readonly name="address" id="address"  value="<%=session.getAttribute("address") %>" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">银行账号</label>
                <div class="layui-input-block">
                    <input type="text" readonly name="bankaccount" id="bankaccount" value="<%=session.getAttribute("bankaccount") %>"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">身份证号</label>
                <div class="layui-input-block">
                    <input type="text" readonly name="card" id="card" value="<%=session.getAttribute("card") %>" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">拥有金额</label>
                <div class="layui-input-block">
                    <input type="text" readonly name="money" id="money" value="<%=session.getAttribute("money") %>" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            
        </form>
        <form class="layui-form" action="servlet/addmoney"  method="post">
            <div class="layui-form-item">
                <label class="layui-form-label">请输入数字</label>
                <div class="layui-input-block">
                    <input id="price" type="text" name="price" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <input type="radio" name="chose" value="充值" title="充值">
                    <input type="radio" name="chose" value="提现" title="提现" checked>
                    <input type="submit" value="确认充值金额" class="layui-btn" onclick="return confirmOpe()" name="submit">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <input type="button" value="编辑" class="layui-btn" onclick="change()" form="form1">
                    <input type="submit" value="确认修改" class="layui-btn" name="submit" form="form1">
                </div>
            </div>
        </form>
    </div>
</div>
<script src="layui/layui.js"></script>
<script>
    layui.use('form', function () {
        var form = layui.form;

        //各种基于事件的操作，下面会有进一步介绍
    });
</script>
</body>
</html>