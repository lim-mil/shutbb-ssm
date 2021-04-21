package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.Post;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring.xml")
public class TestPostDao {
    @Autowired
    PostDao postDao;

    @Test
    public void testRetriveById() {
        Post post = postDao.retriveById(2);
        System.out.println(post.getUser().getUsername());
        System.out.println(post.getTopic().getTitle());
    }

    @Test
    public void testRetriveByTopic() {
        List<Post> result = postDao.retriveByTopic(1);
        for (Post post: result) {
            System.out.println(post.getContent());

            Assert.assertEquals(1, post.getTopic().getId());
        }
    }

}
