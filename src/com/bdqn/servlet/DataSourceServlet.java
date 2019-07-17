package com.bdqn.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DataSourceServlet",urlPatterns = "/dataSource")
public class DataSourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据源对象,通过ServletContext对象中的getAttribute()方法获取其中存放的数据源
        ServletContext servletContext=this.getServletContext();
        DataSource dataSource= (DataSource) servletContext.getAttribute("ds");
        System.out.println(dataSource);//后台打印出数据源对象
        PrintWriter out = response.getWriter();
        out.println(dataSource);//前台打印出数据源对象
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
