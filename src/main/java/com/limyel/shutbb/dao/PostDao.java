package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.Post;
import com.limyel.shutbb.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostDao {
    int create(Post post);
    Post retriveById(int id);
    List<Post> retriveByTopic(int topicId);
    List<Post> retriveByUser(int userId);
    List<Post> retriveDraft(int userId);
    Post retriveLatest(int topicId);
    int update(Post post);
    int deleteById(@Param("id") int id, @Param("user") User user);
    int countByTopic(int topicId);
}
