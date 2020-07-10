package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.security.UserSec;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserService {

    public static UserSec authenticated() {
        try {
            return (UserSec) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }
}
