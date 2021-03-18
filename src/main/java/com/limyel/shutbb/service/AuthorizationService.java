package com.limyel.shutbb.service;

import com.limyel.shutbb.entity.User;

public interface AuthorizationService {
    String generateJwtToken(User user);
    User parseJwtToken(String token);
}
