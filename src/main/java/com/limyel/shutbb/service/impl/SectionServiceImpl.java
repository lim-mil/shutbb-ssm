package com.limyel.shutbb.service.impl;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dao.SectionMapper;
import com.limyel.shutbb.dto.UsersSectionsExecution;
import com.limyel.shutbb.entity.Section;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionMapper sectionMapper;

    @Override
    public Response<Integer> create(Section section) {
        return null;
    }

    @Override
    public Response<Section> retriveById(String id) {
        return null;
    }

    @Override
    public Response<List<Section>> retriveDefault(User user) {
        return null;
    }

    @Override
    public Response<UsersSectionsExecution> selectByUserId(User user) {
        List<Section> focusSections = sectionMapper.selectFocusByUserId(user.getId());
        List<Section> unfocusSections = sectionMapper.selectUnfoccusByUserId(user.getId());
        return Response.success(new UsersSectionsExecution(focusSections, unfocusSections));
    }

    @Override
    public Response<List<Section>> retriveAll() {
        return null;
    }

    @Override
    public Response<Integer> update(Section section) {
        return null;
    }

    @Override
    public Response<Integer> deleteById(String id) {
        return null;
    }

    @Override
    public Response<List<Section>> selectSelective(Section section) {
        return Response.success(sectionMapper.selectSelective(section));
    }

    @Override
    public Response<List<Section>> selectFocus(User user) {
        List<Section> result;
        if (user == null) {
            result = sectionMapper.selectSelective(null);
        } else {
            result = sectionMapper.selectFocusByUserId(user.getId());
        }
        return Response.success(result);
    }

    @Override
    public Response<UsersSectionsExecution> selectAll(User user) {
        UsersSectionsExecution usersSectionsExecution = new UsersSectionsExecution();
        usersSectionsExecution.setFocusSections(sectionMapper.selectFocusByUserId(user.getId()));
        usersSectionsExecution.setUnfocusSections(sectionMapper.selectUnfoccusByUserId(user.getId()));
        return Response.success(usersSectionsExecution);
    }
}
