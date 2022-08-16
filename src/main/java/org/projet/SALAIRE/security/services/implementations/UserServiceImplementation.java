package org.projet.SALAIRE.security.services.implementations;


import org.projet.SALAIRE.security.entities.Role;
import org.projet.SALAIRE.security.entities.User;
import org.projet.SALAIRE.security.exceptions.RoleNotFoundException;
import org.projet.SALAIRE.security.repositories.RoleRepository;
import org.projet.SALAIRE.security.repositories.UserRepository;
import org.projet.SALAIRE.security.requests.LoginRequest;
import org.projet.SALAIRE.security.requests.RegisterRequest;
import org.projet.SALAIRE.security.responses.HttpSuccessResponse;
import org.projet.SALAIRE.security.services.UserService;
import org.projet.SALAIRE.security.utils.JavaConverter;
import org.projet.SALAIRE.security.utils.JavaUtils;
import org.projet.SALAIRE.security.utils.JwtUtils;
import org.projet.SALAIRE.security.utils.UserPrincipal;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtUtils jwtUtils;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JavaConverter javaConverter;

    public UserServiceImplementation(UserRepository userRepository, RoleRepository roleRepository, JwtUtils jwtUtils, BCryptPasswordEncoder bCryptPasswordEncoder, JavaConverter javaConverter) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.jwtUtils = jwtUtils;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.javaConverter = javaConverter;
    }

    @Override
    public HttpSuccessResponse storeUser(RegisterRequest request) throws RoleNotFoundException {
        request.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        User user = userRepository.save(javaConverter.registerToUser(request));
        addRoleToUser("ROLE_USER", user.getUsername());
        return JavaUtils.successResponse(CREATED, "Votre compte a bien été créer.", javaConverter.userToUserResponse(user));
    }

    @Override
    public HttpSuccessResponse authUser(Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Utilisateur Non trouvée!"));
        return JavaUtils.successResponse(OK, "Détails du compte de l'utilisateur", user.map(javaConverter::userToUserResponse));
    }

    private void addRoleToUser(String roleName, String username) throws RoleNotFoundException {
        Optional<Role> role = roleRepository.findByName(roleName);
        role.orElseThrow(() -> new RoleNotFoundException("Role n'existe pas"));
        Optional<User> user = userRepository.findByUsername(username);
        user
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur n'existe pas"))
                .getRoles()
                .add(role.get());
        /*By IB*/  userRepository.save(user.get());
    }

    @Override
    public String authenticate(LoginRequest request, AuthenticationManager authenticationManager) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        Optional<User> user = userRepository.findByUsername(request.getUsername());
        user.orElseThrow(() -> new UsernameNotFoundException("Utilisateur Non trouvée!"));
        return jwtUtils.generateJwtToken(user.map(UserPrincipal::new).get());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Utilisateur n'existe pas dans la base."));
        return user.map(UserPrincipal::new).get();
    }
}
