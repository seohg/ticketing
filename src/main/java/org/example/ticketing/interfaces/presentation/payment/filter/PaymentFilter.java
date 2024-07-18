package org.example.ticketing.interfaces.presentation.payment.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class ConcertFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("---필터 인스턴스 초기화---");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String requestURI = req.getRequestURI();

        log.info("---Request(" + requestURI + ") 필터---");
        chain.doFilter(request, response);
        log.info("---Response(" + requestURI + ") 필터---");
    }

    @Override
    public void destroy() {
        log.info("---필터 인스턴스 종료---");
    }
}