package com.limyel.shutbb.resolver;

import com.limyel.shutbb.annotation.CurrentUser;
import com.limyel.shutbb.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class CurrentUserResolver implements HandlerMethodArgumentResolver {
    @Autowired
    AuthorizationService authorizationService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        System.out.println("alllll");
        return methodParameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String token = nativeWebRequest.getHeader("Authorization");
        return authorizationService.parseJwtToken(token);
    }
}
