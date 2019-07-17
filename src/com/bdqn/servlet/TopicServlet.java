package com.bdqn.servlet;

import com.alibaba.fastjson.JSON;
import com.bdqn.entity.Topic;
import com.bdqn.service.TopicService;
import com.bdqn.service.impl.TopicServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TopicServlet", urlPatterns = "/topic")
public class TopicServlet extends HttpServlet implements Serializable {

    private static final long serialVersionUID = -2366223771581741670L;
    private TopicService topicService = new TopicServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opt = request.getParameter("opr");
        if (opt.equals("topicList")) {//加载主题列表
            List<Topic> list = null;
            try {
                list = topicService.findAllTopics();
            } catch (SQLException e) {
                e.printStackTrace();
            }
//            设置相应的配置
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("text/html;charset=utf-8");
            //            将list转换成JSON数据
            String result=JSON.toJSONString(list);
            PrintWriter out = response.getWriter();
            out.println(result);
            out.flush();
            out.close();
//            request.setAttribute("list", list);//存放到session
            //转发跳转到主题列表页面
//            request.getRequestDispatcher("newspages/topic/topic_list.jsp").forward(request, response);
        } else if (opt.equals("topAddView")) {//跳转到添加主题页面
        //转发跳转到添加主题页面
            request.getRequestDispatcher("newspages/topic/topic_add.jsp").forward(request, response);
        } else if (opt.equals("add")) {//实现添加
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
        } else if (opt.equals("topicUpdateView")) {//跳转到修改主题页面

        } else if (opt.equals("topicUpdate")) {//实现修改

        } else if (opt.equals("del")) {//实现删除
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
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
