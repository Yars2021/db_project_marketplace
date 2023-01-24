package ru.itmo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itmo.service.LoginService;

@Controller
@SessionAttributes("session_username")
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
    public String showLoginPage(ModelMap model, @RequestParam String session_username, @RequestParam String password) {
        boolean isValidUser = loginService.validateUser(session_username, password);

        if (isValidUser) model.put("user_status", "Logged in");
        else {
            model.put("user_status", "Invalid Credentials");
            model.put("session_username", "");
            return "login";
        }

        model.put("session_username", session_username);
        model.put("username", loginService.getUsernameByLogin(session_username));
        model.put("password", password);

        return "login";
    }
}