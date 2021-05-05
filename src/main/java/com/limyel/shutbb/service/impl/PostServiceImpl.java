package com.limyel.shutbb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dao.PostDao;
import com.limyel.shutbb.entity.Post;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostDao postDao;

    @Autowired
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public Response<Integer> create(Post post) {
        int result = postDao.create(post);
        System.out.println(result);
        if (result == 0) {
            return Response.badRequest(result);
        }
        return Response.success("回复成功", post.getId());
    }

    @Override
    public Response<Post> retriveById(int id) {

        return null;
    }

    @Override
    public Response<Integer> update(Post post) {
        return null;
    }

    @Override
    public Response<Integer> deleteById(int id, User user) {
        int result = postDao.deleteById(id, user);
        if (result == 0) {
            return Response.badRequest(result);
        }
        return Response.success(result);
    }

    @Override
    public Response<PageInfo<Post>> retriveByTopic(int topicId, int page, int size) {
        PageHelper.startPage(page, size);
        List<Post> result = postDao.retriveByTopic(topicId);
        PageInfo<Post> postPageInfo = new PageInfo<>(result);
        return Response.success(postPageInfo);
    }

    @Override
    public Response<List<Post>> retriveByUser(int userId) {
        List<Post> result = postDao.retriveByUser(userId);
        return Response.success(result);
    }

    @Override
    public Response<List<Post>> retriveDraft(int userId) {
        List<Post> result = postDao.retriveDraft(userId);
        return Response.success(result);
    }

    @Override
    public Response<List<Post>> retrivePage(int page, int size) {
        PageHelper.startPage(page, size);
        List<Post> result = null;
        return null;
    }
}
