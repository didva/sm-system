package dmytro.mudrov.sm.services.dataimport;

import java.util.ArrayList;
import java.util.List;

import dmytro.mudrov.sm.dao.SeasonsDAO;
import dmytro.mudrov.sm.dao.SerialsDAO;
import dmytro.mudrov.sm.model.Season;
import dmytro.mudrov.sm.model.Serial;
import dmytro.mudrov.sm.model.Series;
import dmytro.mudrov.sm.services.SeriesService;
import dmytro.mudrov.sm.services.dataimport.converters.SeasonConverter;
import dmytro.mudrov.sm.services.dataimport.converters.SerialConverter;
import dmytro.mudrov.sm.services.dataimport.converters.SeriesConverter;
import dmytro.mudrov.sm.services.dataimport.model.SeasonImportData;
import dmytro.mudrov.sm.services.dataimport.model.SerialImportData;
import dmytro.mudrov.sm.services.dataimport.model.SeriesImportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataAggregator {

    @Autowired
    private SeriesService seriesService;
    @Autowired
    private SeasonsDAO seasonsDAO;
    @Autowired
    private SerialsDAO serialsDAO;

    @Autowired
    private SerialConverter serialConverter;
    @Autowired
    private SeasonConverter seasonConverter;
    @Autowired
    private SeriesConverter seriesConverter;

    public List<Series> aggregateData(List<SerialImportData> serialsData) {
        List<Series> seriesList = new ArrayList<>();
        for (SerialImportData serialData : serialsData) {
            Serial serial = serialsDAO.findByNameIgnoreCase(serialData.getName());
            if (serial == null) {
                serial = serialConverter.convert(serialData);
            }
            for (SeasonImportData seasonData : serialData.getSeasons()) {
                Season season = null;
                if (serial.getId() != null) {
                    season = seasonsDAO.findBySerialAndNumber(serial, seasonData.getNumber());
                }
                if (season == null) {
                    season = seasonConverter.convert(seasonData);
                }
                season.setSerial(serial);
                for (SeriesImportData seriesData : seasonData.getSeries()) {
                    Series series = null;
                    if (season.getId() != null) {
                        series = seriesService.findByName(season, serialData.getName());
                    }
                    if (series == null) {
                        series = seriesConverter.convert(seriesData);
                    }
                    series.setSeason(season);
                    seriesList.add(series);
                }
            }
        }
        return seriesList;
    }

}
