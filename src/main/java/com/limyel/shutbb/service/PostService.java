package com.limyel.shutbb.service;

import com.github.pagehelper.PageInfo;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dto.PostExecution;
import com.limyel.shutbb.entity.Post;
import com.limyel.shutbb.entity.User;

import java.util.List;

public interface PostService {
    Response<Integer> create(Post post);
    Response<Post> retriveById(Long id);
    Response<Integer> update(Post post);
    Response<Integer> deleteById(Long id, User user);
    Response<PageInfo<Post>> retriveByTopic(Long topicId, int page, int size);
    Response<List<Post>> retriveByUser(Long userId);
    Response<List<Post>> retriveDraft(Long userId);
    Response<List<Post>> retrivePage(int page, int size);

    Response<PageInfo<PostExecution>> retriveByTopicId(Long topicId, int page, int pageSize);
}
