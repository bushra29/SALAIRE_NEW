package org.projet.SALAIRE.security.responses;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.projet.SALAIRE.security.entities.Role;

import java.util.Collection;

@Setter
@Getter
@RequiredArgsConstructor
@Data
public class UserResponse {

    private String username;

    private boolean isNotLocked;

    private boolean isEnable;

    private Collection<Role> roles;

}
