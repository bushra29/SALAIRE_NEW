package org.projet.SALAIRE.security.responses;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@Data
@RequiredArgsConstructor
public class HttpSuccessResponse {

    private HttpStatus status;

    private int statusCode;

    private String message;

    private Object data;

    public HttpSuccessResponse(HttpStatus created, String s, UserResponse userToUserResponse) {
    }
}
