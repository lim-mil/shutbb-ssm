package com.limyel.shutbb.service;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.entity.Post;

import java.util.List;

public interface PostService {
    Response<Integer> create(Post post);
    Response<Post> retriveById(int id);
    Response<Integer> update(Post post);
    Response<Integer> deleteById(int id);
    Response<List<Post>> retriveByTopic(int topicId);
    Response<List<Post>> retriveByUser(int userId);
    Response<List<Post>> retriveDraft(int userId);
}
