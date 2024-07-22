package org.example.ticketing.interfaces.presentation.user.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/users") //필터를 적용할 uri를 설정한다.
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("---필터 인스턴스 초기화---");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);

        chain.doFilter(httpServletRequest, httpServletResponse);

        String uri = httpServletRequest.getRequestURI();
        String reqContent = new String(httpServletRequest.getContentAsByteArray());
        log.info("uri : {}, request : {}", uri, reqContent);

        int httpStatus = httpServletResponse.getStatus();
        String resContent = new String(httpServletResponse.getContentAsByteArray());

        httpServletResponse.copyBodyToResponse();

        log.info("status: {}, response {}", httpStatus, resContent);
    }


    @Override
    public void destroy() {
        log.info("---필터 인스턴스 종료---");
    }
}