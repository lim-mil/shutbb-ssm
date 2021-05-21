package com.limyel.shutbb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dao.PostMapper;
import com.limyel.shutbb.dto.PostExecution;
import com.limyel.shutbb.entity.Post;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.PostService;
import com.limyel.shutbb.util.MiniSnow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private MiniSnow miniSnow;

    @Override
    public Response<Integer> create(Post post) {
        post.setId(miniSnow.nextId());
        post.setFloor(postMapper.getFloor(post.getTopicId()));
        int result = postMapper.insertSelective(post);
        return Response.success("发帖成功", result);
    }

    @Override
    public Response<Post> retriveById(Long id) {
        return null;
    }

    @Override
    public Response<Integer> update(Post post) {
        return null;
    }

    @Override
    public Response<Integer> deleteById(Long id, User user) {
        return null;
    }

    @Override
    public Response<PageInfo<Post>> retriveByTopic(Long topicId, int page, int size) {
        return null;
    }

    @Override
    public Response<List<Post>> retriveByUser(Long userId) {
        return null;
    }

    @Override
    public Response<List<Post>> retriveDraft(Long userId) {
        return null;
    }

    @Override
    public Response<List<Post>> retrivePage(int page, int size) {
        return null;
    }

    @Override
    public Response<PageInfo<PostExecution>> retriveByTopicId(Long topicId, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<PostExecution> postExecutions = postMapper.selectExecutionByTopicId(topicId);
        PageInfo<PostExecution> pageInfo = new PageInfo<>(postExecutions);
        return Response.success(pageInfo);
    }
}
