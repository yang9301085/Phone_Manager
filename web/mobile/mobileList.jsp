<%@ page import="mod.PageBean" %>
<%@ page import="mod.Mobile" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2021/5/28
  Time: 7:09 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path=request.getContextPath();
        PageBean<Mobile> pageBean=(PageBean<Mobile>) session.getAttribute("pageBean");
        List<Mobile> list=(List<Mobile>) session.getAttribute("modelList");
    %>
    <title>Title</title>
    <link rel="stylesheet" href="<%=path%>/bootstrap/css/bootstrap.min.css">
    <style>
        body{
            background-image: url('<%=path%>/img/bg.png');
            background-size: 100% 100%;
            background-repeat: no-repeat;
        }
        #changeMobileFrame{
            margin-top: 100px;
            display: none;
        }
    </style>
</head>
<div class="container">
    <div class="row"><div class="col" style="height: 100px"></div> </div>
    <div class="row">
        <div class="col-md-6">
            <div class="userList">
                <table class="table table-striped">
                    <caption>手机列表</caption>
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>手机型号</th>
                        <th>价格</th>
                        <th>生产商</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        Iterator iterator=list.iterator();
                        while (iterator.hasNext()){
                            Mobile mobile=(Mobile) iterator.next();
                    %>
                    <tr>
                        <td><%=mobile.getId()%></td>
                        <td><%=mobile.getModel()%></td>
                        <td><%=mobile.getValue()%></td>
                        <td><%=mobile.getFactory()%></td>
                        <td><a  href="<%=path%>/ChangeMobileServlet?id=<%=mobile.getId()%>" target="changeMobileFrame" onclick="session_link()">修改</a></td>
                        <script>
                            var session_link=function (){
                                showFrame();
                            }
                        </script>
                        <td><a href="<%=path%>/DeleteMobileServlet?id=<%=mobile.getId()%>">删除</a></td>--%>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-5"><iframe src="<%=path%>/mobile/changeMobile.jsp" id="changeMobileFrame" name="changeMobileFrame" height="300px" width="500px" frameborder="0"></iframe></div>
        <script>
            var showFrame=function () {
                document.getElementById("changeMobileFrame").style.display="block";
            }
        </script>
    </div>
    <div class="row">
        <div class="col-md-12 pageList">
            <ul class="pagination">
                <li><a href="#">&laquo;</a></li>
                <%for (int i = 0; i <pageBean.getTotalPage(); i++) {%>
                <li><a href="<%=path%>/MobileListServlet?index=<%=i%>"><%=i+1%></a> </li>
<%--                <li><a href="#"><%=i+1%></a> </li>--%>
                <%}%>
                <li>
                    <a href="#">&raquo;</a>
                    <span class="dataSpan" style="margin-left: 10px;border-radius: 5px">当前<%=pageBean.getTotalCount()%>条数据，共<%=pageBean.getTotalPage()%>页</span>
                </li>
            </ul>
        </div>
    </div>
</div>

<body>

<script src="<%=path%>/js/jquery-3.1.1.min.js"></script>
<script src="<%=path%>/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
