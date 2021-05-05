package com.limyel.shutbb.service;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.entity.Section;
import com.limyel.shutbb.entity.User;

public interface OperationService {
    Response updateUsersSections(User user, Section section);
}
