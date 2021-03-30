package com.limyel.shutbb.service.impl;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dao.SectionDao;
import com.limyel.shutbb.entity.Section;
import com.limyel.shutbb.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {
    private SectionDao sectionDao;

    @Autowired
    public void setSectionDao(SectionDao sectionDao) {
        this.sectionDao = sectionDao;
    }

    @Override
    public Response<Integer> create(Section section) {
        int result = sectionDao.create(section);
        return Response.success(result);
    }

    @Override
    public Response<Section> retriveById(int id) {
        return null;
    }

    @Override
    public Response<Integer> update(Section section) {
        return null;
    }

    @Override
    public Response<Integer> deleteById(int id) {
        return null;
    }

}
