package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring.xml")
public class TestTopicDao {
    private TopicDao topicDao;

    @Autowired
    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    @Test
    public void testRetriveById() {
        Topic topic = topicDao.retriveById(1);
        System.out.println(topic.getUser().getUsername());
        System.out.println(topic.getSection().getName());
    }
}
