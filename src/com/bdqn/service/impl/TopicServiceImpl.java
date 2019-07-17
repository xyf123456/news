package com.bdqn.service.impl;

import com.bdqn.dao.TopicDao;
import com.bdqn.dao.impl.TopicDaoImpl;
import com.bdqn.entity.Topic;
import com.bdqn.service.TopicService;
import com.bdqn.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName: TopicServiceImpl
 * @Description: 主题业务接口实现类
 * @Author: xyf
 * @Date 2019/5/28 0028 下午 12:22
 */
public class TopicServiceImpl implements TopicService {


    private TopicDao topicDao;

    public TopicDao getTopicDao() {
        return topicDao;
    }

    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    /**
     * @Description: 找到所有主题信息
     * @param: []
     * @return: java.util.List<com.bdqn.entity.Topic>
     * @Date: 2019/05/28 下午 12:24
     */
    @Override
    public List<Topic> findAllTopics() throws SQLException {
        Connection connection = null;

        try {
//            connection = DatabaseUtil.getConnection();//JNDI 方式
            connection = DatabaseUtil.getConnection2();//JNDI 方式

            topicDao = new TopicDaoImpl(connection);

            return topicDao.getAllTopics();
        } finally {
            DatabaseUtil.closeAll(connection, null, null);
        }

    }

    @Override
    public boolean deleteTopicByTid(Integer tid) throws SQLException {
        boolean flag = false;
        Connection connection = null;
        connection = DatabaseUtil.getConnection2();//JNDI 方式
        if (connection != null) {
            connection.setAutoCommit(false);//默认不自动提交
        }
        topicDao = new TopicDaoImpl(connection);
        if (topicDao.delTopic(tid) > 0) {
            flag = true;
        }
        if (connection != null) {
            connection.commit();//手动提交
        }
        return flag;
    }

    /**
     * @param tid
     * @param tname
     * @Description: 更新主题
     * @param: [tid, tname]
     * @return: java.lang.Integer
     * @Date: 2019/05/30 上午 9:02
     */
    @Override
    public Integer updateTopic(String tid, String tname) throws SQLException {
        int count = -1;
        Connection connection = null;
        try {
            connection = DatabaseUtil.getConnection2();//JNDI 方式
            connection.setAutoCommit(false);//设置不自动提交
            topicDao = new TopicDaoImpl(connection);
            count = topicDao.updateTopic(tid, tname);
            connection.commit();//手动提交
        } finally {
            DatabaseUtil.closeAll(connection, null, null);
        }
        return count;
    }

    /**
     * @param tname
     * @Description:添加主题
     * @param: [tname]
     * @return: java.lang.Integer
     * @Date: 2019/05/30 上午 11:27
     */
    @Override
    public Integer addToptic(String tname) throws SQLException {
        int count = -1;
        Connection connection = null;
        try {
            connection = DatabaseUtil.getConnection2();//JNDI 方式
            connection.setAutoCommit(false);//设置不自动提交
            topicDao = new TopicDaoImpl(connection);
            if (topicDao.findTopicByName(tname) < 0) {//未找到存在的主题
                count = topicDao.addTopic(tname);//添加主题
            }
            connection.commit();//手动提交
        } finally {
            DatabaseUtil.closeAll(connection, null, null);
        }
        return count;
    }
}
