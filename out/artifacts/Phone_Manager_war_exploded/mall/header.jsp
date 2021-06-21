<%@ page import="mod.User" %><%--
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
    <%
        String path=request.getContextPath();
    %>
    <link rel="stylesheet" href="<%=path%>/bootstrap/css/bootstrap.min.css">
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
                <li>
                    <a href="mall/order.jsp">我的订单</a>
                </li>
                    <%
                        if (session.getAttribute("userInfo")!=null){
                            User user= (User) session.getAttribute("userInfo");
                    %>
                <li>
                    <a href="#"> 您的余额:<%=user.getBalance()%></a>

                </li>
                <li>
                    <a href="<%=path%>/mall/charge.jsp?id=<%=user.getId()%>&name=<%=user.getName()%>&balance=<%=user.getBalance()%>">充值</a>
                </li>
                    <%
                        }
                    %>

            </ul>
        </div>
    </div>
</nav>
<script src="<%=path%>/js/jquery-3.1.1.min.js"></script>
<script src="<%=path%>/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
