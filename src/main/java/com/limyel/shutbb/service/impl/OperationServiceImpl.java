package com.limyel.shutbb.service.impl;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dao.OperationDao;
import com.limyel.shutbb.entity.Section;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.entity.UsersSections;
import com.limyel.shutbb.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceImpl implements OperationService {

    private OperationDao operationDao;

    @Autowired
    public void setOperationDao(OperationDao operationDao) {
        this.operationDao = operationDao;
    }

    @Override
    public Response updateUsersSections(User user, Section section) {
        UsersSections usersSections = new UsersSections(user, section);
        int result = 0;
        UsersSections record = operationDao.existUsersSections(usersSections);
        if (record != null) {
            // 关注记录已存在，转换 deleted 的值即可
            record.setDeleted(!record.isDeleted());
            result = operationDao.updateUsersSections(record);
        } else {
            // 关注记录不存在，一定是关注，新建
            result = operationDao.createUsersSections(usersSections);
        }

        return result == 1? Response.success(): Response.badRequest();
    }

}
