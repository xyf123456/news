package com.bdqn.utils;

import org.hibernate.Query;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Map;

/**
 * @ClassName: com.bdqn.utils.DatabaseUtil
 * @Description: 数据库连接工具类
 * @Author: Administrator
 * @CreateDate: 2019/5/26 0026 下午 8:53
 * @UpdateUser: Administrator
 * @Version: 1.0
 **/
public class DatabaseUtil {

    /**
     * @Description: 获取数据库连接对象
     * @param: []
     * @return: java.sql.Connection
     * @Date: 2019/05/22 下午 2:17
     */
    public static Connection getConnection(){
        Connection connection = null;
        String driver = ConfigManager.getInstance().getString("jdbc_driver");
        String url = ConfigManager.getInstance().getString("jdbc_url");
        String username = ConfigManager.getInstance().getString("jdbc_user");
        String password = ConfigManager.getInstance().getString("jdbc_password");
        try {
            Class.forName(driver);//加载驱动
            //2、使用DriverManager类获取数据库的连接
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("数据库连接成功！");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * @Description: 获取数据库连接
     * @param: []
     * @return: java.sql.Connection
     * @Date: 2019/05/24 下午 2:04
     */
    public static Connection getConnection2() {
        Connection connection = null;
        try {
            //初始化上下文
            Context cxt = new InitialContext();
            //获取与逻辑名相关联的数据源对象
//            DataSource ds=(DataSource)cxt.lookup("java:comp/env/jdbc/news");
            DataSource ds = (DataSource) cxt.lookup("java:comp/env/jdbc/demo");
            connection = ds.getConnection();
            System.out.println("数据库连接成功！");
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            return null;
        }
        return connection;
    }

    /**
     * @Description: 关闭数据库的操作
     * @param: []
     * @return: void
     * @Date: 2019/05/22 下午 2:39
     */
    public static void closeAll(Connection conn, PreparedStatement stmt, ResultSet rs) {
        // 若结果集对象不为空，则关闭
        try {
            if (rs != null && !rs.isClosed())
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 若Statement对象不为空，则关闭
        try {
            if (stmt != null && !stmt.isClosed())
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 若数据库连接对象不为空，则关闭
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param paramMap
     * @ Description:设置hql语句的参数
     * @params: * @param query
     * @return:org.hibernate.Query
     **/
    public static Query setQueryParams(Query query, Map<String, Object> paramMap) {

        if (paramMap != null && !paramMap.isEmpty()) {
            for (Map.Entry<String, Object> param : paramMap.entrySet()) {
                query.setParameter(param.getKey(), param.getValue());
            }
        }
        return query;
    }
}
