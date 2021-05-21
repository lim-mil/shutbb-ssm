package com.limyel.shutbb.dao;

import com.limyel.shutbb.entity.Section;

import java.util.List;

public interface SectionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Section record);

    int insertSelective(Section record);

    Section selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Section record);

    int updateByPrimaryKey(Section record);

    List<Section> selectSelective(Section section);

    List<Section> selectFocusByUserId(Long userId);

    List<Section> selectUnfoccusByUserId(Long userId);
}