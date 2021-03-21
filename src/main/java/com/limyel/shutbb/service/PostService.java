package com.limyel.shutbb.service;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.entity.Post;

public interface PostService {
    Response<Integer> create(Post post);
    Response<Post> retriveById(int id);
    Response<Integer> update(Post post);
    Response<Integer> deleteById(int id);
}
