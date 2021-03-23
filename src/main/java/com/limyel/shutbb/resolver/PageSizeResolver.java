package com.limyel.shutbb.resolver;

import com.limyel.shutbb.annotation.Page;
import com.limyel.shutbb.annotation.Size;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class PageSizeResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(Page.class) || methodParameter.hasParameterAnnotation(Size.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        if (methodParameter.getParameterAnnotation(Page.class) != null) {
            String pageStr = nativeWebRequest.getParameter("page");
            return pageStr == null? 1: Integer.parseInt(pageStr);
        } else if (methodParameter.getParameterAnnotation(Size.class) != null) {
            String sizeStr = nativeWebRequest.getParameter("size");
            return sizeStr == null? 10: Integer.parseInt(sizeStr);
        }
        return null;
    }
}
