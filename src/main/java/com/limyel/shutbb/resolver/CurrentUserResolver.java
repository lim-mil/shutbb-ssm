package com.limyel.shutbb.resolver;

import com.limyel.shutbb.annotation.CurrentUser;
import com.limyel.shutbb.dao.UserDao;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.AuthorizationService;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class CurrentUserResolver implements HandlerMethodArgumentResolver {
    private AuthorizationService authorizationService;
    private UserDao userDao;

    public void setAuthorizationService(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String token = nativeWebRequest.getHeader("Authorization").split(" ")[1];
        User user = authorizationService.parseJwtToken(token);
        return userDao.retriveById(user.getId());
    }
}
