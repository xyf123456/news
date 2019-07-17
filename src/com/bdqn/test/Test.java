package com.bdqn.test;

import com.bdqn.dao.UserDao;
import com.bdqn.dao.impl.HibernateUserDaoImpl;
import com.bdqn.dao.impl.UserDaoImpl;
import com.bdqn.entity.News_User;
import com.bdqn.service.UserService;
import com.bdqn.service.impl.UserServiceHiberImpl;
import com.bdqn.service.impl.UserServiceImpl;
import com.bdqn.utils.DatabaseUtil;
import com.bdqn.utils.Pager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        /*Connection connection = DatabaseUtil.getConnection();
        UserDao userDao = new UserDaoImpl(connection);
        News_User user = new News_User();
        List<News_User> list= userDao.findUsers(user);
        for (News_User user1:list){
            System.out.println(user1.toString());
        }*/
//        UserService userService = new UserServiceImpl();
//        News_User user = new News_User();
//        Pager<News_User> pager = userService.findUsersBySubList(user,1,5);
//        System.out.println(pager.getDataList().get(0).getuName());

//        HibernateUserDaoImpl hibernateUserDao = new HibernateUserDaoImpl();
        /*UserServiceHiberImpl userServiceHiber = new UserServiceHiberImpl();
        News_User news_user = new News_User();
        news_user.setGender(1);
        Pager<News_User> list  = userServiceHiber.findUsersBySubList(news_user,1,5);
        for (News_User user1:list.getDataList()){
            System.out.println(user1.toString());
        }*/
        String arr1[] = {"name:王者","name:吃鸡","name:枪神"};
    }
}
