<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2021/5/25
  Time: 4:33 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>手机管理系统</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid" >
    <div class="row">
        <div class="col-md-2" >
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                用户管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <a class="list-group-item" href="UserManServlet" target="frames">用户列表</a>
                            <a class="list-group-item" href="register.jsp" target="frames">用户注册</a>
                            <a class="list-group-item" href="UserOrderServlet" target="frames">用户订单</a>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a  data-toggle="collapse" data-parent="#accordion"
                               href="#collapseTwo">
                                手机型号管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse">
                        <div class="panel-body">
                            <a class="list-group-item" href="MobileListServlet" target="frames">手机列表</a>
                            <a class="list-group-item" href="mobile/registerMobile.jsp" target="frames">型号登记</a>
                            <a class="list-group-item" href="javascript:void(0);" target="frames">型号删除</a>
                            <a class="list-group-item" href="javascript:void(0);" target="frames">型号修改</a>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a  data-toggle="collapse" data-parent="#accordion"
                                href="#collapseFour">
                                手机厂家管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseFour" class="panel-collapse collapse">
                        <div class="panel-body">
                            <a class="list-group-item" href="javascript:void(0);" target="frames">厂家名称</a>
                            <a class="list-group-item" href="javascript:void(0);" target="frames">厂家电话</a>
                            <a class="list-group-item" href="javascript:void(0);" target="frames">厂家地址</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-10" >
            <iframe src="default.jsp" name="frames" width="100%" height="87%" frameborder="0"></iframe>
        </div>
    </div>
    <div class="row">
        <div class="col" >
            <nav class="nav navbar-default">
                <div class="container-fluid">
                    <div class="nav navbar-header">
                        <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-jpy"></span></a>
                    </div>
                    <div>
                        <ul class="nav navbar-nav">
                            <li><a href="#"><span class="glyphicon glyphicon-flag"></span></a></li>
                            <li><a href="#"><span class="glyphicon glyphicon-flag"></span></a></li>
                            <li><a href="#"><span class="glyphicon glyphicon-flag"></span></a></li>
                            <li><a href="#"><span class="glyphicon glyphicon-flag"></span></a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</div>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
