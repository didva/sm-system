package dmytro.mudrov.sm.model.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserDTO {

    private String username;
    private String[] userRoles;

    public UserDTO(User src) {
        username = src.getUsername();
        Collection<GrantedAuthority> authorities = src.getAuthorities();
        if (authorities != null) {
            userRoles = (String[]) authorities.stream().map(GrantedAuthority::getAuthority).toArray();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String[] getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String[] userRoles) {
        this.userRoles = userRoles;
    }
}
