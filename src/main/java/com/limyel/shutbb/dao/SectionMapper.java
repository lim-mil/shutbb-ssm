package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.Section;

import java.util.List;

public interface SectionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Section record);

    int insertSelective(Section record);

    Section selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Section record);

    int updateByPrimaryKey(Section record);

    List<Section> selectSelective(Section section);

    List<Section> selectFocusByUserId(String userId);

    List<Section> selectUnfoccusByUserId(String userId);
}