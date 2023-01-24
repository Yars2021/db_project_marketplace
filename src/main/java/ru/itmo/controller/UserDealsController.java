package ru.itmo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itmo.db.InternalOffer;
import ru.itmo.service.OfferService;
import ru.itmo.service.UserService;

import java.util.List;

@Controller
public class UserDealsController {
    private UserService userService;
    private OfferService offerService;

    public UserDealsController(UserService userService, OfferService offerService) {
        this.userService = userService;
        this.offerService = offerService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public OfferService getOfferService() {
        return offerService;
    }

    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }

    @RequestMapping(value="/users/{user_id}/deals", method = RequestMethod.GET)
    public String showUserDealsPage(ModelMap model, @PathVariable(name = "user_id") String user_id) {
        List<InternalOffer> offers = offerService.getOffersOfUser(user_id).get(0);

        model.put("length", offers.size());
        model.put("usersDeals", offers);
        model.put("profile", user_id);

        return "user_deals";
    }
}