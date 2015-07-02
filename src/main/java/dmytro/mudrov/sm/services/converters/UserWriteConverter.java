package dmytro.mudrov.sm.services.converters;

import dmytro.mudrov.sm.dao.impl.MongoUserDAO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.User;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class UserWriteConverter implements Converter<User, DBObject> {

    @Override
    public DBObject convert(User source) {
        DBObject dbo = new BasicDBObject();
        dbo.put(MongoUserDAO.FIELD_USERNAME, source.getUsername());
        dbo.put(MongoUserDAO.FIELD_PASSWORD, source.getPassword());
        return dbo;
    }

}
