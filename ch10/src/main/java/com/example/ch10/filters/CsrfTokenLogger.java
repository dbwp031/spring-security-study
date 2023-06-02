package com.example.ch10.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;

import java.io.IOException;
import java.util.logging.Logger;

public class CsrfTokenLogger implements Filter {

    private Logger logger = Logger.getLogger(CsrfTokenLogger.class.getName());
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Object o = request.getAttribute("_csrf");
        CsrfToken token = (CsrfToken) o;

        logger.info("CSRF Token " + token.getToken());
        chain.doFilter(request, response);

    }
}
