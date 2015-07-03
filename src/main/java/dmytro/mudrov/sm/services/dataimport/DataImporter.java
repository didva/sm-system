package dmytro.mudrov.sm.services.dataimport;

import java.util.List;

import dmytro.mudrov.sm.dao.SeasonsDAO;
import dmytro.mudrov.sm.dao.SerialsDAO;
import dmytro.mudrov.sm.model.Season;
import dmytro.mudrov.sm.model.Series;
import dmytro.mudrov.sm.services.SeriesService;
import dmytro.mudrov.sm.services.dataimport.model.SerialImportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataImporter {

    @Autowired
    private SeriesService seriesService;
    @Autowired
    private SeasonsDAO seasonsDAO;
    @Autowired
    private SerialsDAO serialsDAO;

    @Autowired
    private DataSource dataSource;
    @Autowired
    private DataAggregator dataAggregator;

    public void importData() {
        List<SerialImportData> serialsData = dataSource.getSerials();
        List<Series> aggregatedData = dataAggregator.aggregateData(serialsData);
        aggregatedData.stream().forEach(series -> {
            Season season = series.getSeason();
            season.setSerial(serialsDAO.save(season.getSerial()));
            series.setSeason(seasonsDAO.save(season));
        });
        seriesService.saveAll(aggregatedData);
    }
}
