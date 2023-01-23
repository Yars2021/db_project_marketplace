package ru.itmo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    public AppController() {
    }

//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("user")
//                .authorities("ROLE_USER")
//                .and()
//                .withUser("admin")
//                .password("admin")
//                .authorities("ROLE_ADMIN");
//    }

    @GetMapping(path = "/login", produces = MediaType.TEXT_HTML_VALUE)
    public String loginPage() {
        return "login";
    }

    @GetMapping(path = "/register", produces = MediaType.TEXT_HTML_VALUE)
    public String registrationPage() {
        return "register";
    }



    @GetMapping(path = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String mainOfferPage() {
        return "main";
    }

    @GetMapping(path = "/offers/{offer_id}", produces = MediaType.TEXT_HTML_VALUE)
    public String offerPage(@PathVariable(name = "offer_id") Long offer_id) {
        return "offer " + offer_id.toString();
    }

    @GetMapping(path = "/users/{user_id}", produces = MediaType.TEXT_HTML_VALUE)
    public String profilePage(@PathVariable(name = "user_id") String user_id) {
        return "user " + user_id.toString();
    }

    @GetMapping(path = "/users/{user_id}/deals", produces = MediaType.TEXT_HTML_VALUE)
    public String dealsPage(@PathVariable(name = "user_id") String user_id) {
        return "deals of " + user_id.toString();
    }

    @GetMapping(path = "/users/{user_id}/offers", produces = MediaType.TEXT_HTML_VALUE)
    public String offersPage(@PathVariable(name = "user_id") String user_id) {
        return "offers of " + user_id.toString();
    }

    @GetMapping(path = "/create", produces = MediaType.TEXT_HTML_VALUE)
    public String packCreationPage() {
        return "creating an offer";
    }
}
