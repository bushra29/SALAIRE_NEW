package org.projet.SALAIRE.security.controllers;


import org.projet.SALAIRE.security.exceptions.RoleNotFoundException;
import org.projet.SALAIRE.security.handlers.ExceptionsHandler;
import org.projet.SALAIRE.security.requests.LoginRequest;
import org.projet.SALAIRE.security.requests.RegisterRequest;
import org.projet.SALAIRE.security.responses.HttpSuccessResponse;
import org.projet.SALAIRE.security.responses.JwtResponse;
import org.projet.SALAIRE.security.services.UserService;
import org.projet.SALAIRE.security.utils.constants.JavaConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import static org.projet.SALAIRE.security.utils.constants.JavaConstant.API_BASE_URL;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
//@RequestMapping(API_BASE_URL)
@RequestMapping(API_BASE_URL)
@CrossOrigin("*")
public class AuthController extends ExceptionsHandler {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(value = "register", consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE},
            produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public ResponseEntity<HttpSuccessResponse> register(@RequestBody @Validated RegisterRequest request) throws RoleNotFoundException, RoleNotFoundException {
        HttpSuccessResponse response = userService.storeUser(request);
        return ResponseEntity.status(CREATED).body(response);
    }

    @PostMapping(value = "login", consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE},
            produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public ResponseEntity<JwtResponse> login(@RequestBody @Validated LoginRequest request) {
        System.out.println(request+"***************************************");
        JwtResponse response = new JwtResponse();
        String token = userService.authenticate(request, authenticationManager);
        response.setAccess_token(token);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping(value = "me", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public ResponseEntity<HttpSuccessResponse> me() {
        System.out.println("*******************************************");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        HttpSuccessResponse response = userService.authUser(authentication);
        return ResponseEntity.ok().body(response);
    }


}
