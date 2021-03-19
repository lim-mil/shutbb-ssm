package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.SubForum;

public interface SubForumDao {
    int create(SubForum subForum);
    SubForum retriveById(int id);
    int update(SubForum subForum);
    int deleteById(int id);
}
