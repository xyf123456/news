package com.bdqn.servlet;

import com.bdqn.entity.News_User;
import com.bdqn.service.UserService;
import com.bdqn.service.impl.UserServiceImpl;
import com.bdqn.utils.Constant;
import com.bdqn.utils.Pager;
import com.bdqn.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SublistServlet")
public class SublistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收request里的参数（获取用户姓名）
        String userName = request.getParameter("userName");

        //获取用户的性别
        int gender = Constant.DEFAULT_GENDER;
        String genderStr = request.getParameter("gender");
        if (genderStr != null && !(genderStr.trim().equals(""))) {
            gender = Integer.parseInt(genderStr);
        }
        // 校验pageNum参数输入合法性
        String pageNumStr = request.getParameter("pageNum");
        if (pageNumStr != null && !StringUtil.isNum(pageNumStr)) {
            request.setAttribute("errorMsg", "参数传输错误");
            request.getRequestDispatcher("sublistUser.jsp").forward(request, response);
            return;
        }
        int pageNum = Constant.DEFAULT_PAGE_NUM; //显示第几页数据
        if (pageNumStr != null && !"".equals(pageNumStr.trim())) {
            pageNum = Integer.parseInt(pageNumStr);
        }

        int pageSize = Constant.DEFAULT_PAGE_SIZE;  // 每页显示多少条记录
        String pageSizeStr = request.getParameter("pageSize");
        if (pageSizeStr != null && !"".equals(pageSizeStr.trim())) {
            pageSize = Integer.parseInt(pageSizeStr);
        }

        // 组装查询条件
        News_User searchModel = new News_User();
        searchModel.setuName(userName);
        searchModel.setGender(gender);

        //调用service 获取查询结果

            Pager<News_User> result = userService.findUsersBySubList(searchModel, pageNum, pageSize);
            // 返回结果到页面
            request.setAttribute("result", result);
            request.setAttribute("userName", userName);
            request.setAttribute("gender", gender);

//        request.getRequestDispatcher("sublistUser.jsp").forward(request, response);
        request.getRequestDispatcher("sublistUserJquery.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
