package com.bdqn.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @ClassName: com.bdqn.servlet.HibernateServlet
 * @Description: 只是跳转的功能
 * @Author:      Administrator
 * @CreateDate: 2019/6/1 0001 下午 6:04
 * @UpdateUser:   Administrator
 * @Version:        1.0
 **/
@WebServlet(name = "HibernateServlet")
public class HibernateServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //负责跳转页面
        request.getRequestDispatcher("hibernateUserJquery.jsp").forward(request, response);
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
