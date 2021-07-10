<%@ page import="java.util.List" %>
<%@ page import="mod.Factory" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2021/7/6
  Time: 11:36 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <%
        String path=request.getContextPath();
        List<Factory> list=new ArrayList<>();
        int size=0;
        int rows=0;
        if(session.getAttribute("factoryList")!=null){
            list= (List<Factory>) session.getAttribute("factoryList");
            size=list.size();
            rows=size%4==0?size/4:(size/4)+1;
        }
    %>
    <link rel="stylesheet" href="<%=path%>/bootstrap/css/bootstrap.min.css">

    <style type="text/css">
        html{height:100%}
        body{height:100%;margin:0px;padding:0px}
        .maps{
            height:300px;
            width: 250px;
        }
    </style>
    <script type="text/javascript" src="https://api.map.baidu.com/api?v=1.0&type=webgl&ak=EGc5R2i5hoNcBAPGLmpn6N3QPSvDhyZe">
    </script>
</head>
<body>
<div class="container-fluid">
    <%
        int j=0;
        for (int i=0;i<rows;i++){%>
          <div class="row">
              <div class="col-sm-6 col-md-3">
                  <div class="thumbnail">
                      <div id="container<%=list.get(i).getId()%>" class="maps"></div>
                      <script type="text/javascript">
                          var map = new BMapGL.Map("container<%=list.get(i).getId()%>");
                          // 创建地图实例
                          var point = new BMapGL.Point(<%=list.get(i).getLongitude()%>, <%=list.get(i).getLatitude()%>);
                          // 创建点坐标
                          map.centerAndZoom(point, 15);
                          // 初始化地图，设置中心点坐标和地图级别
                      </script>
                      <div class="caption">
                          <h3><%=list.get(i).getName()%></h3>
                          <p><%=list.get(i).getAddr()%></p>
                          <p><%=list.get(i).getPhone()%></p>
                      </div>
                  </div>
              </div>
              <div class="col-sm-6 col-md-3">
                  <div class="thumbnail">
                      <div id="container<%=list.get(i+1).getId()%>" class="maps"></div>
                      <script type="text/javascript">
                          var map = new BMapGL.Map("container<%=list.get(i+1).getId()%>");
                          // 创建地图实例
                          var point = new BMapGL.Point(<%=list.get(i+1).getLongitude()%>, <%=list.get(i+1).getLatitude()%>);
                          // 创建点坐标
                          map.centerAndZoom(point, 15);
                          // 初始化地图，设置中心点坐标和地图级别

                      </script>
                      <div class="caption">
                          <h3><%=list.get(i+1).getName()%></h3>
                          <p><%=list.get(i+1).getAddr()%></p>
                          <p><%=list.get(i+1).getPhone()%></p>
                      </div>
                  </div>
              </div>
              <div class="col-sm-6 col-md-3">
                  <div class="thumbnail">

                      <div id="container<%=list.get(i+2).getId()%>" class="maps"></div>
                      <script type="text/javascript">
                          var map = new BMapGL.Map("container<%=list.get(i+2).getId()%>");
                          // 创建地图实例
                          var point = new BMapGL.Point(<%=list.get(i+2).getLongitude()%>, <%=list.get(i+2).getLatitude()%>);
                          // 创建点坐标
                          map.centerAndZoom(point, 15);
                          // 初始化地图，设置中心点坐标和地图级别

                      </script>
                      <div class="caption">
                          <h3><%=list.get(i+2).getName()%></h3>
                          <p><%=list.get(i+2).getAddr()%></p>
                          <p><%=list.get(i+2).getPhone()%></p>
                      </div>
                  </div>
              </div>
              <div class="col-sm-6 col-md-3">
                  <div class="thumbnail">
                      <div id="container<%=list.get(i+3).getId()%>" class="maps"></div>
                      <script type="text/javascript">
                          var map = new BMapGL.Map("container<%=list.get(i+3).getId()%>");
                          // 创建地图实例
                          var point = new BMapGL.Point(<%=list.get(i+3).getLongitude()%>, <%=list.get(i+3).getLatitude()%>);
                          // 创建点坐标
                          map.centerAndZoom(point, 15);
                          // 初始化地图，设置中心点坐标和地图级别
                      </script>
                      <div class="caption">
                          <h3><%=list.get(i+3).getName()%></h3>
                          <p><%=list.get(i+3).getAddr()%></p>
                          <p><%=list.get(i+3).getPhone()%></p>
                      </div>
                  </div>
              </div>
          </div>
        <%}
    %>

</div>


<script src="<%=path%>/js/jquery-3.1.1.min.js"></script>
<script src="<%=path%>/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
