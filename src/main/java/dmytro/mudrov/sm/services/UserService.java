package dmytro.mudrov.sm.services;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import dmytro.mudrov.sm.dao.impl.MongoUserDAO;
import dmytro.mudrov.sm.model.UserRoles;
import dmytro.mudrov.sm.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MongoUserDAO mongoUserDAO;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return mongoUserDAO.findOne(username);
    }

    public void createUser(String username, String password) {
        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(UserRoles.USER));
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(username, encodedPassword, authorities);
        mongoUserDAO.insert(user);
    }

    public List<UserDTO> findAll() {
        return mongoUserDAO.findAll().stream().map(UserDTO::new).collect(toList());
    }

}
