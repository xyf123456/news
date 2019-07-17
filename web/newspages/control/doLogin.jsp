<%@ page import="com.bdqn.entity.News_User" %>
<%@ page import="com.bdqn.service.UserService" %>
<%@ page import="com.bdqn.service.impl.UserServiceImpl" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/16 0016
  Time: 下午 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
    request.setCharacterEncoding("UTF-8");
    //获取请求数据,并去除空格
    String name = request.getParameter("username").trim();
    String pwd = request.getParameter("upwd").trim();

    News_User user = new News_User(name,pwd);
    UserService userService = new UserServiceImpl();
    try{
        if (userService.login(user)){
            //设置用户登录信息
            session.setAttribute("login", name);
            //设置session过期时间
            session.setMaxInactiveInterval(10 * 60);
            //转发到admin.jsp
           /* request.getRequestDispatcher("/newspages/admin.jsp")
                    .forward(request, response);*/
            //重定向到admin.jsp
            response.sendRedirect("/news/newspages/admin.jsp");
//            response.sendRedirect("/news/newspages/admin.jsp");
        }else {
            //如果是路径中加了/，必须添加项目的上下文名称news
//            response.sendRedirect("/news/index.jsp");
            //如果是路径中不加/，无需添加项目的上下文名称news
            response.sendRedirect("/news/index.jsp");
        }
    }catch (SQLException e){
        e.printStackTrace();
    }
%>

