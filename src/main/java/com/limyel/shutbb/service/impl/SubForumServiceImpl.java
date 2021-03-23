package com.limyel.shutbb.service.impl;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dao.SubForumDao;
import com.limyel.shutbb.entity.SubForum;
import com.limyel.shutbb.service.SubForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubForumServiceImpl implements SubForumService {
    private SubForumDao subForumDao;

    @Autowired
    public void setSubForumDao(SubForumDao subForumDao) {
        this.subForumDao = subForumDao;
    }

    @Override
    public Response<Integer> create(SubForum subForum) {

        int result = subForumDao.create(subForum);
        if (result == 1) {
            return Response.success(result);
        }
        return Response.badRequest(result);
    }

    @Override
    public Response<SubForum> retriveById(int id) {
        SubForum subForum = subForumDao.retriveById(id);
        return Response.success(subForum);
    }

    @Override
    public int update(SubForum subForum) {
        return subForumDao.update(subForum);
    }

    @Override
    public int deleteById(int id) {
        return subForumDao.deleteById(id);
    }

    @Override
    public Response<List<SubForum>> retrive() {
        List<SubForum> result = subForumDao.retrive();
        return Response.success(result);
    }
}
