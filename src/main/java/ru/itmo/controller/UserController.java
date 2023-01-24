package ru.itmo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itmo.db.InternalItem;
import ru.itmo.service.ItemService;
import ru.itmo.service.UserService;
import ru.itmo.transfer.FormattedItem;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;
    private ItemService itemService;

    public UserController(UserService userService, ItemService itemService) {
        this.userService = userService;
        this.itemService = itemService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public ItemService getItemService() {
        return itemService;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value="/users/{user_id}", method = RequestMethod.GET)
    public String showUserPage(ModelMap model, @PathVariable(name = "user_id") String user_id) {
        String username = "";
        Integer balance = 0, b_rep = 0, s_rep = 0;
        List<FormattedItem> items = new ArrayList<>();

        if (userService != null) {
            username = userService.getUsername(user_id);
            balance = userService.getBalance(user_id);
            b_rep = userService.getBuyerReputation(user_id);
            s_rep = userService.getSalesmanReputation(user_id);
            if (itemService != null) {
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
        }

        model.put("prof_id", user_id);
        model.put("username", username);
        model.put("balance", balance);
        model.put("b_rep", b_rep);
        model.put("s_rep", s_rep);
        model.put("items", items);

        return "user";
    }
}