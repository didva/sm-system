package dmytro.mudrov.sm.controller.rest;

import java.util.List;

import dmytro.mudrov.sm.model.dto.UserDTO;
import dmytro.mudrov.sm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public List<UserDTO> getUsers() {
        return userService.findAll();
    }
}
