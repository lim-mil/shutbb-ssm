package com.limyel.shutbb.interceptor;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.limyel.shutbb.annotation.IgnoreAuth;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.util.AuthorizationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class AuthorizetionInterceptor implements HandlerInterceptor {

    private AuthorizationUtil authorizationUtil;

    @Autowired
    public void setAuthorizationUtil(AuthorizationUtil authorizationUtil) {
        this.authorizationUtil = authorizationUtil;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            IgnoreAuth ignoreAuth = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
            if (ignoreAuth != null)
                return true;
        }

        String bearer = request.getHeader("Authorization");
        if (bearer != null) {
            String token = bearer.split(" ")[1];
            User user = null;
            user = authorizationUtil.parseJwtToken(token);
            if (user != null) {
                return true;
            } else {
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.println("登录过期，请重新登录");
            }
        }

        response.setStatus(401);
        return false;
    }
}
