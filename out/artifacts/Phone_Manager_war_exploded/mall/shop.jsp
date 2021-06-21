<%@ page import="mod.Mobile" %><%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2021/6/9
  Time: 12:59 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购买页</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

    <%
        String path=request.getContextPath();
        Mobile mobile=null;
        if (session.getAttribute("whichMobile")!=null){
            mobile= (Mobile) session.getAttribute("whichMobile");
        }
    %>
    <style>
        .shopDiv{
            margin-top: 10px;
            border: 1px solid rgba(236, 234, 234, 0.97);
        }
        .imgDiv{
            height: 600px;
        }
        img{
            height: 100%;
            width: 100%;
        }
        .mm{
            font-size: 25px;
            font-weight: bold;
        }
        .val{
            height: 80px;
            background-color: #fff2e8;
            margin-left: 13px;
        }
        .valTex{
            margin-top: 30px;
        }
        .valVal{
            margin-top: 20px;
            font-size: 30px;
            font-weight: bold;
        }
        .btn_buy{
            width: 150px;
            height: 40px;
            color: #e5511d;
            background-color: #ffe4d0;
        }
        .btn_car{
            width: 182px;
            height: 40px;
            color: white;
            background-color: #ff4400;
        }
        a:hover{
            color: white;
        }
    </style>
</head>
<body>
<jsp:include page="/mall/header.jsp"/>
<div class="container">

    <div class="row shopDiv">
        <div class="col-md-6 imgDiv">
            <img src="<%=path%>/img/<%=mobile.getModel()%>.jpg">
        </div>
        <div class="col-md-6">
            <div class="row">
                <div class="col" style="height: 50px"></div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <p class="mm"><%=mobile.getModel()%></p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 val">
                    <p class="pull-left valTex">价格:</p><p class="text-danger pull-left valVal"><span class="glyphicon glyphicon-jpy"></span><%=mobile.getValue()%></p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <p class="pull-left" style="margin-top: 10px">厂家:</p><p class="text-primary pull-left" style="margin-top: 10px"><%=mobile.getFactory()%></p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <a href="#" class="btn btn_buy">立即购买</a>
                    <a href="#" class="btn btn_car"><span class="glyphicon glyphicon-shopping-cart"></span>加入购物车</a>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="js/jquery-3.1.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
