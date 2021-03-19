package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.Post;

public interface PostDao {
    int create(Post post);
    Post retriveById(int id);
    int update(Post post);
    int deleteById(int id);
}
