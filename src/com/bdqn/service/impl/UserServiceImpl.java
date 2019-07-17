package com.bdqn.service.impl;

import com.bdqn.dao.impl.UserDaoImpl;
import com.bdqn.dao.UserDao;
import com.bdqn.entity.News_User;
import com.bdqn.service.UserService;
import com.bdqn.utils.DatabaseUtil;
import com.bdqn.utils.Pager;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName: UserServiceImpl
 * @Description: 用户业务接口实现类
 * @Author: xyf
 * @Date 2019/5/28 0028 上午 10:46
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * @param user
     * @Description: 登录
     * @param: [user]
     * @return: boolean
     * @Date: 2019/05/28 上午 10:50
     */
    @Override
    public boolean login(News_User user) throws SQLException {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = DatabaseUtil.getConnection2();
            UserDao userDao = new UserDaoImpl(connection);
            if (userDao.selectUser(user) != null) {
                flag = true;
            }
        } catch (SQLException e) {
            DatabaseUtil.closeAll(connection, null, null);
        }
        return flag;
    }

    /**
     * @param searchModel
     * @param pageNum
     * @param pageSize
     * @Description: //    根据查询条件，查询用户分页信息
     * @param: [searchModel, pageNum, pageSize] [封装查询条件,查询第几页数据,每页显示多少条记录]
     * @return: com.bdqn.utils.Pager<com.bdqn.entity.News_User> 查询结果
     * @Date: 2019/05/30 上午 8:22
     */
    @Override
    public Pager<News_User> findUsersBySubList(News_User searchModel, int pageNum, int pageSize)  {
        Connection connection = null;
        Pager<News_User> result = null;
        try {
            connection = DatabaseUtil.getConnection2();
            UserDao userDao = new UserDaoImpl(connection);
            result = userDao.findUsersPaged(searchModel, pageNum, pageSize);
        } finally {
            DatabaseUtil.closeAll(connection, null, null);
        }
        return result;
    }
}
