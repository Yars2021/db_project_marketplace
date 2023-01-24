package ru.itmo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.db.InternalUser;
import ru.itmo.db.UserRepository;
import ru.itmo.util.HashPasswordEncoder;
import ru.itmo.util.TokenUtils;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;
    private final HashPasswordEncoder hashPasswordEncoder = new HashPasswordEncoder();
    private final TokenUtils tokenUtils = new TokenUtils();

    public LoginService() {
    }

    public String generateToken() {
        return tokenUtils.getToken();
    }

    public String getUsernameByLogin(String login) {
        if (userRepository == null) return "";
        InternalUser internalUser = userRepository.findByLogin(login);
        if (internalUser == null) return "";
        return internalUser.getUsername();
    }

    public boolean validateUser(String login, String password) {
        if (userRepository == null) return false;
        InternalUser internalUser = userRepository.findByLogin(login);
        if (internalUser == null) return false;
        return hashPasswordEncoder.encode(password).equals(internalUser.getPassword());
    }
}