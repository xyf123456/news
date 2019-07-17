package com.bdqn.dao.impl;

import com.bdqn.dao.TopicDao;
import com.bdqn.entity.Topic;
import com.bdqn.utils.BaseDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName: TopicDaoOracleImpl
 * @Description: 封装所有有关Oracle语句的操作
 * @Author: xyf
 * @Date 2019/5/30 0030 上午 9:06
 */
public class TopicDaoOracleImpl extends BaseDao implements TopicDao{
    public TopicDaoOracleImpl(Connection connection) {
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
        return null;
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
        return null;
    }

    @Override
    public Integer updateTopic(String tid, String tname) throws SQLException {
        return null;
    }

    /**
     * @param tname
     * @Description: 通过主题查找主题
     * @param: [tname]
     * @return: java.lang.Integer
     * @Date: 2019/05/30 上午 11:42
     */
    @Override
    public Integer findTopicByName(String tname) throws SQLException {
        return null;
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
        return null;
    }

}
