package com.bdqn.dao;

import com.bdqn.entity.Topic;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: TopicDao
 * @Description: 主题DAO接口
 * @Author: xyf
 * @Date 2019/5/28 0028 下午 12:25
 */
public interface TopicDao {

    /**
     * @Description:
     * @param: []
     * @return: java.util.List<com.bdqn.entity.Topic>
     * @Date: 2019/05/28 下午 12:28
     */
    List<Topic> getAllTopics() throws SQLException;

    /**
     * @Description：删除主题方法
     * @param: [tid]
     * @return: java.lang.Integer
     * @Date: 2019/05/29 上午 11:49
     */
    Integer delTopic(Integer tid) throws SQLException;

    /**
     * @Description: 通过id更新主题
     * @param: [tid, tname]
     * @return: java.lang.Integer
     * @Date: 2019/05/30 上午 11:41
     */
    Integer updateTopic(String tid, String tname)throws SQLException;

    /**
     * @Description: 通过主题查找主题
     * @param: [tname]
     * @return: java.lang.Integer
     * @Date: 2019/05/30 上午 11:42
     */
    Integer findTopicByName(String tname)throws SQLException;

    /**
     * @Description: 添加主题名称
     * @param: [tname]
     * @return: java.lang.Integer
     * @Date: 2019/05/30 上午 11:42
     */
    Integer addTopic(String tname) throws SQLException;
}
