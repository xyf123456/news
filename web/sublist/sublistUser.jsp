<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户信息</title>
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
</head>
<%
    // 获取请求的上下文
    String context = request.getContextPath();
%>
<script type="text/javascript">
    // 当前第几页数据
    var currentPage = ${result.currentPage};
    // 总页数
    var totalPage = ${result.totalPage};

    /**
     *  提交表单
     * @param actionUrl
     */
    function submitForm(actionUrl) {
        var formElement = document.getElementById("stuForm");
        formElement.action = actionUrl;
        formElement.submit();
    }

    // 第一页
    function firstPage() {
        if (currentPage === 1) {
            alert("已经是第一页数据");
            return false;
        } else {
            submitForm("<%=context %>/sublist/SublistServlet?pageNum=1");
            return true;
        }
    }

    // 下一页
    function nextPage() {
        if (currentPage === totalPage) {
            alert("已经是最后一页数据");
            return false;
        } else {
            submitForm("<%=context %>/sublist/SublistServlet?pageNum=" + (currentPage + 1));
            return true;
        }
    }

    // 上一页
    function previousPage() {
        if (currentPage === 1) {
            alert("已经是第一页数据");
            return false;
        } else {
            submitForm("<%=context %>/sublist/SublistServlet?pageNum=" + (currentPage - 1));
            return true;
        }
    }

    // 尾页
    function lastPage() {
        if (currentPage === totalPage) {
            alert("已经是最后一页数据");
            return false;
        } else {
            submitForm("<%=context %>/sublist/SublistServlet?pageNum=${result.totalPage}");
            return true;
        }
    }

    /**
     * 初始化页面
     */
    function initPage() {
        var genderRequest = "${gender}";
        var genderVal = 0;
        var genderElement = document.getElementById("gender");
        if (genderRequest != "") {
            genderVal = parseInt(genderRequest);
        }
        var options = genderElement.options;
        var i = 0;
        for (i = 0; i < options.length; i++) {
            if (options[i].value == genderVal) {
                options[i].selected = true;
                break;
            }
        }

    }
</script>
<body onload="initPage();">
<%--<body>--%>
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
                    <td><c:out value="${user.uId }"></c:out></td>
                    <td><c:out value="${user.uName }"></c:out></td>
                    <td><c:out value="${user.uPwd }"></c:out></td>
                    <td>
                        <c:if test="${ user.gender eq 1}">男</c:if>
                        <c:if test="${ user.gender eq 2}">女</c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br> 共${result.totalRecord }条记录共${result.totalPage }页&nbsp;&nbsp;当前第${result.currentPage }页&nbsp;&nbsp;
        <a href="#" onclick="firstPage();">首页</a>&nbsp;&nbsp;
        <a href="#" id="xia" onclick="nextPage();">下一页</a>&nbsp;&nbsp;
        <a href="#" id="shang" onclick="previousPage();">上一页</a>&nbsp;&nbsp;
        <a href="#" onclick="lastPage();">尾页</a>
    </c:if>
</div>
</body>
</html>