<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.bdqn.entity.Topic" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>添加主题--管理后台</title>
    <link href="<%=basePath%>/css/admin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=basePath%>/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<div id="header">
    <div id="welcome">
        欢迎使用新闻管理系统！
    </div>
    <div id="nav">
        <div id="logo"><img src="<%=basePath%>/images/logo.jpg" alt="新闻中国"/></div>
        <div id="a_b01"><img src="<%=basePath%>/images/a_b01.gif" alt=""/></div>
    </div>
</div>
<div id="admin_bar">
    <div id="status">管理员：<%=session.getAttribute("login")%> 登录 &#160;&#160;&#160;&#160; <a href="#">login
        out</a></div>
    <div id="channel"></div>
</div>
<div id="main">
    <%--<%@ include file="../console_element/left.html" %>--%>
    <%--<jsp:include page="console_element/left.jsp"/>--%>
    <iframe src="<%=basePath%>/newspages/console_element/left.html" scrolling="no" frameborder="0"
            width="130px"></iframe>
    <div id="opt_area">
        <ul class="classlist">
            <%--<%
                List<Topic> list = (List<Topic>) request.getAttribute("list");
            %>
            <c:if test="${requestScope.list!=null}">
                <c:forEach  items="${requestScope.list}" var="topic">
                    <li> &#160;&#160;&#160;&#160; ${topic.tname} &#160;&#160;&#160;&#160;
                        <a href='<%=basePath%>/newspages/topic?tid=${topic.tid}&tname=${topic.tname}'>修改</a>
                        &#160;&#160;&#160;&#160; <a href='<%=basePath%>/topic?opr=del&tid=${topic.tid}'>删除</a>
                    </li>
                </c:forEach>
            </c:if>--%>
        </ul>
    </div>
    <div id="footer">
        <%@include file="/newspages/console_element/bottom.html" %>
        <%--<jsp:include page="/jsp/newspages/console_element/bottom.html"></jsp:include>--%>
        <%--<iframe src="<%=basePath%>/jsp/newspages/console_element/bottom.html" scrolling="no" frameborder="0"
                width="947px"
                height="190px"></iframe>--%>
    </div>
        <script>
            $(document).ready(function () {
                $.post("<%=basePath%>/topic","opr=topicList",callBack,"JSON");
            });
            function callBack(data) {
                console.log(data);
                <%--for(var i=0;i<data.length;i++){
                    $(".classlist").append("<li>&#160;&#160;&#160;&#160;"+data[i].tname+"&#160;&#160;&#160;&#160;")
                        .append("<a href='<%=basePath%>/newspages/topic?tid="+data[i].tid+"&tname="+data[i].tname+"'>修改</a>")
                        .append(" &#160;&#160;&#160;&#160;<a href='<%=basePath%>/topic?opr=del&tid="+data[i].tid+"'>删除</a>")
                        .append("</li>");
                    $(".classlist").append("<li>&#160;&#160;&#160;&#160;"+data[i].tname+"&#160;&#160;&#160;&#160;<a href='<%=basePath%>/newspages/topic?tid="+data[i].tid+"&tname="+data[i].tname+"'>修改</a>&#160;&#160;&#160;&#160;<a href='<%=basePath%>/topic?opr=del&tid="+data[i].tid+"'>删除</a></li>");
                }--%>
                $.each(data,function (i,item) {
                    <%--$(".classlist").append("<li>&#160;&#160;&#160;&#160;"+data[i].tname+"&#160;&#160;&#160;&#160;<a href='<%=basePath%>/newspages/topic?tid="+data[i].tid+"&tname="+data[i].tname+"'>修改</a>&#160;&#160;&#160;&#160;<a href='<%=basePath%>/topic?opr=del&tid="+data[i].tid+"'>删除</a></li>");--%>
                    $(".classlist").append("<li>&#160;&#160;&#160;&#160;"+item.tname+"&#160;&#160;&#160;&#160;<a href='<%=basePath%>/newspages/topic?tid="+item.tid+"&tname="+item.tname+"'>修改</a>&#160;&#160;&#160;&#160;<a href='<%=basePath%>/topic?opr=del&tid="+item.tid+"'>删除</a></li>");
                })
            }
        </script>
</body>
</html>
