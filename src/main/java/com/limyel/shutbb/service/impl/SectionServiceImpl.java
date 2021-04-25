package com.limyel.shutbb.service.impl;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dao.PostDao;
import com.limyel.shutbb.dao.SectionDao;
import com.limyel.shutbb.dao.TopicDao;
import com.limyel.shutbb.dto.SectionShort;
import com.limyel.shutbb.dto.TopicShort;
import com.limyel.shutbb.entity.Post;
import com.limyel.shutbb.entity.Section;
import com.limyel.shutbb.entity.Topic;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {
    private SectionDao sectionDao;
    private PostDao postDao;

    @Autowired
    public void setSectionDao(SectionDao sectionDao) {
        this.sectionDao = sectionDao;
    }

    @Autowired
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public Response<Integer> create(Section section) {
        int result = sectionDao.create(section);
        return Response.success(result);
    }

    @Override
    public Response<Section> retriveById(int id) {
        return null;
    }

    @Override
    public Response<List<SectionShort>> retriveByUser(User user) {
        List<SectionShort> result = new ArrayList<>();
        List<Section> sections = sectionDao.retriveByUser(user.getId());

        for (Section section: sections) {           // 构建模块信息
            SectionShort sectionShort = new SectionShort();
            sectionShort.setSection(section);
            List<TopicShort> topicShorts = new ArrayList<>();
            for (Topic topic: section.getTopics()) {            // 构建主题信息
                int postNum = postDao.countByTopic(topic.getId());
                Post latestPost = topic.getPosts().get(topic.getPosts().size()-1);
                topicShorts.add(new TopicShort(topic, postNum, latestPost));
                if (topicShorts.size() >= 15)           // 首页的版块默认带 15 个最新的话题
                    break;
            }
            sectionShort.setTopics(topicShorts);
            int topicNum = section.getTopics().size();
            sectionShort.setTopicNum(topicNum);
            result.add(sectionShort);
        }

        return Response.success(result);
    }

    @Override
    public Response<List<SectionShort>> retriveDefault() {

        return null;
    }


    @Override
    public Response<Integer> update(Section section) {
        return null;
    }

    @Override
    public Response<Integer> deleteById(int id) {
        return null;
    }

}
