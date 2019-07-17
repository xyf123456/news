package com.bdqn.servlet;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.apache.taglibs.standard.lang.jstl.test.PageContextImpl;
import org.hibernate.Session;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet",urlPatterns = "/test",initParams ={@WebInitParam(name = "name",value = "admin"),@WebInitParam(name = "pwd",value = "123456")})
public class TestServlet extends HttpServlet {

    Logger logger = Logger.getLogger(this.getClass());
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TestServlet() {
        System.out.println("TestServlet无参数的构造方法执行了。。。");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init()方法执行了");
        name = this.getInitParameter("name");
        password = this.getInitParameter("pwd");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost()方法执行了");
//        doGet(request,response);
       /* String name = request.getParameter("name");
        String pwd = request.getParameter("password");
        logger.debug(name+"——"+password);

        PrintWriter out =response.getWriter();
        out.println("POST方式也成功登录了！");
        out.flush();
        out.close();*/

        ServletInputStream is =request.getInputStream();
        StringBuilder sb  =new StringBuilder();
        int len = 0;
        byte [] buf = new byte[1024];
        while ((len=is.read(buf))!=-1){
            sb.append(new String(buf,0,len,"UTF-8"));
        }
        System.out.println(sb.toString());


        logger.debug(JSON.toJSONString(sb));
        PrintWriter out =response.getWriter();
        out.println("POSTJSON方式也成功登录了！");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet()方法执行了");
//        JSP:out对象
//        PrintWriter writer =response.getWriter();
//        JSP: request
//        service方法中的:request;
//        JSP: response
        //        service方法中的:response;
        //        JSP: session
//        Session session = request.getSession();
        //        JSP: application
//        ServletContext  application=getServletContext();
        //        JSP: exception
//        Throwable exception = new Throwable();
        //        JSP: page
//        this;
        //        JSP: pageContext
//        PageContext pageContext = new PageContextImpl();
        //        JSP: config
//        ServletConfig servletConfig = getServletConfig();

       /* PrintWriter out =response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        out.println("<h2>"+this.getName()+"</h2>");
        out.println("<h2>"+this.getPassword()+"</h2>");
        out.flush();
        out.close();*/
        logger.debug(name+"——"+password);

        PrintWriter out =response.getWriter();
        out.println("成功登录！");
        out.flush();
        out.close();
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy()方法执行了");
    }
}
