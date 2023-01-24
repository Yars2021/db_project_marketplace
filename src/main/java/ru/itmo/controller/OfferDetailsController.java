package ru.itmo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itmo.db.InternalOffer;
import ru.itmo.service.ItemService;
import ru.itmo.service.OfferService;

import java.util.ArrayList;

@Controller
public class OfferDetailsController {
    private OfferService offerService;
    private ItemService itemService;

    public OfferDetailsController(OfferService offerService, ItemService itemService) {
        this.offerService = offerService;
        this.itemService = itemService;
    }

    public OfferService getOfferService() {
        return offerService;
    }

    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }

    public ItemService getItemService() {
        return itemService;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value="/offers/{offer_id}", method = RequestMethod.GET)
    public String showOfferPage(ModelMap model, @PathVariable(name = "offer_id") String offer_id) {


        return "offer";
    }
}