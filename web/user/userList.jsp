<%@ page import="java.util.List" %>
<%@ page import="mod.User" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="mod.PageBean" %><%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2021/5/25
  Time: 7:54 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path=request.getContextPath();
        System.out.println(path);


    %>
    <title>Title</title>
    <link rel="stylesheet" href="<%=path%>/bootstrap/css/bootstrap.min.css">
    <style>
        body{
            background-image: url('<%=path%>/img/bg.png');
            background-size: 100% 100%;
            background-repeat: no-repeat;
        }
        .userList{
            background-color: rgba(0,0,0,0.1);
            border-radius: 5px;
        }
        #changeFrame{

            display: none;
        }
    </style>
</head>
<body>
<%
    List<User> userList= (List<User>) session.getAttribute("userList");
    System.out.println(userList);
    PageBean<User> pageBean =new PageBean<>();
    System.out.println(pageBean);
    System.out.println(userList);
    if (session.getAttribute("isDelete")!=null){
        boolean isDelete= (boolean) session.getAttribute("isDelete");
%>
    <script>
        alert(<%=isDelete%>?"删除成功":"删除失败");
    </script>
<%
        session.removeAttribute("isDelete");
    }
%>
<div class="container">
    <div class="row"><div class="col" style="height: 100px"></div> </div>
    <div class="row">
        <div class="col-md-6">
            <div class="userList">
                <table class="table table-striped">
<%--                    <caption>用户列表</caption>--%>
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>姓名</th>
                        <th>邮箱</th>
                        <th>性别</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        Iterator iterator=userList.iterator();
                        while (iterator.hasNext()){
                            User user=(User) iterator.next();
                    %>
                    <tr>
                        <td><%=user.getId()%></td>
                        <td><%=user.getName()%></td>
                        <td><%=user.getEmail()%></td>
                        <td><%=user.getGender()%></td>
                        <td><a  href="<%=path%>/ChangeUserServlet?id=<%=user.getId()%>" target="changeFrame" onclick="session_link()">修改</a></td>
                        <script>
                            var session_link=function (){
                                showFrame();
                            }
                        </script>
                        <td><a href="<%=path%>/DeleteUserServlet?id=<%=user.getId()%>">删除</a></td>--%>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-5"><iframe src="<%=path%>/user/changeUser.jsp" id="changeFrame" name="changeFrame" height="300px" width="500px" frameborder="0"></iframe></div>
        <script>
            var showFrame=function () {
                document.getElementById("changeFrame").style.display="block";
            }
        </script>
    </div>
    <div class="row">
        <div class="col-md-12 pageList">
            <ul class="pagination">
                <li><a href="#">&laquo;</a></li>
                <%for (int i = 0; i <pageBean.getTotalPage(); i++) {%>
                <li><a href="<%=path%>/UserManServlet?index=<%=i%>"><%=i+1%></a> </li>
                <%}%>
                <li>
                    <a href="#">&raquo;</a>
                    <span class="dataSpan" style="margin-left: 10px;border-radius: 5px">当前<%=pageBean.getTotalCount()%>条数据，共<%=pageBean.getTotalPage()%>页</span>
                </li>
            </ul>
        </div>

    </div>
</div>
<script src="<%=path%>/js/jquery-3.1.1.min.js"></script>
<script src="<%=path%>/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
