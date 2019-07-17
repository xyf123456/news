package com.bdqn.listener;

import com.bdqn.entity.User;
import com.bdqn.utils.SessionUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;
/**
 * @ClassName: MyHttpSessionListener
 * @Description: Session监听器
 * @Author: xyf
 * @Date 2019/6/6 0006 下午 1:11
 */
@WebListener()
public class MyHttpSessionListener implements HttpSessionListener {

    private int userNumber;

    // Public constructor is required by servlet spec
    public MyHttpSessionListener() {
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
        userNumber++;
        se.getSession().getServletContext().setAttribute("userNumber", userNumber);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
        userNumber--;
        se.getSession().getServletContext().setAttribute("userNumber", userNumber);
      /*  ArrayList<User> userList = null;
        userList = (ArrayList<User>) se.getSession().getServletContext().getAttribute("userList");

        if (SessionUtil.getUserBySessionId(userList, se.getSession().getId()) != null) {
            userList.remove(SessionUtil.getUserBySessionId(userList, se.getSession().getId()));
        }*/
    }

}
