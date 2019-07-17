package com.bdqn.servlet;

import com.alibaba.fastjson.JSON;
import com.bdqn.entity.News;
import com.bdqn.service.NewsService;
import com.bdqn.service.impl.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "NewsServlet",urlPatterns = "/news")
public class NewsServlet extends HttpServlet {
    private static final long serialVersionUID = -6863825016611736904L;

    private NewsService newsService = new NewsServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //过滤字符集
        //加载所有新闻信息的业务
        List<News> list=newsService.findNewsForAdmin();
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("text/html;charset=utf-8");
        //得到所有新闻的信息后将其解析成相应的JSON格式的数据,引入第三方解析工具
//        String result=JSON.toJSONString(list);
        String result=JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd HH:mm:ss");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();

    }
}
