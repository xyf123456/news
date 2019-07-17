package com.bdqn.utils;

import org.hibernate.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BaseDao(JDBC的封装)
 * @Description: 数据库基类
 * @Author: xyf
 * @Date 2019/5/23 0023 下午 3:08
 */
public class BaseDao {

    //全局变量
    protected Connection connection = null;
//    protected  PreparedStatement preparedStatement = null;
//    protected  ResultSet result = null;

    public BaseDao(Connection connection) {
        this.connection = connection;
    }

    /**
     * @Description: 执行增删改的操作
     * @param: [preparedSql, params]
     * @return: int
     * @Date: 2019/05/23 下午 1:43
     */
    public int exeUpdate(String preparedSql, Object params[]) {
        int num = 0;
        PreparedStatement preparedStatement = null;
        try {
//            connection = getConnection();
            //连接数据库(JNDI数据源连接方式连接数据库)
//            connection = getConnection2();
            // 得到要执行SQL语句的PreparedStatement对象
            preparedStatement = connection.prepareStatement(preparedSql);
            //给占位符进行赋值的操作
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }
            //执行SQL语句
            num = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }/*finally {
            DatabaseUtil.closeAll(null,preparedStatement,null);
        }*/
        return num;
    }

    /**
     * @Description:执行查的操作
     * @param: [preparedSql, params]
     * @return: java.sql.ResultSet
     * @Date: 2019/05/23 下午 2:12
     */
    public ResultSet exeQuery(String preparedSql, Object params[]) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //连接数据库
        try {
//            connection=getConnection();
//            connection = getConnection2();//JNDI(JAVA Naming Directory Interface )JAVA命名与目录接口
            preparedStatement = connection.prepareStatement(preparedSql);
            //给站位符赋值
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }/*finally {
            DatabaseUtil.closeAll(null,preparedStatement,null);
        }*/
        return resultSet;
    }

    /**
     * @param params
     * @ Description: 查询数据的结果，并读取出每列数据
     * @params: * @param sql
     * @return:java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     **/
    public List<Map<String, Object>> findResult(String sql, List<?> params)
            throws SQLException {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        int index = 1;
        preparedStatement = connection.prepareStatement(sql);
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                preparedStatement.setObject(index++, params.get(i));
            }
        }
        resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int cols_len = metaData.getColumnCount();
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<String, Object>();
            for (int i = 0; i < cols_len; i++) {
                String cols_name = metaData.getColumnName(i + 1);
                Object cols_value = resultSet.getObject(cols_name);
                if (cols_value == null) {
                    cols_value = "";
                }
                map.put(cols_name, cols_value);
            }
            list.add(map);
        }
        return list;
    }


}
