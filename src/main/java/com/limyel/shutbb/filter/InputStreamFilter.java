package com.limyel.shutbb.filter;

import com.limyel.shutbb.util.MyHttpServletRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class InputStreamFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest request = new MyHttpServletRequestWrapper((HttpServletRequest) servletRequest);
        filterChain.doFilter(request, servletResponse);
    }
}
