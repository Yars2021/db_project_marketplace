package ru.itmo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itmo.db.InternalItem;
import ru.itmo.db.InternalOffer;
import ru.itmo.service.ItemService;
import ru.itmo.service.OfferService;
import ru.itmo.transfer.FormattedItem;

import java.util.ArrayList;
import java.util.List;

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
        List<FormattedItem> items = new ArrayList<>();

        if (itemService != null) {
            for (InternalItem item : offerService.getItemsOfTheOffer(Integer.parseInt(offer_id))) {
                items.add(new FormattedItem(
                        item.getIid(),
                        itemService.getType(item.getType()),
                        item.getOwner(),
                        item.getName(),
                        itemService.getRarity(item.getRarity()),
                        item.getDescription()));
            }
        }

        model.put("items", items);
        model.put("price", offerService.getPrice(Integer.parseInt(offer_id)));

        return "offer";
    }

    @RequestMapping(value="/offers/{offer_id}", method = RequestMethod.POST)
    public String showOfferPageAndBuy(ModelMap model, @PathVariable(name = "offer_id") String offer_id) {


        List<FormattedItem> items = new ArrayList<>();

        if (itemService != null) {
            for (InternalItem item : offerService.getItemsOfTheOffer(Integer.parseInt(offer_id))) {
                items.add(new FormattedItem(
                        item.getIid(),
                        itemService.getType(item.getType()),
                        item.getOwner(),
                        item.getName(),
                        itemService.getRarity(item.getRarity()),
                        item.getDescription()));
            }
        }

        model.put("items", items);
        model.put("price", offerService.getPrice(Integer.parseInt(offer_id)));

        return "offer";
    }
}