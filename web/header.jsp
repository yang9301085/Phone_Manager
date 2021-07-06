<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2021/5/25
  Time: 4:51 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <style>
        .logo{
            color: rgba(89, 4, 102, 0.8);
        }
    </style>
</head>
<body>
<nav class="nav navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                <span class="glyphicon glyphicon-btc logo"></span>
            </a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <%
                    if (session.getAttribute("loginUser")!=null){
                        String name=(String) session.getAttribute("loginUser");
                %>
                    <li>
                        <a href="#"><%=name%>欢迎您</a>
                    </li>
                <%
                    }else{
                %>
                    <li>
                        <a href="#">登陆</a>
                    </li>
                <%
                    }
                %>

            </ul>
        </div>
    </div>
</nav>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
