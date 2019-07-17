package com.bdqn.service.impl;

import com.bdqn.dao.NewsDao;
import com.bdqn.dao.impl.NewsDaoImpl;
import com.bdqn.entity.News;
import com.bdqn.service.NewsService;
import com.bdqn.utils.DatabaseUtil;

import java.sql.Connection;
import java.util.List;

/**
 * @ClassName: NewsServiceImpl
 * @Description: 新闻业务接口实现类
 * @Author: xyf
 * @Date 2019/6/11 0011 上午 10:49
            */
    public class NewsServiceImpl implements NewsService{

    private NewsDao newsDao;
    public NewsServiceImpl() {//构造注入
        Connection connection = null;
//        connection = DatabaseUtil.getConnection2();//JNDI 方式
        connection = DatabaseUtil.getConnection();//JNDI 方式
        newsDao = new NewsDaoImpl(connection);
    }

        @Override
    public List<News> findNewsForAdmin() {

        return newsDao.selectNewsForAdmin();
    }
}
