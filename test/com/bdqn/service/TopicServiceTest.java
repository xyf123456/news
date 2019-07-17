package com.bdqn.service;

import com.bdqn.entity.Topic;
import com.bdqn.service.impl.TopicServiceImpl;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TopicServiceTest {
    Logger logger = Logger.getLogger(TopicServiceTest.class);

    TopicService topicService = null;
    @Before
    public void setUp() throws Exception {
        topicService = new TopicServiceImpl();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAllTopics() throws Exception {
        List<Topic> list =  topicService.findAllTopics();
        for (Topic top:
             list) {
            logger.info(top.getTid());
            logger.info(top.getTname());
        }
    }

}