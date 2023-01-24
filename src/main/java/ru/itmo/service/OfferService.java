package ru.itmo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.db.InternalItem;
import ru.itmo.db.InternalOffer;
import ru.itmo.db.OfferRepository;

import java.util.ArrayList;
import java.util.List;

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
}
