package org.projet.SALAIRE.security.utils;

import org.projet.SALAIRE.security.entities.User;
import org.projet.SALAIRE.security.requests.RegisterRequest;
import org.projet.SALAIRE.security.responses.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class JavaConverter {

    public User registerToUser(RegisterRequest request) {
        User user = new User();
        /*BY IB*/user.setNotLocked(false);
        //user.setIdEns(request.getIdEns());
        BeanUtils.copyProperties(request, user);
        return user;
    }

    public UserResponse userToUserResponse(User user) {
        UserResponse response = new UserResponse();
        BeanUtils.copyProperties(user, response);
        return response;
    }
}
/*
    public User registerToUser(RegisterRequest request) {
        User user = new User();
        BeanUtils.copyProperties(request, user);
        return user;
    }

    public UserResponse userToUserResponse(User user) {
        UserResponse response = new UserResponse();
        BeanUtils.copyProperties(user, response);
        return response;
    }*/