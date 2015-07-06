package dmytro.mudrov.sm.dao;

import java.util.List;

import dmytro.mudrov.sm.model.Season;
import dmytro.mudrov.sm.model.Serial;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeasonsDAO extends MongoRepository<Season, String> {

    List<Season> findBySerialOrderByNumberDesc(Serial serial);

    Season findBySerialAndNumber(Serial serial, double number);

}
