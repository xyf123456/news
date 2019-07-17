package com.bdqn.service;

import com.bdqn.dao.NewsDaoTest;
import com.bdqn.entity.News;
import com.bdqn.service.impl.NewsServiceImpl;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class NewsServiceTest {
    private Logger logger = Logger.getLogger(this.getClass());
    private NewsService newsService =null;
    @Before
    public void setUp() throws Exception {
        newsService = new NewsServiceImpl();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findNewsForAdmin() throws Exception {
        List<News> list =  newsService.findNewsForAdmin();
        for (News ne:
                list) {
            logger.debug(ne);
        }
    }

}