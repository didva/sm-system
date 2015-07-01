package dmytro.mudrov.sm.dao;

import dmytro.mudrov.sm.model.Serial;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SerialsDAO extends MongoRepository<Serial, String> {

    Serial findByNameIgnoreCase(String name);

}
