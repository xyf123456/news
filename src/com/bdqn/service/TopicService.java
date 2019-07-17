package com.bdqn.service;

import com.bdqn.entity.Topic;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName: TopicService
 * @Description: 主题业务接口
 * @Author: xyf
 * @Date 2019/5/28 0028 下午 12:21
 */
public interface TopicService {

    /**
     * @Description: 找到所有主题信息
     * @param: []
     * @return: java.util.List<com.bdqn.entity.Topic>
     * @Date: 2019/05/28 下午 12:24
     */
    List<Topic> findAllTopics() throws SQLException;

    /**
     * @Description: 删除主题
     * @param: [tid]
     * @return: boolean
     * @Date: 2019/05/30 上午 9:02
     */
    boolean deleteTopicByTid(Integer tid) throws SQLException;

    /**
     * @Description: 更新主题
     * @param: [tid, tname]
     * @return: java.lang.Integer
     * @Date: 2019/05/30 上午 9:02
     */
    Integer updateTopic(String tid, String tname) throws SQLException;

    /**
     * @Description:添加主题
     * @param: [tname]
     * @return: java.lang.Integer
     * @Date: 2019/05/30 上午 11:27
     */
    Integer addToptic(String tname) throws SQLException;
}
