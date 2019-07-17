package com.bdqn.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

/**
 * @ClassName: FirstListener
 * @Description: 第一个监听器
 * @Author: xyf
 * @Date 2019/6/5 0005 下午 5:03
 */
@WebListener()
public class FirstListener implements ServletContextListener,ServletContextAttributeListener,
        HttpSessionListener, HttpSessionAttributeListener,HttpSessionBindingListener,HttpSessionIdListener,HttpSessionActivationListener,
        ServletRequestListener,ServletRequestAttributeListener{

    // Public constructor is required by servlet spec
    public FirstListener() {
//        System.out.println("FirstListener无参构造方法执行了");
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
//        System.out.println("contextInitialized()方法执行了");
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
//        System.out.println("contextDestroyed()方法执行了");
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
//        System.out.println("sessionCreated()方法执行了");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
//        System.out.println("sessionDestroyed()方法执行了");
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
//        System.out.println("attributeAdded()方法执行了");
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
//        System.out.println("attributeRemoved()方法执行了");
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
//        System.out.println("attributeReplaced()方法执行了");
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {

    }

    @Override
    public void sessionIdChanged(HttpSessionEvent httpSessionEvent, String s) {

    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }
}
