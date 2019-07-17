package com.bdqn.dao;

import com.bdqn.dao.impl.NewsDaoImpl;
import com.bdqn.entity.News;
import com.bdqn.utils.DatabaseUtil;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

public class NewsDaoTest {

    private Logger logger = Logger.getLogger(NewsDaoTest.class);
    private NewsDao newsDao = null;
    @Before
    public void setUp() throws Exception {
        Connection connection=DatabaseUtil.getConnection();
        newsDao = new NewsDaoImpl(connection);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectNewsForAdmin() throws Exception {
        List<News> list =  newsDao.selectNewsForAdmin();
        for (News ne:
             list) {
            logger.debug(ne);
        }
    }

}