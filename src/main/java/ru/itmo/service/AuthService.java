package ru.itmo.service;

import org.springframework.stereotype.Component;
import ru.itmo.db.InternalUser;
import ru.itmo.db.UserRepository;

@Component
public class AuthService {
    UserRepository userRepository;

    public AuthService() {
    }

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
