<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户信息</title>
    <link rel="stylesheet" href="../css/pagination.css">
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="../js/jquery.pagination.js"></script>
</head>
<%
    // 获取请求的上下文
    String context = request.getContextPath();
%>
<script type="text/javascript">
    function handlePaginationClick(new_page_index, pagination_container) {
//        new_page_index默认的索引从0开始，而后台提供的数据是从1开始的，所以这里请求页数需要+1
        <%--$("#stuForm").attr("action", "<%=context %>/sublist/SublistServlet?pageNum=" + (new_page_index + 1)).submit();--%>
        $("#stuForm").attr("action", "<%=context %>/sublist/SublistServlet?pageNum=" + (new_page_index+1));
        $("#stuForm").submit();
        return false;
    }
    $(function () {
        //需要一个News-Pagination的容易放分页信息,pagination(共多少条记录，{每页显示的记录数})
        /* $("#News-Pagination").pagination(122, {
             items_per_page: 20,
             callback: handlePaginationClick
         });*/
        $("#News-Pagination").pagination(${requestScope.result.totalRecord}, {
            items_per_page: ${requestScope.result.pageSize},//每页显示的记录数
            current_page: ${requestScope.result.currentPage}-1,//当前显示第几页
            load_first_page:false,
            num_display_entries: 8,//分页的条目数
            next_text: "下一页",//分页显示的文本
            prev_text: "上一页",//分页显示的文本
            num_edge_entries: 2,//连接分页主体，显示的条目数
            callback: handlePaginationClick//回调函数，点击完分页栏后，需要做哪些动作
        });
        //直接通过jquery从request中来取出性别的值
        $("#gender").val("${gender}");
    });
</script>
<body>
<div style="margin-left: 100px; margin-top: 100px;">
    <div>
        <font color="red">${errorMsg }</font>
    </div>
    <div>
        <form action="<%=context %>/sublist/SublistServlet" id="stuForm" method="post">
            姓名
            <input type="text" name="userName" id="stu_name" style="width:120px" value="${userName }">
            &nbsp;
            性别
            <select name="gender" id="gender" style="width:80px">
                <option value="0">全部</option>
                <option value="1">男</option>
                <option value="2">女</option>
            </select>
            &nbsp;&nbsp;
            <input type="submit" value="查询">
        </form>
    </div>
    <br>
    用户信息列表：<br>
    <br>
    <!-- 后台返回结果为空 -->
    <c:if test="${fn:length(result.dataList) eq 0 }">
        <span>查询的结果不存在</span>
    </c:if>

    <!-- 后台返回结果不为空 -->
    <c:if test="${fn:length(result.dataList) gt 0 }">
        <table border="1px" cellspacing="0px"
               style="border-collapse: collapse">
            <thead>
            <tr height="30">
                <th width="130">ID</th>
                <th width="130">姓名</th>
                <th width="130">密码</th>
                <th width="130">性别</th>
            </tr>
            </thead>
            <c:forEach items="${result.dataList }" var="user">
                <tr>
                    <%--<td><c:out value="${user.uId }"></c:out></td>--%>
                    <td><c:out value="${user['uId'] }"></c:out></td>
                    <td><c:out value="${user.uName }"></c:out></td>
                    <td><c:out value="${user.uPwd }"></c:out></td>
                    <td>
                        <c:if test="${ user.gender eq 1}">男</c:if>
                        <c:if test="${ user.gender eq 2}">女</c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div id="News-Pagination">

        </div>
    </c:if>
</div>
</body>
</html>