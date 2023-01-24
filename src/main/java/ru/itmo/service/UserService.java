package ru.itmo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.db.InternalUser;
import ru.itmo.db.OfferRepository;
import ru.itmo.db.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OfferRepository offerRepository;

    public UserService() {
    }

    public UserService(UserRepository userRepository, OfferRepository offerRepository) {
        this.userRepository = userRepository;
        this.offerRepository = offerRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public OfferRepository getOfferRepository() {
        return offerRepository;
    }

    public void setOfferRepository(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public String getUsername(String login) {
        if (userRepository == null) return "";
        InternalUser internalUser = userRepository.findByLogin(login);
        if (internalUser == null) return "";
        return internalUser.getUsername();
    }

    public Integer getBalance(String login) {
        if (userRepository == null) return 0;
        InternalUser internalUser = userRepository.findByLogin(login);
        if (internalUser == null) return 0;
        return internalUser.getBalance();
    }

    public Integer getBuyerReputation(String login) {
        if (userRepository == null) return 0;
        InternalUser internalUser = userRepository.findByLogin(login);
        if (internalUser == null) return 0;
        return internalUser.getBuyer_reputation();
    }

    public Integer getSalesmanReputation(String login) {
        if (userRepository == null) return 0;
        InternalUser internalUser = userRepository.findByLogin(login);
        if (internalUser == null) return 0;
        return internalUser.getSalesman_reputation();
    }
}