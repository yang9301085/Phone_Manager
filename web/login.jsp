<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2021/5/25
  Time: 3:05 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>手机管理系统</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <style>
        body{
            background-image: url("img/bg.png");
            background-size: 100% 100%;
            background-repeat: no-repeat ;
        }
        .title{
            position: relative;
            margin-top: 20px;
            width: 360px;
            height: 40px;
            background-color: #60af60;
            color: white;
            left: -18px;
        }
        .title p{
            margin-top: 40px;
            padding-top: 5px;
            margin-left: 55px;
            font-size: 20px;
        }
        .yy{
            margin-top: -3px;
        }
        .form_div{
            width: 400px;
            height: 450px;
            background-color: white;
            border-radius: 5px;
            position: absolute;
            top: 20%;
            left: 38%;
        }
        .fg{
            margin-top: 60px;
            margin-left: 25px;
        }
        input{
            margin-bottom: 10px;
        }
        .btn{
            width: 300px;
            margin: 10px 1px;
        }
        .btnN{
            width: 100px;
        }
    </style>
</head>
<body>
<script>
    <%
        if (request.getAttribute("fail")!=null){
            String res=(String) request.getAttribute("fail");%>
            alert("<%=res%>");
        <%
            session.removeAttribute("fail");
        }
    %>
</script>
<div class="container">
    <div class="row form_div">
        <div class="col title">
            <p>手机管理系统登陆</p>
            <img class="yy" src="img/aiwrap.png">
        </div>
        <div class="col-md-3 fg">
            <form action="LoginServlet" method="post" role="form">
                <div class="form-group">
                    <label for="usrName">用户名</label>
                    <input class="form-control" id="usrName" name="usrName" style="width: 300px" required>
                </div>
                <div class="form-group">
                    <label for="pwd">密码</label>
                    <input class="form-control" id="pwd" name="pwd" style="width: 300px" required>
                </div>


                <button class="btn btn-success">提交</button>
            </form>
        </div>
        <div style="margin-left: 40px;">
            <div class="btn-group">
                <button type="button" class="btn btn-success btnN" onclick="toRes()">注册</button>
                <button type="button" class="btn btn-default btnN" style="border: 0px;color: white" >or</button>
                <button type="button" class="btn btn-success btnN" onclick="toFog()">忘记密码</button>
            </div>
            <script >
                let toRes=function () {
                    window.location.href='register.jsp'
                }
                let toFog=function () {
                    window.location.href='forget.jsp'
                }
            </script>
        </div>
    </div>
</div>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
