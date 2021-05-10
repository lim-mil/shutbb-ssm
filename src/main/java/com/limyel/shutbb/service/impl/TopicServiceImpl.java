package com.limyel.shutbb.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dao.PostDao;
import com.limyel.shutbb.dao.TopicDao;
import com.limyel.shutbb.dto.TopicShort;
import com.limyel.shutbb.entity.Topic;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.TopicService;
import com.limyel.shutbb.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    private TopicDao topicDao;
    private PostDao postDao;

    @Autowired
    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    @Autowired
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public Response<Integer> create(Topic topic) {
        int result = topicDao.create(topic);
        if (result == 0) {
            return Response.badRequest(result);
        }
        return Response.success("发布成功", topic.getId());
    }

    @Override
    public Response<Topic> retriveById(int id) {
        Topic topic = topicDao.retriveById(id);
        return Response.success(topic);
    }

    @Override
    public Response<List<Topic>> retriveBySection(int sectionId) {
        List<Topic> result = topicDao.retriveBySection(sectionId);
        return Response.success(result);
    }

    @Override
    public Response<PageInfo<TopicShort>> retriveBySectionName(String sectionName, int page, int pageSize) {
        Page objectPage = PageHelper.startPage(page, pageSize);
        List<Topic> topics = topicDao.retriveBySectionName(sectionName);
        PageInfo<Topic> pageInfo = new PageInfo<>(topics);
        List<TopicShort> topicShorts = new LinkedList<>();
        for (Topic topic: pageInfo.getList()) {
            TopicShort topicShort = new TopicShort();
            topicShort.setTopic(topic);
            topicShort.setPostNum(postDao.countByTopic(topic.getId()));
            topicShort.setLatestPost(postDao.retriveLatest(topic.getId()));
            topicShorts.add(topicShort);
        }
        PageInfo<TopicShort> result = PageUtil.convert(pageInfo, topicShorts);
        return Response.success(result);
    }

    @Override
    public Response<List<Topic>> retriveByUser(int userId) {
        List<Topic> result = topicDao.retriveByUser(userId);
        return Response.success(result);
    }

    @Override
    public Response<List<Topic>> retriveDraft(int userId) {
        List<Topic> result = topicDao.retriveDraft(userId);
        return Response.success(result);
    }

    @Override
    public Response<Integer> update(Topic topic) {
        return null;
    }

    @Override
    public Response<Integer> deleteById(int id, User user) {
        int result = topicDao.deleteById(id, user);
        if (result == 0) {
            return Response.badRequest(result);
        }
        return Response.success(result);
    }
}
