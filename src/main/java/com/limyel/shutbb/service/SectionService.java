package com.limyel.shutbb.service;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dto.UsersSectionsExecution;
import com.limyel.shutbb.entity.Section;
import com.limyel.shutbb.entity.User;

import java.util.List;

public interface SectionService {
    Response<Integer> create(Section section);
    Response<Section> retriveById(String id);
    Response<List<Section>> retriveDefault(User user);
    Response<UsersSectionsExecution> selectByUserId(User user);
    Response<List<Section>> retriveAll();
    Response<Integer> update(Section section);
    Response<Integer> deleteById(String id);
    Response<List<Section>> selectSelective(Section section);
    Response<List<Section>> selectFocus(User user);
    Response<UsersSectionsExecution> selectAll(User user);
}
