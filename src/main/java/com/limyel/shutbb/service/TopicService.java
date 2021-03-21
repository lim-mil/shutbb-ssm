package com.limyel.shutbb.service;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.entity.Topic;

public interface TopicService {
    Response<Integer> create(Topic topic);
    Response<Topic> retriveById(int id);
    Response<Integer> update(Topic topic);
    Response<Integer> deleteById(int id);
}
