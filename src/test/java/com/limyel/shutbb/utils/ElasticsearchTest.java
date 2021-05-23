package com.limyel.shutbb.utils;

import com.limyel.shutbb.es.TopicEs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring.xml")
public class ElasticsearchTest {
    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    public void test() {
        TopicEs topicEs = new TopicEs();
        topicEs.setId(10456627235841L);
        topicEs.setDeleted(false);
        topicEs.setDraft(false);
        topicEs.setTitle("qqq");
        topicEs.setContent("qqq");
        topicEs.setUserId(3859376860161L);
        topicEs.setSectionId(3859376860164L);

        IndexCoordinates indexCoordinates = elasticsearchRestTemplate.getIndexCoordinatesFor(topicEs.getClass());
        IndexQuery indexQuery = new IndexQueryBuilder().withObject(topicEs).build();
        elasticsearchRestTemplate.index(indexQuery, indexCoordinates);
    }

}
