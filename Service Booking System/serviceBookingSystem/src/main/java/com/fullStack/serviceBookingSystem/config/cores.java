package com.fullStack.serviceBookingSystem.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class cores {


    @Component
    public class CORSFilter extends OncePerRequestFilter {

        @Override
        public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, ServletException, IOException {
            String originHeader = request.getHeader("origin");
            response.setHeader("Access-Control-Allow-Origin", originHeader);
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "*");
            response.setHeader("Access-Control-Max-Age", "3600");

            if ("OPTIONS" .equals(request.getMethod())) {
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                filterChain.doFilter(request, response);
            }
        }
    }
}
