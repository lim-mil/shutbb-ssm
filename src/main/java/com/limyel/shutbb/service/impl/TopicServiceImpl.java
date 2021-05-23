package com.limyel.shutbb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dao.PostMapper;
import com.limyel.shutbb.dao.TopicMapper;
import com.limyel.shutbb.dto.PostExecution;
import com.limyel.shutbb.dto.TopicExecution;
import com.limyel.shutbb.entity.Topic;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.TopicService;
import com.limyel.shutbb.util.MiniSnow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicMapper topicMapper;

    @Autowired
    PostMapper postMapper;

    @Autowired
    MiniSnow miniSnow;

    @Override
    public Response<Long> create(Topic topic) {
        topic.setId(miniSnow.nextId());
        topicMapper.insertSelective(topic);
        return Response.success("创建成功", topic.getId());
    }

    @Override
    public Response<List<Topic>> retriveBySection(Long SectionId) {
        return null;
    }

    @Override
    public Response<PageInfo<TopicExecution>> retriveBySectionName(String sectionName, int page, int pageSize) {
        return null;
    }

    @Override
    public Response<List<Topic>> retriveByUser(Long userId) {
        List<Topic> result = topicMapper.selectByUserId(userId);
        return Response.success(result);
    }

    @Override
    public Response<List<Topic>> retriveDraft(Long userId) {
        return null;
    }

    @Override
    public Response<Integer> update(Topic topic) {
        return null;
    }

    @Override
    public Response<Integer> deleteById(Long id, User user) {
        return null;
    }

    @Override
    public Response<PageInfo<TopicExecution>> selectBySectionId(Topic topic, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<TopicExecution> topics = topicMapper.selectExecutionSelective(topic);
        PageInfo<TopicExecution> pageInfo = new PageInfo<>(topics);
        getLatestPost(pageInfo.getList());
        return Response.success(pageInfo);
    }

    @Override
    public Response<PageInfo<TopicExecution>> select(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<TopicExecution> result = topicMapper.selectExecutionSelective(null);
        PageInfo<TopicExecution> pageInfo = new PageInfo<>(result);
//        for (TopicExecution topicExecution: pageInfo.getList()) {
//            PostExecution latestPost = postMapper.selectLatestByTopicId(topicExecution.getId());
//            topicExecution.setLatestPost(latestPost);
//        }
        getLatestPost(pageInfo.getList());
        return Response.success(pageInfo);
    }

    private void getLatestPost(List<TopicExecution> topics) {
        for (TopicExecution topicExecution: topics) {
            PostExecution latestPost = postMapper.selectLatestByTopicId(topicExecution.getId());
            topicExecution.setLatestPost(latestPost);
        }
    }

    @Override
    public Response<TopicExecution> retriveById(long topicId) {
        TopicExecution result = topicMapper.selectExecutionByPrimaryKey(topicId);
        return Response.success(result);
    }
}
