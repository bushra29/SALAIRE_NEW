package org.projet.SALAIRE.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.projet.SALAIRE.security.responses.HttpErrorResponse;
import org.projet.SALAIRE.security.utils.constants.JavaConstant;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;


import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
public class JwtAuthenticationEntryPoint extends Http403ForbiddenEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2) throws IOException {
        HttpErrorResponse errorResponse = new HttpErrorResponse();
        errorResponse.setStatus(FORBIDDEN);
        errorResponse.setStatusCode(FORBIDDEN.value());
        errorResponse.setReason(FORBIDDEN.getReasonPhrase());
        errorResponse.setMessage(JavaConstant.FORBIDDEN_MESSAGE);
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(FORBIDDEN.value());
        OutputStream outputStream = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(outputStream, errorResponse);
        outputStream.flush();
    }
}
