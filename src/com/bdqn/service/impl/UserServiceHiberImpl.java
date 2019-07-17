package com.bdqn.service.impl;

import com.bdqn.dao.UserDao;
import com.bdqn.dao.impl.HibernateUserDaoImpl;
import com.bdqn.entity.News_User;
import com.bdqn.service.UserService;
import com.bdqn.utils.Pager;

import java.sql.SQLException;

/**
 * @ClassName: com.bdqn.service.impl.UserServiceHiberImpl
 * @Description: 用户业务实现类（Hibernate）
 * @Author:      Administrator
 * @CreateDate: 2019/6/1 0001 下午 5:59
 * @UpdateUser:   Administrator
 * @Version:        1.0
 **/
public class UserServiceHiberImpl implements UserService{

    private UserDao userDao;
    public UserServiceHiberImpl() {
        userDao = new HibernateUserDaoImpl();
    }

    @Override
    public boolean login(News_User user) throws SQLException {
        return false;
    }

    @Override
    public Pager<News_User> findUsersBySubList(News_User searchModel, int pageNum, int pageSize)  {
        return userDao.findUsersPaged(searchModel,pageNum,pageSize);
    }
}
