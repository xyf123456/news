package com.bdqn.servlet;

import com.alibaba.fastjson.JSON;
import com.bdqn.entity.News_User;
import com.bdqn.service.UserService;
import com.bdqn.service.impl.UserServiceHiberImpl;
import com.bdqn.utils.Constant;
import com.bdqn.utils.Pager;
import com.bdqn.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
/**
 * @ClassName: HibernateDataServlet
 * @Description:
 * @Author: xyf
 * @Date 2019/6/4 0004 上午 8:31
 *  * Servlet是在服务器端运行的小程序，一个Servlet就是一个JAVA类，
 * 并且可以通过“请求-响应”编程模型来访问这个驻留在服务器内存的
 * 的Servlet程序。
 * loadOnStartup设置。设置大于0的值(默认值为-1)，表示启动应用程序后
 * 就要初始化Servlet(而不是实例化几个Servlet)。数字代表了Servlet的
 * 初始顺序，容器必须保证有较小数字的Servlet先初始化，在使用标注的
 * 情况下，如果有多个Servlet在设置loadOnStartup时使用了相同的数字，
 * 则容器实现厂商可以自行决定要如何载入哪个Servlet。
 *
 * Servlet的生命周期：
 * 1、Servlet容器启动时，会自动装载某些Servlet,实现它需要在web.xml文件中配置
 *  <load-on-startup>2</load-on-startup>;Servlet3.0以后通过注解即可实现，
 *  loadOnStartup = 1，代表优先级；
 *  2、当客户端首次向Servlet发送请求时，Tomcat容器也会装载Servlet，首次启动运行缓慢；
 *  3、Servlet类被重写修改后，Tomcat容器也会重新装载Servlet；
 *  4、Servlet容器创建一Servlet实例，并且调用Servlet的init()方法进行初始化；在Servlet
 *  整个生命周期，init()方法只会被调用一次；
 */
@WebServlet(name = "HibernateDataServlet",urlPatterns = {"/userData"},loadOnStartup = 1)
public class HibernateDataServlet extends HttpServlet {
    private UserService userService = new UserServiceHiberImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收request里的参数
        String userName = request.getParameter("userName"); //用户名称
        // 获取用户性别
        int gender = Constant.DEFAULT_GENDER;
        String genderStr = request.getParameter("gender");
        if(genderStr!=null && !"".equals(genderStr.trim())){
            gender = Integer.parseInt(genderStr);
        }
        // 校验pageNum参数输入合法性
        String pageNumStr = request.getParameter("pageNum");
        if(pageNumStr !=null && !StringUtil.isNum(pageNumStr)){
            request.setAttribute("errorMsg", "参数传输错误");
            request.getRequestDispatcher("hibernateUserJquery.jsp").forward(request, response);
            return;
        }
        int pageNum = Constant.DEFAULT_PAGE_NUM; //显示第几页数据
        if(pageNumStr!=null && !"".equals(pageNumStr.trim())){
            pageNum = Integer.parseInt(pageNumStr);
        }
        int pageSize = Constant.DEFAULT_PAGE_SIZE;  // 每页显示多少条记录
        String pageSizeStr = request.getParameter("pageSize");
        if(pageSizeStr!=null && !"".equals(pageSizeStr.trim())){
            pageSize = Integer.parseInt(pageSizeStr);
        }
        News_User searchModel = new News_User();
        searchModel.setuName(userName);
        searchModel.setGender(gender);

        //调用service 获取查询结果
        Pager<News_User> result=userService.findUsersBySubList(searchModel,pageNum,pageSize);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("text/html;charset=utf-8");

        String responseStr = JSON.toJSONString(result);
        Writer writer = response.getWriter();
        writer.write(responseStr);
        writer.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
