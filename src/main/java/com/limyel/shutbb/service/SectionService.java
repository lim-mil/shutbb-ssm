package com.limyel.shutbb.service;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.entity.Section;

public interface SectionService {
    Response<Integer> create(Section section);
    Response<Section> retriveById(int id);
    Response<Integer> update(Section section);
    Response<Integer> deleteById(int id);
}
