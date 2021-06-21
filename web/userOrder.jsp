<%@ page import="java.util.List" %>
<%@ page import="mod.Mobile" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="mod.Order" %><%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2021/6/9
  Time: 8:14 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户订单</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<%
    List<String> listModelCount= (List<String>) session.getAttribute("listModel");
    List<Order> orderList=(List<Order>) session.getAttribute("orderList");
%>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <table class="table table-striped">
                <caption>用户订单</caption>
                <thead>
                <tr>
                    <th>id</th>
                    <th>用户名</th>

                    <%
                        Iterator iterator=listModelCount.iterator();
                        while (iterator.hasNext()){
                    %>
                    <th><%=iterator.next()%></th>
                    <%
                        }
                    %>

                </tr>
                </thead>
                <tbody>
                <%
                    Iterator itOrder=orderList.iterator();
                    while (itOrder.hasNext()){
                        Order<Integer> order= (Order<Integer>) itOrder.next();

                %>
                <tr>
                    <td><%=order.getId()%></td>
                    <td><%=order.getUserName()%></td>
                <%
                    List<Integer> integerList=order.getListModelCount();
                    Iterator iterator1=integerList.iterator();
                    while (iterator1.hasNext()){
                %>
                    <td><%=iterator1.next()%></td>
                <%
                    }
                %>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>


<script src="js/jquery-3.1.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
