package com.limyel.shutbb.service.impl;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dao.TopicDao;
import com.limyel.shutbb.entity.Topic;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    private TopicDao topicDao;

    @Autowired
    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    @Override
    public Response<Integer> create(Topic topic) {
        int result = topicDao.create(topic);
        if (result == 0) {
            return Response.badRequest(result);
        }
        return Response.success(result);
    }

    @Override
    public Response<Topic> retriveById(int id) {
        return null;
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

    @Override
    public Response<List<Topic>> retriveBySection(int sectionId) {
        List<Topic> result = topicDao.retriveBySection(sectionId);
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
}
