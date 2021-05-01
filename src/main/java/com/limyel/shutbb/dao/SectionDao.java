package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.Section;

import java.util.List;

public interface SectionDao {
    int create(Section section);
    Section retriveById(int id);
    List<Section> retriveByUser(int userId);
    List<Section> retriveOtherByUser(int userId);
    Section retriveDefault();
    List<Section> retriveDefaultByUser(int userId);
    List<Section> retriveAll();
    int update(Section section);
    int deleteById(int id);
}
