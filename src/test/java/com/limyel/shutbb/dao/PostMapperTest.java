package com.limyel.shutbb.dao;

import com.limyel.shutbb.dto.PostExecution;
import com.limyel.shutbb.dto.TopicExecution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring.xml")
public class PostMapperTest {

    @Autowired
    private PostMapper postMapper;

    @Test
    public void selectExecutionByTopicId() {
        long topicId = 10456627235841L;

        List<PostExecution> result = postMapper.selectExecutionByTopicId(topicId);
        for (PostExecution postExecution: result) {
            System.out.println(postExecution.getTarget());
        }
    }
}