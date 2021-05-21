package com.limyel.shutbb.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.AuthorizationService;
import com.limyel.shutbb.util.ConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    private ConfigUtil configUtil;

    @Autowired
    public void setConfigUtil(ConfigUtil configUtil) {
        this.configUtil = configUtil;
    }

    @Override
    public String generateJwtToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(configUtil.getJwtSecret());
        return JWT.create()
                .withClaim("username", user.getUsername())
                .withClaim("id", user.getId())
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*8))
                .sign(algorithm);
    }

    @Override
    public User parseJwtToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(configUtil.getJwtSecret())).build();
        try {
            DecodedJWT jwt = verifier.verify(token);
            User user = new User();
            user.setUsername(jwt.getClaim("username").asString());
            user.setId(jwt.getClaim("id").asLong());
            return user;
        } catch (TokenExpiredException e) {
            e.printStackTrace();
        }
        return null;
    }
}
