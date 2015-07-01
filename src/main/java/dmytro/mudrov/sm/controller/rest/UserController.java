package dmytro.mudrov.sm.controller.rest;

import java.util.List;

import dmytro.mudrov.sm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public List<User> getUsers() {
        return userService.findAll();
    }
}