package com.limyel.shutbb.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.limyel.shutbb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AuthorizationUtil {
    private ConfigUtil configUtil;

    @Autowired
    public void setConfigUtil(ConfigUtil configUtil) {
        this.configUtil = configUtil;
    }

    public String generateJwtToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(configUtil.getJwtSecret());
        return JWT.create()
                .withClaim("username", user.getUsername())
                .withClaim("id", user.getId())
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*8))
                .sign(algorithm);
    }

    public User parseJwtToken(String token) throws TokenExpiredException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(configUtil.getJwtSecret())).build();
        User user = null;
        try {
            DecodedJWT jwt = verifier.verify(token);
            user = new User();
            user.setUsername(jwt.getClaim("username").asString());
            user.setId(jwt.getClaim("id").asString());
        } catch (TokenExpiredException e) {
//            e.printStackTrace();
        }
        return user;
    }
}
