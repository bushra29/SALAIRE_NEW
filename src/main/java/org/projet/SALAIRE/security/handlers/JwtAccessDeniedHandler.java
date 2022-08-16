package org.projet.SALAIRE.security.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.projet.SALAIRE.security.responses.HttpErrorResponse;
import org.projet.SALAIRE.security.utils.constants.JavaConstant;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;


import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        HttpErrorResponse errorResponse = new HttpErrorResponse();
        errorResponse.setStatus(UNAUTHORIZED);
        errorResponse.setStatusCode(UNAUTHORIZED.value());
        errorResponse.setReason(UNAUTHORIZED.getReasonPhrase());
        errorResponse.setMessage(JavaConstant.ACCESS_DENIED_MESSAGE);
        httpServletResponse.setContentType(APPLICATION_JSON_VALUE);
        httpServletResponse.setStatus(FORBIDDEN.value());
        OutputStream outputStream = httpServletResponse.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(outputStream, errorResponse);
        outputStream.flush();
    }
}
