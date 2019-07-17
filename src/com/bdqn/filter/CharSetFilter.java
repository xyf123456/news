package com.bdqn.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
/**
 * @ClassName: CharSetFilter
 * @Description: 字符过滤器
 * @Author: xyf
 * @Date 2019/6/5 0005 下午 4:00
 */
@WebFilter(filterName = "CharSetFilter")
public class CharSetFilter implements Filter {

    public CharSetFilter() {
//        System.out.println("CharSetFilter无参的方法执行了");
    }

    public void destroy() {
//        System.out.println("destroy()方法执行了");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        System.out.println("doFilter()方法执行了");
//        过滤所有的请求，都必须是UTF-8
        req.setCharacterEncoding(req.getServletContext().getInitParameter("charset"));
        resp.setCharacterEncoding(req.getServletContext().getInitParameter("charset"));
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
//        System.out.println("init()方法执行了");
    }

}
