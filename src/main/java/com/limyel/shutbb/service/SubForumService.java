package com.limyel.shutbb.service;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.entity.SubForum;

public interface SubForumService {
    Response<Integer> create(SubForum subForum);
    Response<SubForum> retriveById(int id);
    int update(SubForum subForum);
    int deleteById(int id);
}
