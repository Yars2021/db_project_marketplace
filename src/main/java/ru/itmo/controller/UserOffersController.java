package ru.itmo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itmo.db.InternalOffer;
import ru.itmo.service.OfferService;

import java.util.List;

@Controller
public class UserOffersController {
    private OfferService offerService;

    public UserOffersController(OfferService offerService) {
        this.offerService = offerService;
    }

    public OfferService getOfferService() {
        return offerService;
    }

    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }

    @RequestMapping(value="/users/{user_id}/offers", method = RequestMethod.GET)
    public String showUsersOffersPage(ModelMap model, @PathVariable(name = "user_id") String user_id) {
        List<InternalOffer> offers = offerService.getOffersOfUser(user_id).get(1);

        model.put("length", offers.size());
        model.put("usersOffers", offers);
        model.put("profile", user_id);

        return "user_offers";
    }
}