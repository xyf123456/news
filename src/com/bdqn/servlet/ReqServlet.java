package com.bdqn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @ClassName: ReqServlet
 * @Description:  只负责跳转到查询页面
 * @Author: xyf
 * @Date 2019/6/4 0004 下午 5:18
 */
@WebServlet(name = "ReqServlet",urlPatterns = "/findTopicList",
        initParams = {@WebInitParam(name = "name",value = "admin"),@WebInitParam(name = "pwd",value = "123456")})
public class ReqServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("test/test1.jsp").forward(request,response);
    }
}
