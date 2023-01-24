package ru.itmo.service;

import org.springframework.stereotype.Component;
import ru.itmo.db.UserRepository;
import ru.itmo.util.HashPasswordEncoder;
import ru.itmo.util.TokenUtils;

@Component
public class AuthService {
    private UserRepository userRepository;
    private final HashPasswordEncoder hashPasswordEncoder = new HashPasswordEncoder();
    private final TokenUtils tokenUtils = new TokenUtils();

    public AuthService() {
    }

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String authorizeUser(String login, String password) {
        return "";
    }
}
