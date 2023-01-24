package ru.itmo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itmo.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {
        boolean isValidUser = loginService.validateUser(name, password);

        if (!isValidUser) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }

        model.put("name", name);
        model.put("password", password);

        return "offers";
    }
}