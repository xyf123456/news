package com.bdqn.dao.impl;

import com.bdqn.dao.TopicDao;
import com.bdqn.entity.Topic;
import com.bdqn.utils.BaseDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TopicDaoImpl
 * @Description: 主题DAO接口的实现类
 * @Author: xyf
 * @Date 2019/5/28 0028 下午 12:25
 */
public class TopicDaoImpl extends BaseDao implements TopicDao {

    public TopicDaoImpl(Connection connection) {
        super(connection);
    }

    /**
     * @Description:
     * @param: []
     * @return: java.util.List<com.bdqn.entity.Topic>
     * @Date: 2019/05/28 下午 12:28
     */
    @Override
    public List<Topic> getAllTopics() throws SQLException {
        ResultSet resultSet = null;
        List<Topic> list = new ArrayList<Topic>();
        // 获取所有主题
        String sql = "select * from `topic`";
        Object params[] = {};

        resultSet = exeQuery(sql, params);
        Topic topic = null;
        while (resultSet.next()) {
            topic = new Topic();
            topic.setTid(resultSet.getInt("tid"));
            topic.setTname(resultSet.getString("tname"));
            list.add(topic);
//                后端测试，查看结果，测试成功后，注释掉
//                System.out.println(topic.toString());
        }
        return list;
    }

    /**
     * @param tid
     * @Description：删除主题方法
     * @param: [tid]
     * @return: java.lang.Integer
     * @Date: 2019/05/29 上午 11:49
     */
    @Override
    public Integer delTopic(Integer tid) throws SQLException {
        int result = -1;
        String sql = "DELETE FROM `topic` where `tid` = ?";
        Object params[] = {tid};
        result=exeUpdate(sql,params);
        return result;
    }

    @Override
    public Integer updateTopic(String tid, String tname) throws SQLException {
        int result = -1;
        String sql = "UPDATE `topic` SET `tname`=? WHERE `tid`=?";
        Object params[] = {tname,tid};
        result=exeUpdate(sql,params);
        return result;
    }

    @Override
    public Integer findTopicByName(String tname) throws SQLException {
        int count = -1;
        ResultSet resultSet = null;
        StringBuffer stringBuffer = new StringBuffer("select `tid` from `topic` where 1=1");
        stringBuffer.append(" AND `tname`=?");
        Object params[] = {tname};
        try{
            resultSet=exeQuery(stringBuffer.toString(),params);
            if (resultSet.next()){
                count = 1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return count;
    }

    /**
     * @param tname
     * @Description: 添加主题名称
     * @param: [tname]
     * @return: java.lang.Integer
     * @Date: 2019/05/30 上午 11:42
     */
    @Override
    public Integer addTopic(String tname) throws SQLException {
        int count = -1;
        StringBuffer stringBuffer = new StringBuffer("INSERT INTO `topic`(`tname`) VALUES(?)");
        Object params[] = {tname};
        count = exeUpdate(stringBuffer.toString(),params);
        return count;
    }
}
