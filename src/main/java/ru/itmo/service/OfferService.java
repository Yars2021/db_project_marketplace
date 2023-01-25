package ru.itmo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.db.InternalItem;
import ru.itmo.db.InternalOffer;
import ru.itmo.db.InternalUser;
import ru.itmo.db.OfferRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OfferService {
    @Autowired
    private OfferRepository offerRepository;

    public OfferService() {
    }

    public ArrayList<List<InternalOffer>> getOffersOfUser(String login) {
        ArrayList<List<InternalOffer>> offers = new ArrayList<>(2);
        offers.add(new ArrayList<>());
        offers.add(new ArrayList<>());

        if (offerRepository == null) return offers;
        offers.get(0).addAll(offerRepository.findByBuyer(login));
        offers.get(1).addAll(offerRepository.findBySalesman(login));

        return offers;
    }

    public ArrayList<InternalOffer> getOffersByStatus(Integer status) {
        ArrayList<InternalOffer> offers = new ArrayList<>();

        if (offerRepository == null) return offers;
        offers.addAll(offerRepository.findByStatus(status));

        return offers;
    }

    public ArrayList<InternalItem> getItems(Integer oid) {
        ArrayList<InternalItem> items = new ArrayList<>();

        if (offerRepository == null || offerRepository.findById(oid).isEmpty()) return items;
        InternalOffer offer = offerRepository.findById(oid).get();
        items.addAll(offer.getItems());

        return items;
    }

    public void submitOffer(InternalOffer offer) {
        if (offerRepository != null) {
            offerRepository.save(offer);
        }
    }

    public void submitOffer(String salesman, Integer price, Set<InternalItem> items) {
        if (offerRepository != null) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDateTime now = LocalDateTime.now();

            InternalOffer internalOffer = new InternalOffer(salesman, "", price, dtf.format(now), 0);
            internalOffer.setItems(items);

            submitOffer(internalOffer);
        }
    }

    public Set<InternalItem> getItemsOfTheOffer(Integer oid) {
        if (offerRepository == null || offerRepository.findById(oid).isEmpty()) return new HashSet<>();
        InternalOffer internalOffer = offerRepository.findById(oid).get();
        return internalOffer.getItems();
    }

    public Integer getPrice(Integer oid) {
        if (offerRepository == null || offerRepository.findById(oid).isEmpty()) return 0;
        InternalOffer internalOffer = offerRepository.findById(oid).get();
        return internalOffer.getPrice();
    }

    public boolean getStatus(Integer oid) {
        if (offerRepository == null || offerRepository.findById(oid).isEmpty()) return false;
        InternalOffer internalOffer = offerRepository.findById(oid).get();
        return internalOffer.getStatus() == 0;
    }

    public String getSalesman(Integer oid) {
        if (offerRepository == null || offerRepository.findById(oid).isEmpty()) return "";
        InternalOffer internalOffer = offerRepository.findById(oid).get();
        return internalOffer.getSalesman();
    }
}
