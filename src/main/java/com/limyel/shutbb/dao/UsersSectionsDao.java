package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.Section;
import com.limyel.shutbb.entity.UsersSections;

import java.util.List;

public interface UsersSectionsDao {
    int create(UsersSections usersSections);
    List<UsersSections> retriveByUser(int userId);
    int update(UsersSections usersSections);
    int delete(UsersSections usersSections);
}
