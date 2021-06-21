<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2021/6/1
  Time: 2:23 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>忘记密码</title>
    <%
        String path=request.getContextPath();
        if (session.getAttribute("isOldUser")!=null){
    %>
        <script>
            alert("未找到用户");
        </script>
    <%
            session.removeAttribute("isOldUser");
        }
    %>
    <link rel="stylesheet" href="<%=path%>/bootstrap/css/bootstrap.min.css">

    <style>

        body{
            background-image: url('<%=path%>/img/bg.png');
            background-size: 100% 100%;
            background-repeat: no-repeat;
        }
        .form_div{
            height: 300px;
            width: 400px;
            background-color: white;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col" style="height: 200px">

        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-4 form_div">
            <form action="ForgetPwdServlet" method="post" role="form" style="margin-top: 20px">
                <div class="form-group">
                    <label for="name">用户名</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="请输入名称">
                </div>
                <div class="form-group">
                    <label for="pwd">密码</label>
                    <input type="password" class="form-control" id="pwd" name="pwd">
                </div>
                <div class="form-group">
                    <label for="rpwd">确认密码</label>
                    <input type="password" class="form-control" id="rpwd" name="rpwd">
                </div>
                <script>
                    var pwd=document.getElementById("pwd");
                    var rpwd=document.getElementById("rpwd");
                    console.log(pwd.value+","+rpwd.value)
                    rpwd.onchange=function (){
                        if (pwd.value!=rpwd.value){
                            alert("两次密码不一致")
                            rpwd.value='';
                        }
                    }
                </script>
                <button type="submit" class="btn btn-success">提交</button>
            </form>
        </div>
    </div>
</div>
<script src="<%=path%>/js/jquery-3.1.1.min.js"></script>
<script src="<%=path%>/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
