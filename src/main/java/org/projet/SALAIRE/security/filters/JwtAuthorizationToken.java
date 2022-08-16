package org.projet.SALAIRE.security.filters;


import org.projet.SALAIRE.security.utils.JwtUtils;
import org.projet.SALAIRE.security.utils.constants.JavaConstant;
import org.projet.SALAIRE.security.utils.constants.JwtConstant;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.OK;

@Component
public class JwtAuthorizationToken extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;

    public JwtAuthorizationToken(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getMethod().equalsIgnoreCase(JavaConstant.OPTIONS_HTTP_METHOD)) {
            response.setStatus(OK.value());
        } else {
            String authorizeHeader = request.getHeader(AUTHORIZATION);
            if (authorizeHeader == null || !authorizeHeader.startsWith(JwtConstant.TOKEN_PREFIX)) {
                filterChain.doFilter(request, response);
                return;
            }

            String token = authorizeHeader.substring(JwtConstant.TOKEN_PREFIX.length());
            String username = jwtUtils.getSubject(token);

            if (jwtUtils.isValidToken(username, token) && SecurityContextHolder.getContext().getAuthentication() == null) {
                List<GrantedAuthority> authorities = jwtUtils.getAuthorities(token);
                Authentication authentication = jwtUtils.getAuthentication(username, authorities, request);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                SecurityContextHolder.clearContext();
            }
        }

        filterChain.doFilter(request, response);
    }
}
