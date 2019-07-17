<%@ page import="com.bdqn.service.TopicService" %>
<%@ page import="com.bdqn.service.impl.TopicServiceImpl" %>
<%@ page import="com.bdqn.entity.Topic" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/28 0028
  Time: 下午 12:01
  To change this template use File | Settings | File Templates.
--%>
<%--动作标签--%>
<%-- <jsp:forward page="topic_list.jsp">
     <jsp:param name="list" value="<%=list%>"/>
 </jsp:forward>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    String opr = request.getParameter("opr");// 取到主题操作（显示主题，添加、删除，修改）
    TopicService topicService = new TopicServiceImpl();
    if (opr.equals("topicList")) {//显示主题全部列表，调用显示主题列表相关的业务
        List<Topic> list = null;
        try {
            list = topicService.findAllTopics();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("list", list);
        //转发

        request.getRequestDispatcher("../topic/topic_list.jsp").forward(request, response);
    } else if (opr.equals("del")) {//删除主题
        String tid = request.getParameter("tid");
        try {
            if (topicService.deleteTopicByTid(Integer.valueOf(tid))) {//删除成功
                response.sendRedirect("newspages/admin.jsp");
            } else {
                response.sendRedirect("newspages/admin.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } else if (opr.equals("update")) {//修改主题
        String tid = request.getParameter("tid");
        String tname = request.getParameter("tname");

        //调用主题修改业务
        try {
            if (topicService.updateTopic(tid, tname) > 0) {
                response.sendRedirect("newspages/admin.jsp");
            } else {
                response.sendRedirect("newspages/admin.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } else if (opr.equals("topAddView")) {//只是负责跳转到添加主题的页面
        //转发添加页面
%>
<jsp:forward page="../topic/topic_add.jsp"/>
<%
        //        request.getRequestDispatcher("topic_add.jsp").forward(request,response);
    } else if (opr.equals("add")) {//添加主题
        String tname = request.getParameter("tname");
        try {
            if (topicService.addToptic(tname) > 0) {
                response.sendRedirect("newspages/admin.jsp");
            } else {
                response.sendRedirect("newspages/admin.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }else if (opr.equals("test")){//用户测试
            List<Topic> list = null;
            try {
                list = topicService.findAllTopics();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            session.setAttribute("list", list);//存放到session
            response.sendRedirect("../../test/topicList.jsp");
    }
%>
