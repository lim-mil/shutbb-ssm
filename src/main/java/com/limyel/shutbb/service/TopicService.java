package com.limyel.shutbb.service;

import com.github.pagehelper.PageInfo;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dto.TopicExecution;
import com.limyel.shutbb.entity.Topic;
import com.limyel.shutbb.entity.User;

import java.util.List;

public interface TopicService {
    Response<Integer> create(Topic topic);
    Response<Topic> retriveById(int id);
    Response<List<Topic>> retriveBySection(int SectionId);
    Response<PageInfo<TopicExecution>> retriveBySectionName(String sectionName, int page, int pageSize);
    Response<List<Topic>> retriveByUser(int userId);
    Response<List<Topic>> retriveDraft(int userId);
    Response<Integer> update(Topic topic);
    Response<Integer> deleteById(int id, User user);

    Response<PageInfo<TopicExecution>> selectBySectionId(Topic topic, int page, int pageSize);
    Response<PageInfo<TopicExecution>> select(int page, int pageSize);
}
