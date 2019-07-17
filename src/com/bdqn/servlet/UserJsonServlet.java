package com.bdqn.servlet;

import com.alibaba.fastjson.JSON;
import com.bdqn.entity.News_User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserJsonServlet",urlPatterns = "/userJson")
public class UserJsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        News_User news_user = new News_User("张三","1213345");

        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("text/html;charset=utf-8");

        String result = JSON.toJSONString(news_user);
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }
}
