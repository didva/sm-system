package dmytro.mudrov.sm.services;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dmytro.mudrov.sm.dao.SeasonsDAO;
import dmytro.mudrov.sm.dao.SerialsDAO;
import dmytro.mudrov.sm.dao.SeriesDAO;
import dmytro.mudrov.sm.model.Season;
import dmytro.mudrov.sm.model.Serial;
import dmytro.mudrov.sm.model.Series;
import dmytro.mudrov.sm.model.dto.SeriesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeriesService {

    @Autowired
    private SeriesDAO seriesDAO;
    @Autowired
    private SerialsDAO serialsDAO;
    @Autowired
    private SeasonsDAO seasonsDAO;

    public List<SeriesDTO> findAll(String serialId) {
        Serial serial = serialsDAO.findOne(serialId);
        if (serial == null) {
            throw new IllegalArgumentException();
        }
        List<SeriesDTO> series = new ArrayList<>();
        List<Season> seasons = seasonsDAO.findBySerialOrderByNumberDesc(serial);
        seasons.stream().map(seriesDAO::findBySeasonOrderByNumberDesc)
                .forEach(s -> series.addAll(s.stream().map(SeriesDTO::new).collect(toList())));
        return series;
    }

    public List<SeriesDTO> findBySeason(Season season) {
        return seriesDAO.findBySeasonOrderByNumberDesc(season).stream().map(SeriesDTO::new).collect(toList());
    }

    public Series findByNumber(Season season, int number) {
        return seriesDAO.findBySeasonAndNumber(season, number);
    }

    public Series findById(String seriesId) {
        return seriesDAO.findOne(seriesId);
    }

    public void saveAll(Collection<Series> series) {
        seriesDAO.save(series);
    }
}
