<%@ page import="java.util.List" %>
<%@ page import="mod.Mobile" %><%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2021/6/8
  Time: 9:52 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>手机商城</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

    <%
        String path=request.getContextPath();
        List<Mobile> list=(List<Mobile>) session.getAttribute("mobileList");
        int rows=(list.size()%3==0)?list.size()/3:(list.size()/3+1);
    %>

    <style>
        .row{
            margin-bottom: 10px;
        }
        .mobile{
            /*background-color: #5bc0de;*/
            /*border-radius: 5px;*/
            height: 280px;
            margin-left: 30px;
            border: 1px solid rgba(236, 234, 234, 0.97);
        }
        .imgs{
            height: 190px;
            padding-top: 10px;
        }
        img{
            height: 100%;
            width: 100%;
        }
    </style>
</head>
<body>
<jsp:include page="/mall/header.jsp"/>
<div class="container" style="margin-top: 10px">
    <%
        int index=0;
        int indexValue=0;
        int indexImg=0;
        int indexBuy=0;
        for(int i=0;i<rows;i++){
            %>
    <div class="row" >
        <div class="col-md-3 col-md-offset-1 mobile">
            <div class="imgs row">
                <div class="col-md-10 col-md-offset-1">
                    <img src="<%=path%>/img/<%=list.get(indexImg++).getModel()%>.jpg">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-2">
                    <p><%=list.get(index++).getModel()%></p>
                    <p><%=list.get(indexValue++).getValue()%></p>
                </div>
                <div class="col-md-4">
                    <a class="btn" href="ShopServlet?model=<%=list.get(indexBuy++).getModel()%>">购买</a>
<%--                    <a href="#">购买</a>--%>
                </div>
            </div>
        </div>
        <div class="col-md-3 mobile">
            <div class="imgs row">
                <div class="col-md-10 col-md-offset-1">
                    <img src="<%=path%>/img/<%=list.get(indexImg++).getModel()%>.jpg">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-2">
                    <p><%=list.get(index++).getModel()%></p>
                    <p><%=list.get(indexValue++).getValue()%></p>
                </div>
                <div class="col-md-4">
                    <a class="btn" href="ShopServlet?model=<%=list.get(indexBuy++).getModel()%>">购买</a>

<%--                    <a href="#">购买</a>--%>
                </div>
            </div>
        </div>
        <div class="col-md-3 mobile">
            <div class="imgs row">
                <div class="col-md-10 col-md-offset-1">
                    <img src="<%=path%>/img/<%=list.get(indexImg++).getModel()%>.jpg">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-2">
                    <p><%=list.get(index++).getModel()%></p>
                    <p><%=list.get(indexValue++).getValue()%></p>
                </div>
                <div class="col-md-4 ">
                    <a class="btn" href="ShopServlet?model=<%=list.get(indexBuy++).getModel()%>">购买</a>

<%--                    <a href="#">购买</a>--%>
                </div>
            </div>
        </div>
    </div>

    <%
        }
    %>
</div>


<script src="js/jquery-3.1.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
