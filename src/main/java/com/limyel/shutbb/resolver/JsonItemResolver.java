package com.limyel.shutbb.resolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.limyel.shutbb.annotation.JsonItem;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;

public class JsonItemResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        JsonItem jsonItem = methodParameter.getParameterAnnotation(JsonItem.class);
        return jsonItem != null;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        byte[] data = request.getInputStream().readAllBytes();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> result = mapper.readValue(new String(data, "UTF-8"), Map.class);
        System.out.println(result);
        return result.get(methodParameter.getParameterName());
    }
}
