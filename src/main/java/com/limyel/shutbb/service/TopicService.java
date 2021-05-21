package com.limyel.shutbb.service;

import com.github.pagehelper.PageInfo;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dto.TopicExecution;
import com.limyel.shutbb.entity.Topic;
import com.limyel.shutbb.entity.User;

import java.util.List;

public interface TopicService {
    Response<Integer> create(Topic topic);
    Response<List<Topic>> retriveBySection(Long SectionId);
    Response<PageInfo<TopicExecution>> retriveBySectionName(String sectionName, int page, int pageSize);
    Response<List<Topic>> retriveByUser(Long userId);
    Response<List<Topic>> retriveDraft(Long userId);
    Response<Integer> update(Topic topic);
    Response<Integer> deleteById(Long id, User user);

    Response<PageInfo<TopicExecution>> selectBySectionId(Topic topic, int page, int pageSize);
    Response<PageInfo<TopicExecution>> select(int page, int pageSize);
    Response<TopicExecution> retriveById(long topicId);
}
