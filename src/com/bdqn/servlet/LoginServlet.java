package com.bdqn.servlet;

import com.bdqn.entity.News_User;
import com.bdqn.service.UserService;
import com.bdqn.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @ClassName: LoginServlet
 * @Description: 负责登录和退出的Servlet
 * @Author: xyf
 * @Date 2019/6/5 0005 下午 1:56
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/loginAndOut", initParams = {@WebInitParam(name = "jdbc_pwd", value = "root")})
public class LoginServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(LoginServlet.class);
    private static final long serialVersionUID = -1271120288494422585L;
    //引入UserService接口，处理用户登录相关的业务
    private UserService userService = new UserServiceImpl();

    public LoginServlet() {
        System.out.println("LoginServlet无参构造方法执行了");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String opr = request.getParameter("opr");
        //获取Servlet容器初始化的一些参数
        String charset=this.getServletConfig().getInitParameter("charset");
//        String pwd = this.getServletConfig().getInitParameter("jdbc_pwd");
        logger.info(charset);
//        logger.info(pwd);
        HttpSession session = null;//空session对象
        if (opr.equals("login")) {//登录处理
            //核心处理的请求的方法
            //获取请求的参数
            String username = request.getParameter("username");
            String upwd = request.getParameter("upwd");

//        构造登录参数
            News_User user = new News_User(username, upwd);
            //处理登录
            try {
                if (userService.login(user)) {//登录成功
                    session=request.getSession();//创建session
                    session.setAttribute("login",username);
                    //重定向到admin.jsp
                    response.sendRedirect("newspages/admin.jsp");
                } else {//登录失败
                    //重定向到index.jsp
                    response.sendRedirect("index.jsp");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (opr.equals("loginOut")) {//退出系统的处理

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //走POST请求
        doPost(request, response);
    }
}
