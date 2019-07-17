<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    request.setCharacterEncoding("UTF-8");
    String tname = request.getParameter("tname");
%>
<%--静态包含--%>
<%@include file="/newspages/console_element/top.jsp" %>
<%--动态包含--%>
<%--<jsp:include page="newspages/console_element/top.jsp"/>--%>
<script type="text/javascript" src="<%=basePath%>/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    function check() {
        var tname = document.getElementById("tname");

    if (tname.value === "") {
        alert("请输入主题名称！！");
        tname.focus();
        return false;
    }
    return true;
    }
</script>
<div id="main">
    <%@include file="/newspages/console_element/left.html" %>
    <div id="opt_area">
        <h1 id="opt_type"> 修改主题： </h1>
        <form action="<%=basePath%>/topic_control.jsp?opr=update" method="post" onsubmit="return check()">
            <p>
                <label> 主题名称 </label>
                <input name="tname" type="text" class="opt_input" value="<%=tname %>"/>
                <input name="tid" type="hidden" value="<%=request.getParameter("tid") %>">
            </p>
            <input name="action" type="hidden" value="addtopic">
            <input type="submit" value="提交" class="opt_sub"/>
            <input type="reset" value="重置" class="opt_sub"/>
        </form>
    </div>
</div>
<%@include file="/newspages/console_element/bottom.html" %>
