package ru.itmo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.db.*;

import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private ItemRepository itemRepository;

    public UserService() {
    }

    public UserService(UserRepository userRepository, OfferRepository offerRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.offerRepository = offerRepository;
        this.itemRepository = itemRepository;
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

    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
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

    public void buyOffer(String user_id, Integer offer_id) {
        InternalUser internalUser = userRepository.findByLogin(user_id);

        if (internalUser != null && offerRepository.findById(offer_id).isPresent()) {
            InternalOffer internalOffer = offerRepository.findById(offer_id).get();

            if (internalOffer.getStatus() == 0) {
                internalOffer.setStatus(1);
                internalOffer.setBuyer(user_id);
                offerRepository.save(internalOffer);

                InternalUser salesman = userRepository.findByLogin(internalOffer.getSalesman());
                salesman.setBalance(salesman.getBalance() + internalOffer.getPrice());
                userRepository.save(salesman);

                internalUser.setBalance(internalUser.getBalance() - internalOffer.getPrice());
                userRepository.save(internalUser);

                Set<InternalItem> items = internalOffer.getItems();
                for (InternalItem item : items) {
                    item.setOwner(user_id);
                    itemRepository.save(item);
                }
            }
        }
    }
}