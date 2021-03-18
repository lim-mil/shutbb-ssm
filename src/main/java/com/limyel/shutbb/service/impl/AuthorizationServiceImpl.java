package com.limyel.shutbb.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.AuthorizationService;
import org.jose4j.jwt.JwtClaims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

public class AuthorizationServiceImpl implements AuthorizationService {

    private String secret;

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String generateJwtToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        String token = JWT.create()
                .withClaim("username", user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60))
                .sign(algorithm);
        return token;
    }

    @Override
    public User parseJwtToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
        try {
            DecodedJWT jwt = verifier.verify(token);
            User user = new User();
            user.setUsername(jwt.getClaim("username").asString());
            return user;
        } catch (TokenExpiredException e) {
            e.printStackTrace();
        }
        return null;
    }
}
