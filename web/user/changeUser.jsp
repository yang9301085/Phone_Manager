<%@ page import="mod.User" %><%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2021/5/27
  Time: 7:09 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            width: 350px;
            height: 250px;
            color: white;
        }
        input{
            height: 40px;
            width: 300px;
            border-radius: 5px;
            margin-top: 10px;
            background-color: rgba(0,0,0,0.1);
            border: 0;
            outline: none;
        }
        button{
            border: none;
            border-radius: 5px;
            margin-top: 10px;
            width: 200px;
            height: 40px;
        }
    </style>
</head>
<body>
<%
    if(session.getAttribute("userInfo")!=null) {
        User user = (User) session.getAttribute("userInfo");%>
        <form action="ChangeUserInfoServlet" method="post">
    <input name="id" type="text" value="<%=user.getId()%>" readonly style="display: none">
    姓名<input name="name" type="text" value="<%=user.getName()%>"><br>
    邮箱<input name="email" type="text" value="<%=user.getEmail()%>"><br>
    性别<input name="sex" type="text" value="<%=user.getGender()%>"><br>
    <center>
        <button id="btn_f" type="submit">提交</button>
    </center>
            <script>
                var btn=document.getElementById("btn_f");
                btn.onclick=function (){
                    <%
                        session.setAttribute("btn_f",true);
                    %>
                }
            </script>
</form>
    <%}else {
%>
<form action="ChangeUserInfoServlet" method="post">
    <input name="id" type="text" style="display: none">
    姓名<input name="name" type="text" ><br>
    邮箱<input name="email" type="text" ><br>
    性别<input name="sex" type="text" ><br>
    <center>
        <button type="submit">提交</button>
    </center>
</form>
<%}%>
</body>
</html>
