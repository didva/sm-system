package dmytro.mudrov.sm.dao;

import java.util.List;

import org.springframework.data.repository.Repository;
import org.springframework.security.core.userdetails.User;

public interface UserDAO extends Repository<User, String> {

    User findOne(String name);

    void insert(User user);

    boolean exists(String id);

    List<User> findAll();

}
