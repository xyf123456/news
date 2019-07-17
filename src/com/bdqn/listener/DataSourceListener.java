package com.bdqn.listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

/**
 * @ClassName: DataSourceListener
 * @Description: 数据源监听器
 * @Author: xyf
 * @Date 2019/6/6 0006 下午 1:41
 */
public class DataSourceListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("DataSourceListener类中 contextInitialized()方法执行了");
        ServletContext servletContext = servletContextEvent.getServletContext();

        //初始化上下文
        try {
            Context context = new InitialContext();
            //获取与逻辑名相关联的数据源对象
            DataSource dataSource= (DataSource) context.lookup("java:comp/env/jdbc/oracle");
//            将数据源DataSource对象保存到ServletContext容器中
            servletContext.setAttribute("ds",dataSource);
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("DataSourceListener类中 contextDestroyed()方法执行了");
    }
}
