package ru.itmo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itmo.db.InternalOffer;
import ru.itmo.service.LoginService;
import ru.itmo.service.OfferService;

import java.util.ArrayList;

@Controller
@SessionAttributes("session_username")
public class LoginController {
    private final LoginService loginService;
    private final OfferService offerService;

    public LoginController(LoginService loginService, OfferService offerService) {
        this.loginService = loginService;
        this.offerService = offerService;
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showLoginPage(ModelMap model, @RequestParam String session_username, @RequestParam String password) {
        boolean isValidUser = loginService.validateUser(session_username, password);

        if (isValidUser) model.put("user_status", "Logged in");
        else {
            model.put("user_status", "Invalid Credentials");
            model.put("session_username", "");
            return "login";
        }

        ArrayList<InternalOffer> offers = offerService.getOffersByStatus(0);

        model.put("length", offers.size());
        model.put("activeOffers", offers);
        model.addAttribute("session_username", session_username);
        model.put("username", loginService.getUsernameByLogin(session_username));
        model.put("password", password);

        return "offers";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        ArrayList<InternalOffer> offers = offerService.getOffersByStatus(0);
        // ToDo
        model.put("session_username", "");
        model.put("length", offers.size());
        model.put("activeOffers", offers);

        System.out.println(model.getAttribute("session_username"));

        return "offers";
    }
}