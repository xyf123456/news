<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/4 0004
  Time: 下午 4:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<%=basePath%>/hello?opr=haha">请求helloServlet</a>
</body>
</html>
