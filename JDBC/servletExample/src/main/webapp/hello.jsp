<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/12/7
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
        request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
%>
<!DOCTYPE html>
<html>
<head>
    <title>个人名片</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <meta charset="utf-8">
</head>
<body>
<div class="user_info">
    <h1><%= name %></h1>
    <p id="area">春招冲刺班</p>
</div>

<div class="hobby">
    <h2>我的爱好</h2>
    <ul>
        <li>写代码</li>
        <li>上课</li>
        <li>看动漫</li>
        <li>打游戏</li>
    </ul>
</div>

<div>
    <h2>我的教育经历</h2>
    <ol>
        <li><a href="https://www.qq.com" target="_blank">高中</a></li>
        <li><a href="https://v.bitedu.vip">大学</a></li>
        <li>西工院</li>
    </ol>

</div>


</body>
</html>
