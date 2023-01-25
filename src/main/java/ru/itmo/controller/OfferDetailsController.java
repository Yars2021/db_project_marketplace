package ru.itmo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itmo.db.InternalItem;
import ru.itmo.service.ItemService;
import ru.itmo.service.OfferService;
import ru.itmo.service.UserService;
import ru.itmo.transfer.FormattedItem;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("session_username")
public class OfferDetailsController {
    private OfferService offerService;
    private ItemService itemService;
    private UserService userService;

    public OfferDetailsController(OfferService offerService, ItemService itemService, UserService userService) {
        this.offerService = offerService;
        this.itemService = itemService;
        this.userService = userService;
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

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
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

        model.put("purchase_status", "");
        model.put("items", items);
        model.put("price", offerService.getPrice(Integer.parseInt(offer_id)));
        model.put("purchasable", offerService.getStatus(Integer.parseInt(offer_id)));

        return "offer";
    }

    @RequestMapping(value="/offers/{offer_id}", method = RequestMethod.POST)
    public String showOfferPageAndBuy(ModelMap model, @ModelAttribute("session_username") String session_username, @PathVariable(name = "offer_id") String offer_id) {
        if (!session_username.equals(offerService.getSalesman(Integer.parseInt(offer_id)))
                && (userService.getBalance(session_username) < offerService.getPrice(Integer.parseInt(offer_id)))) {
            model.put("purchase_status", "This purchase is not affordable right now");
        } else {
            model.put("purchase_status", "Purchase successful");
            userService.buyOffer(session_username, Integer.parseInt(offer_id));
        }

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
        model.put("purchasable", false);

        return "offer";
    }
}