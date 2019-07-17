package com.bdqn.service;

import com.bdqn.entity.News_User;
import com.bdqn.utils.Pager;

import java.sql.SQLException;

/**
 * @ClassName: UserService
 * @Description: 用户业务接口
 * @Author: xyf
 * @Date 2019/5/28 0028 上午 10:45
 */
public interface UserService {

    /**
     * @Description: 登录
     * @param: [user]
     * @return: boolean
     * @Date: 2019/05/28 上午 10:50
     */
    boolean login(News_User user) throws SQLException;


    /**
     * @Description: //    根据查询条件，查询用户分页信息
     * @param: [searchModel, pageNum, pageSize] [封装查询条件,查询第几页数据,每页显示多少条记录]
     * @return: com.bdqn.utils.Pager<com.bdqn.entity.News_User> 查询结果
     * @Date: 2019/05/30 上午 8:22
     */
    Pager<News_User> findUsersBySubList(News_User searchModel, int pageNum,
                               int pageSize);
}
