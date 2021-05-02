package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.Section;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.entity.UsersSections;
import org.apache.ibatis.annotations.Param;

public interface OperationDao {
    int createUsersSections(UsersSections usersSections);
    UsersSections existUsersSections(UsersSections usersSections);
    int updateUsersSections(UsersSections usersSections);
}
