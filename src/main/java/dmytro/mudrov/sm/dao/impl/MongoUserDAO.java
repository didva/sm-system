package dmytro.mudrov.sm.dao.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import dmytro.mudrov.sm.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public class MongoUserDAO implements UserDAO {

    public static final String FIELD_USERNAME = "_id";
    public static final String FIELD_PASSWORD = "password";

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public User findOne(String name) {
        return mongoOperations.findById(name, User.class);
    }

    @Override
    public void insert(User user) {
        mongoOperations.insert(user);
    }

    @Override
    public boolean exists(String name) {
        return mongoOperations.exists(query(where(FIELD_USERNAME).is(name)), User.class);
    }

    @Override
    public List<User> findAll() {
        return mongoOperations.findAll(User.class);
    }
}
