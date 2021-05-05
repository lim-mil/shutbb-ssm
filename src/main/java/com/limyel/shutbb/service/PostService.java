package com.limyel.shutbb.service;

import com.github.pagehelper.PageInfo;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.entity.Post;
import com.limyel.shutbb.entity.User;

import java.util.List;

public interface PostService {
    Response<Integer> create(Post post);
    Response<Post> retriveById(int id);
    Response<Integer> update(Post post);
    Response<Integer> deleteById(int id, User user);
    Response<PageInfo<Post>> retriveByTopic(int topicId, int page, int size);
    Response<List<Post>> retriveByUser(int userId);
    Response<List<Post>> retriveDraft(int userId);
    Response<List<Post>> retrivePage(int page, int size);
}
