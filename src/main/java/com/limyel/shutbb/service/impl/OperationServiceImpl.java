package com.limyel.shutbb.service.impl;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dao.UsersSectionsMapper;
import com.limyel.shutbb.entity.Section;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.entity.UsersSections;
import com.limyel.shutbb.service.OperationService;
import com.limyel.shutbb.util.MiniSnow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private UsersSectionsMapper usersSectionsMapper;

    @Autowired
    private MiniSnow miniSnow;

    @Override
    public Response updateUsersSections(User user, Section section) {
        UsersSections tmpUsersSections = new UsersSections();
        tmpUsersSections.setUserId(user.getId());
        tmpUsersSections.setSectionId(section.getId());
        UsersSections record = usersSectionsMapper.selectSelective(tmpUsersSections);
        if (record == null) {
            tmpUsersSections.setId(miniSnow.nextId());
            usersSectionsMapper.insertSelective(tmpUsersSections);
        } else {
            record.setDeleted(!record.getDeleted());
            usersSectionsMapper.updateByPrimaryKeySelective(record);
        }
        return Response.success();
    }
}
