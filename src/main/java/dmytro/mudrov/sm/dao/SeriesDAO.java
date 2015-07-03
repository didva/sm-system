package dmytro.mudrov.sm.dao;

import java.util.List;

import dmytro.mudrov.sm.model.Season;
import dmytro.mudrov.sm.model.Series;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeriesDAO extends MongoRepository<Series, String> {

    List<Series> findBySeasonOrderByNumberDesc(Season season);

    Series findBySeasonAndNameIgnoreCase(Season season, String name);

}
