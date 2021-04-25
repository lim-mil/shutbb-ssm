package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.Section;

import java.util.List;

public interface SectionDao {
    int create(Section section);
    Section retriveById(int id);
    List<Section> retriveByUser(int id);
    int update(Section section);
    int deleteById(int id);
}
