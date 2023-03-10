package ru.itmo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itmo.db.InternalOffer;
import ru.itmo.service.OfferService;

import java.util.ArrayList;

@Controller
public class OfferController {
    private OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    public OfferService getOfferService() {
        return offerService;
    }

    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showOffersPage(ModelMap model) {
        ArrayList<InternalOffer> offers = offerService.getOffersByStatus(0);

        model.put("length", offers.size());
        model.put("activeOffers", offers);

        return "offers";
    }
}