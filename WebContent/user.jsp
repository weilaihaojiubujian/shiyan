<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script>
        var a=<%=request.getParameter("a")%>
        if(a!=""){
            if(a==1){
                alert("发布任务成功1");
                parent.location.reload()
            }else if(a==2){
                alert("数据库操作失败2");
                parent.location.reload()
            }else if(a==3){
                alert("余额不足3");
                parent.location.reload()
            }
            else if(a==4){
                alert("没有已接受任务，请去接受任务吧");
                parent.location.reload()
            }
            else if(a==5){
            	alert("修改用户信息成功");
                parent.location.reload()
            }
        }

    </script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">智能服务众包发布平台</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    <%=session.getAttribute("username") %>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="logout.jsp" target="content_frame">退出系统</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">任务管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="releasetask.jsp" target="content_frame">发布任务</a></dd>
                        <dd><a href="task.jsp" target="content_frame">查看未接受任务</a></dd>
                        <dd><a href="alreadytask" target="content_frame">查看已接受的任务</a></dd>
                        <dd><a href="completetask.jsp" target="content_frame">查看已完成的任务</a></dd>
                        <dd><a href="releasetaskbyuser.jsp" target="content_frame">查看发布的任务</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                <li class="layui-nav-item layui-nav-itemed"><a class="" href="userinformation.jsp" target="content_frame">用户管理</a></li>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe name="content_frame" src="userinformation" style="height: 100%; width: 100%"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>