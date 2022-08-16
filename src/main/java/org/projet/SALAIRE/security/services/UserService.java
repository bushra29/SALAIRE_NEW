package org.projet.SALAIRE.security.services;

import org.projet.SALAIRE.security.exceptions.RoleNotFoundException;
import org.projet.SALAIRE.security.requests.LoginRequest;
import org.projet.SALAIRE.security.requests.RegisterRequest;
import org.projet.SALAIRE.security.responses.HttpSuccessResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    
    String authenticate(LoginRequest request, AuthenticationManager authenticationManager);

    HttpSuccessResponse storeUser(RegisterRequest request) throws RoleNotFoundException;

    HttpSuccessResponse authUser(Authentication authentication);
}
