package dmytro.mudrov.sm.services.converters;

import java.util.Arrays;

import dmytro.mudrov.sm.dao.impl.MongoUserDAO;
import dmytro.mudrov.sm.model.UserRoles;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.mongodb.DBObject;

public class UserReadConverter implements Converter<DBObject, User> {

    @Override
    public User convert(DBObject source) {
        return new User((String) source.get(MongoUserDAO.FIELD_USERNAME),
                (String) source.get(MongoUserDAO.FIELD_PASSWORD),
                Arrays.asList(new SimpleGrantedAuthority(UserRoles.USER)));
    }

}
