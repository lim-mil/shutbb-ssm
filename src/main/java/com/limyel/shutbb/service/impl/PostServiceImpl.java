package com.limyel.shutbb.service.impl;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dao.PostDao;
import com.limyel.shutbb.entity.Post;
import com.limyel.shutbb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostDao postDao;

    @Override
    public Response<Integer> create(Post post) {
        int result = postDao.create(post);
        if (result == 0) {
            return Response.badRequest(result);
        }
        return Response.success(result);
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
    public Response<Integer> deleteById(int id) {
        return null;
    }
}
