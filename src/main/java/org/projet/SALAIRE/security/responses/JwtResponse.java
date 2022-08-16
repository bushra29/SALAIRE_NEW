package org.projet.SALAIRE.security.responses;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import static org.projet.SALAIRE.security.utils.constants.JwtConstant.EXPIRATION_TIME;
import static org.projet.SALAIRE.security.utils.constants.JwtConstant.TOKEN_PREFIX;

@Setter
@Getter
@RequiredArgsConstructor
@Data
public class JwtResponse {

    private String access_token;

    private String token_type = TOKEN_PREFIX;

    private long expiration_time = EXPIRATION_TIME;
}
