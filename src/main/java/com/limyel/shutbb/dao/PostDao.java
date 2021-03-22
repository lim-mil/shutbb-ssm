package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.Post;

import java.util.List;

public interface PostDao {
    int create(Post post);
    Post retriveById(int id);
    int update(Post post);
    int deleteById(int id);
    List<Post> retriveByTopic(int topicId);
    List<Post> retriveByUser(int userId);
    List<Post> retriveDraft(int userId);
}
