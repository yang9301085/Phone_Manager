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
                    alert("登记成功");
                }else {
                    alert("登记失败");
                }
            </script>
    <%
            session.removeAttribute("isSuccess");
        }
    %>
    <title>用户注册</title>
    <link rel="stylesheet" href="<%=path%>/bootstrap/css/bootstrap.min.css">

    <style>
        body{
            background-image: url('<%=path%>/img/bg.png');
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
            <form action="<%=path%>/RegisterMobileServlet" method="post" role="form">
                <div class="input-group">
                    <span class="input-group-addon">型号</span>
                    <input type="text" class="form-control" id="userName" name="model" required>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">价格</span>
                    <input type="text" class="form-control" id="pwd" name="value" required>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">厂商</span>
                    <input type="text" class="form-control" id="rpwd" name="factory" required>
                    <p id="pwdCh" style="display: none"></p>
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
