package com.example.ch7.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.logging.Logger;

public class AuthenticationLoggingFilter extends OncePerRequestFilter {

    private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        var httpRequest = (HttpServletRequest) request;
//        var requestId = httpRequest.getHeader("Request-Id");
//
//        logger.info("Successfully authenticated request with id" + requestId);
//        chain.doFilter(request, response);
//
//    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var httpRequest = (HttpServletRequest) request;
        var requestId = httpRequest.getHeader("Request-Id");

        logger.info("Successfully authenticated request with id" + requestId);
        filterChain.doFilter(request, response);
    }
}
