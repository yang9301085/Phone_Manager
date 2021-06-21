<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2021/5/25
  Time: 6:02 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path=request.getContextPath();
        if (session.getAttribute("isSuccess")!=null){
            boolean isSuccess=(Boolean) session.getAttribute("isSuccess");
    %>
            <script>
                if (<%=isSuccess%>){
                    alert("注册成功");
                }else {
                    alert("注册失败");
                }
            </script>
    <%
            session.removeAttribute("isSuccess");
        }
        if (session.getAttribute("isOnly")!=null){
    %>
        <script>

            alert("用户名重复");

        </script>
    <%
            session.removeAttribute("isOnly");
        }
    %>
    <title>用户注册</title>
    <link rel="stylesheet" href="<%=path%>/bootstrap/css/bootstrap.min.css">

    <style>
        body{
            background-image: url('img/bg.png');
            background-size: 100% 100%;
            background-repeat: no-repeat;
        }
        .in_div{

        }
        form{
            margin-top: 30%;
            margin-left: 20%;
            height: 500px;
        }
        .input-group{
            width: 400px;
            margin-top: 10px;
        }
        .dm{
            background-color: rgba(0, 0, 0, 0);
            border: 0;
        }
        .bs{
            width: 100%;
        }
        .tj{
            margin-top: 18%;
            width: 400px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row in_div" >
        <div class="col-md-6 col-md-offset-3">
            <form action="RegisterServlet" method="post" role="form">
                <div class="input-group">
                    <span class="input-group-addon">用户名</span>
                    <input type="text" class="form-control" id="userName" name="userName" required>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">密码</span>
                    <input type="text" class="form-control" id="pwd" name="pwd" required>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">确认密码</span>
                    <input type="text" class="form-control" id="rpwd" name="rpwd" required>
                    <p id="pwdCh" style="display: none"></p>
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
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon glyphicon-envelope"></span></span>
                    <input type="text" class="form-control" id="email" name="email" required>
                </div>
                <div class="input-group">
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                            性别<span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu dm">
                            <li><button type="button" class="btn btn-danger bs" id="btnM" value="男">男</button></li>
                            <li><button type="button" class="btn btn-success bs" id="btnF" value="女">女</button></li>
                        </ul>
                    </div>
                    <input type="text" class="form-control" id="sexIn" name="sex" required>
                    <script>
                        var sexM=document.getElementById("btnM");
                        var sexF=document.getElementById("btnF");
                        var sexText=document.getElementById("sexIn");
                        var sexFun=function(sex){
                            sexText.value=sex;
                        }
                        sexM.onclick=function (){
                            sexFun(sexM.value)
                        }
                        sexF.onclick=function (){
                            sexFun(sexF.value)
                        }
                        sexText.onchange=function (){
                            if (!(sexText.value=="男"||sexText.value=="女")){
                                alert("您是什么牛马？？？？");
                                sexText.value='';
                            }
                        }
                    </script>
                </div>
                <div class="input-group">
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                            角色<span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu dm">
                            <li><button type="button" class="btn btn-danger bs" id="btnMan" value="管理员">管理员</button></li>
                            <li><button type="button" class="btn btn-success bs" id="btnCon" value="用户">用户</button></li>
                        </ul>
                    </div>
                    <input type="text" class="form-control" id="isUserIn" name="isUser" required>
                    <script>
                        var btnMan=document.getElementById("btnMan");
                        var btnCon=document.getElementById("btnCon");
                        var isUserText=document.getElementById("isUserIn");
                        var isUserFun=function(isUser){
                            isUserText.value=isUser;
                        }
                        btnMan.onclick=function (){
                            isUserFun(btnMan.value)
                        }
                        btnCon.onclick=function (){
                            isUserFun(btnCon.value)
                        }
                        isUserText.onchange=function (){
                            if (!(isUserText.value=="管理员"||isUserText.value=="用户")){
                                alert("管理员：您是什么牛马？？？？");
                                isUserText.value='';
                            }
                        }
                    </script>
                </div>
                <div class="input-group">
                    <button type="submit" class="btn btn-success tj">提交</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="<%=path%>/js/jquery-3.1.1.min.js"></script>
<script src="<%=path%>/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
