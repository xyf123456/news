package com.bdqn.utils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName: com.bdqn.utils.EncodingFilter
 * @Description: 字符编码过滤器
 * @Author:      Administrator
 * @CreateDate: 2019/5/30 0030 下午 9:40
 * @UpdateUser:   Administrator
 * @Version:        1.0
 **/
public class EncodingFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
