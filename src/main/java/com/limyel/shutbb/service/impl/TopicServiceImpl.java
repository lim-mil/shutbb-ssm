package com.limyel.shutbb.service.impl;

import com.limyel.shutbb.annotation.IgnoreAuth;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dao.TopicDao;
import com.limyel.shutbb.entity.Topic;
import com.limyel.shutbb.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicDao topicDao;

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
    public Response<Integer> deleteById(int id) {
        return null;
    }
}
