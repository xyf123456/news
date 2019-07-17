<%@ page import="java.util.List" %>
<%@ page import="com.bdqn.entity.Topic" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/4 0004
  Time: 下午 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    List<Topic> list = (List<Topic>) session.getAttribute("list");
%>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            margin: 0;
            padding:0;
        }
        table{
            border: 1px solid #000000;
        }
        table tr{
            border: 1px solid #ad19b6;
        }
        table td{
            border: 1px solid #ad19b6;
        }
    </style>
</head>
<body>
<div>
    <table>
        <tr>
            <th>主题id</th>
            <th>主题名称</th>
        </tr>
        <c:forEach items="${sessionScope.list}" var="topic">
            <tr>
                <td>${topic.tid}</td>
                <td>${topic.tname}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <select name="" id="">
        <%--<%
            for (Topic top:
                 list) {
                 %><option value="${sessionScope.top.tid}">${sessionScope.top.tname}</option><%
            }
        %>--%>
        <c:forEach items="${sessionScope.list}" var="topic">
            <c:if test="${topic.tid%2==0}">
                <%--<option value="${topic.tid}">${topic.tname}</option>--%>
                <option value="${topic.tid}"><c:out value="${topic.tname}"/></option>
            </c:if>
        </c:forEach>
    </select>
</div>


</body>
</html>
