package com.ityunqi.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //response.setHeader("Access-Control-Allow-Origin", "https://fit-decent-sawfish.ngrok-free.app");
        //response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500/src/main/webapp/HTML/%E4%B8%AA%E4%BA%BA%E4%B8%AD%E5%BF%83%E8%B4%AD%E7%89%A9%E8%BD%A6.html");
        //response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500/src/main/webapp/HTML/个人中心购物车.html");

        // 设置允许的来源
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 设置允许的方法
        response.setHeader("Access-Control-Allow-Methods", "*");
        // 设置允许的头部信息
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization,ngrok-skip-browser-warning");

        response.setHeader("Access-Control-Allow-Credentials", "true");
        // 设置预检请求的有效期，单位为秒
        response.setHeader("Access-Control-Max-Age", "3600");

        // 如果是OPTIONS请求，直接返回
        //需要注意的是，对于OPTIONS请求，通常是浏览器在发送跨域请求之前发送的预检请求，
        // 所以我们需要对这种情况进行特殊处理，直接返回一个带有200状态码的响应。
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            // 继续执行过滤器链
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
        //初始化操作
    }

    @Override
    public void destroy() {
        //销毁操作
    }
}

/*import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsFilter implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}*/

/*
@WebFilter(filterName = "Filter_CrossOrigin",urlPatterns = "/*")
public class Filter_CrossOrigin implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        response1.setCharacterEncoding("utf-8");
        request1.setCharacterEncoding("utf-8");
        System.out.println("过滤器执行了");
        response1.setHeader("Access-Control-Allow-Origin", request1.getHeader("origin"));
        response1.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response1.setHeader("Access-Control-Max-Age", "3600");
        response1.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type");
        response1.setHeader("Access-Control-Allow-Credentials", "true");
        if ("OPTIONS".equalsIgnoreCase(request1.getMethod())) {
            response1.setStatus(HttpServletResponse.SC_OK); // 设置状态码为200 OK
            return;
        }
        chain.doFilter(request1, response1);
    }
}*/
