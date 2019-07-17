package com.bdqn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
      /*  String username = request.getParameter("username");
        boolean flag = false;
        if (username.equals("ajax")){
            flag = true;//代表该用户名已经存在
        }
        //将相应信息发送给客户端
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = respons e.getWriter();
        out.println(flag);
        out.flush();//刷新缓冲器
        out.close();//关闭PrintWriter对象*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
        //过滤字符集
        String username = request.getParameter("username");
        boolean flag = false;
        if (username.equals("ajax")){
            flag = true;//代表该用户名已经存在
        }
        //将相应信息发送给客户端
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(flag);
        out.flush();//刷新缓冲器
        out.close();//关闭PrintWriter对象

    }
}
