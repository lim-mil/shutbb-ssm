package com.limyel.shutbb.resolver;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.limyel.shutbb.annotation.CurrentUser;
import com.limyel.shutbb.dao.UserMapper;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.AuthorizationService;
import com.limyel.shutbb.util.AuthorizationUtil;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class CurrentUserResolver implements HandlerMethodArgumentResolver {
    private AuthorizationUtil authorizationUtil;
    private UserMapper userMapper;

    public void setAuthorizationUtil(AuthorizationUtil authorizationUtil) {
        this.authorizationUtil = authorizationUtil;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        CurrentUser currentUser = methodParameter.getParameterAnnotation(CurrentUser.class);
        return currentUser != null;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String authorizationHeader = nativeWebRequest.getHeader("Authorization");
        if (authorizationHeader == null) {
            return null;
        }
        String token = authorizationHeader.split(" ")[1];
        User user = authorizationUtil.parseJwtToken(token);
        if (user != null)
            user = userMapper.selectByPrimaryKey(user.getId());
        return user;
    }
}
