package com.limyel.shutbb.service;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dto.SectionShort;
import com.limyel.shutbb.dto.UserSection;
import com.limyel.shutbb.entity.Section;
import com.limyel.shutbb.entity.User;

import java.util.List;

public interface SectionService {
    Response<Integer> create(Section section);
    Response<Section> retriveById(int id);
    Response<List<Section>> retriveDefault(User user);
    Response<UserSection> retriveByUser(User user);
    Response<List<Section>> retriveAll();
    Response<Integer> update(Section section);
    Response<Integer> deleteById(int id);
}
