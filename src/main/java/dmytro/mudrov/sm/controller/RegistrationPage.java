package dmytro.mudrov.sm.controller;

import dmytro.mudrov.sm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class RegistrationPage {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public String saveUser(@RequestParam String username, @RequestParam String password) {
        userService.createUser(username, password);
        return "registration";
    }

    @RequestMapping
    public String getRegistrationPage() {
        return "registration";
    }
}
