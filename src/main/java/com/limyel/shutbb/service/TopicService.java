package com.limyel.shutbb.service;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dto.TopicShort;
import com.limyel.shutbb.entity.Topic;
import com.limyel.shutbb.entity.User;

import java.util.List;

public interface TopicService {
    Response<Integer> create(Topic topic);
    Response<Topic> retriveById(int id);
    Response<List<Topic>> retriveBySection(int SectionId);
    Response<List<TopicShort>> retriveBySectionName(String sectionName);
    Response<List<Topic>> retriveByUser(int userId);
    Response<List<Topic>> retriveDraft(int userId);
    Response<Integer> update(Topic topic);
    Response<Integer> deleteById(int id, User user);
}
