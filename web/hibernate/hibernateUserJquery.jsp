<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    // 获取请求的上下文
    String context = request.getContextPath();
%>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户信息</title>
    <link rel="stylesheet" href="../css/pagination.css">
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="../js/jquery.pagination.js"></script>
</head>
<script type="text/javascript">
    var url = "<%=context%>/hibernate/HibernateDataServlet";
    var totalPage = 1;//一共多少页数据
    var pageSize = 30;//每页显示30条数据
    //    第一步：页面渲染后，请求后台，获取用户数据，加载用户信息
    //    第二步：完成用户查询功能
    //    第三步：下拉加载更多数据的功能
    $(function () {
//        请求后台，获取用户数据
        queryUsers();
    });

    //    请求后台，获取用户数据
    function queryUsers() {
        //请求后台之前，做好查询的参数的加载
        var uName = $("#userName").val();//获取用户名称
        var gender = $("#gender").val();//获取用户性别
        //post异步请求
        $.post(url,
            {
                "pageSize": pageSize,
                "userName": uName,
                "gender": gender
            },
            function (data) {
                console.log(data);
                //加载用户信息
                totalPage = data.totalPage;//一共多少页数据
                var userList = data.dataList;//用户数据信息
                if (data.dataList.length===0){
                    $("#emptyInfo").html("暂无数据");
                }
//            加载用户信息
                showUserData(userList);
            }, "json");
    }

    //展示用户数据
    function showUserData(userList) {
        var userDataBodyHtml = "";
//        var male = "男";
//        var female = "女";
        $.each(userList, function (index, object) {
            userDataBodyHtml += "<tr>";
            userDataBodyHtml += "<td>" + object.uId + "</td>";
            userDataBodyHtml += "<td>" + object.uName + "</td>";
            userDataBodyHtml += "<td>" + object.uPwd + "</td>";
            if (object.gender === 1) {
                userDataBodyHtml += "<td>男</td>";
            } else {
                userDataBodyHtml += "<td>女</td>";
            }
            userDataBodyHtml += "</tr>";
        });
        $("#userDataBody").append(userDataBodyHtml);
    }

    //查询功能
    function queryForm() {
        //清空用户数据
        $("#userDataBody").html("");//提示信息也进行清空
        $("#emptyInfo").html("");
        //通过再次请求后台的数据，进行数据的显示
        queryUsers();
    }

</script>
<body>
<div style="margin-left: 100px; margin-top: 100px;">
    <div>
        <font color="red">${errorMsg }</font>
    </div>
    <div>
        <form action="#" id="stuForm" method="post">
            姓名
            <input type="text" name="userName" id="userName" style="width:120px" value="${userName }">
            &nbsp;
            性别
            <select name="gender" id="gender" style="width:80px">
                <option value="0">全部</option>
                <option value="1">男</option>
                <option value="2">女</option>
            </select>
            &nbsp;&nbsp;
            <%--<input type="submit" value="查询">--%>
            <input type="button" id="btn" value="查询" onclick="queryForm();">
        </form>
    </div>
    <br>
    用户信息列表：<br>
    <!-- 后台返回结果不为空 -->

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
        <tbody id="userDataBody">

        </tbody>
    </table>
    <div id="emptyInfo"></div>
    <br>
</div>
</body>
</html>