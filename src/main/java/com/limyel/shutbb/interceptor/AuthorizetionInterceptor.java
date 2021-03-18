package com.limyel.shutbb.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.limyel.shutbb.annotation.IgnoreAuth;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizetionInterceptor implements HandlerInterceptor {
    @Autowired
    AuthorizationService authorizationService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (((HandlerMethod) handler).hasMethodAnnotation(IgnoreAuth.class)) {
            return true;
        }

        String bearer = request.getHeader("Authorization");
        System.out.println(bearer);
        if (bearer != null) {
            String token = bearer.split(" ")[1];
            User user = authorizationService.parseJwtToken(token);
            if (user != null) {
                return true;
            }
        }

        response.setStatus(401);
        return false;
    }
}
