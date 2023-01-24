package ru.itmo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itmo.db.InternalItem;
import ru.itmo.service.ItemService;
import ru.itmo.service.OfferService;
import ru.itmo.service.UserService;
import ru.itmo.transfer.FormattedItem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class CreateOfferController {
    private UserService userService;
    private OfferService offerService;
    private ItemService itemService;

    public CreateOfferController(UserService userService, OfferService offerService, ItemService itemService) {
        this.userService = userService;
        this.offerService = offerService;
        this.itemService = itemService;
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

    public ItemService getItemService() {
        return itemService;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value="/users/{user_id}/create", method = RequestMethod.GET)
    public String showCreatePage(ModelMap model, @PathVariable(name = "user_id") String user_id) {
        List<FormattedItem> items = new ArrayList<>();

        if (userService != null && itemService != null) {
            for (InternalItem item : itemService.getUsersItems(user_id)) {
                items.add(new FormattedItem(
                        item.getIid(),
                        itemService.getType(item.getType()),
                        item.getOwner(),
                        item.getName(),
                        itemService.getRarity(item.getRarity()),
                        item.getDescription()));
            }
        }

        model.put("prof_id", user_id);
        model.put("items", items);

        return "create";
    }

    @RequestMapping(value="/users/{user_id}/create", method = RequestMethod.POST)
    public String showCreatePage(ModelMap model, @PathVariable(name = "user_id") String user_id, @RequestParam ArrayList<String> iid, @RequestParam String price) {
        if (userService != null && itemService != null && offerService != null) {
            Set<InternalItem> items_to_sell = new HashSet<>();

            for (String item : iid) {
                items_to_sell.add(itemService.getItemById(Integer.parseInt(item)));
                itemService.removeOwner(Integer.parseInt(item));
            }

            offerService.submitOffer(user_id, Integer.parseInt(price), items_to_sell);
        }

        List<FormattedItem> items = new ArrayList<>();

        if (userService != null && itemService != null) {
            for (InternalItem item : itemService.getUsersItems(user_id)) {
                items.add(new FormattedItem(
                        item.getIid(),
                        itemService.getType(item.getType()),
                        item.getOwner(),
                        item.getName(),
                        itemService.getRarity(item.getRarity()),
                        item.getDescription()));
            }
        }

        model.put("prof_id", user_id);
        model.put("items", items);

        return "create";
    }
}