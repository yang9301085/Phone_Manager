<%@ page import="javafx.scene.control.Alert" %><%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2021/6/10
  Time: 7:26 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>充值页</title>
    <%
        int id=0;
        String name="bb";
        double balance=0;
        String path=request.getContextPath();
        if(request.getParameter("id")!=null) {
            id = Integer.parseInt(request.getParameter("id"));
        }
        if (request.getParameter("name")!=null){
            name = request.getParameter("name");
        }
        if (request.getParameter("balance")!=null){
            balance = Double.valueOf(request.getParameter("balance"));
        }
        if (session.getAttribute("balance")!=null){
            balance= (double) session.getAttribute("balance");
        }
        if (session.getAttribute("bName")!=null){
            name=(String) session.getAttribute("bName");
        }
        if (session.getAttribute("error")!=null){
        %>
            <scrip>
                alert("充值失败");
            </scrip>
        <%
        }
    %>
    <link rel="stylesheet" href="<%=path%>/bootstrap/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <p>id:<%=id%></p>
            <p>姓名:<%=name%></p>
            <p>当前余额:<%=balance%></p>
            <form action="<%=path%>/BalanceServlet" role="form">
                <div class="form-group">
                    <label for="chargeText">充值金额</label>
                    <input type="text" name="id" value="<%=id%>" style="display: none">
                    <input type="text" name="name" value="<%=name%>" style="display: none">
                    <input type="text" name="balance" value="<%=balance%>" style="display: none">
                    <input type="text" class="form-control" id="chargeText" name="chargeText" placeholder="请输入充值金额">
                </div>
                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>
</div>
<script src="<%=path%>/js/jquery-3.1.1.min.js"></script>
<script src="<%=path%>/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>