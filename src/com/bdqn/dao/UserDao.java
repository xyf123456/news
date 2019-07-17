package com.bdqn.dao;

import com.bdqn.entity.News_User;
import com.bdqn.utils.Pager;
import org.omg.CORBA.Object;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName: UserDao
 * @Description: 用户DAO接口
 * @Author: xyf
 * @Date 2019/5/28 0028 上午 10:56
 */
public interface UserDao{

    /**
     * @Description: 查询到用户
     * @param: [user]
     * @return: com.bdqn.entity.News_User
     * @Date: 2019/05/28 上午 11:02
     */
    News_User selectUser(News_User user) throws SQLException;

    /**
     * @Description: 查找到分页后的用户数据
     * @param: [searchModel, pageNum, pageSize]
     * @return: com.bdqn.utils.Pager<com.bdqn.entity.News_User>
     * @Date: 2019/05/30 上午 9:49
     */
    Pager<News_User> findUsersPaged(News_User searchModel, int pageNum, int pageSize);

    /**
     * @Description: 查询到所有用户数据
     * @param: [searchModel] 根据不同的业务模式
     * @return: java.util.List<org.apache.catalina.User>
     * @Date: 2019/05/30 上午 9:53
     */
    List<News_User> findUsers(News_User searchModel)throws SQLException;
}
