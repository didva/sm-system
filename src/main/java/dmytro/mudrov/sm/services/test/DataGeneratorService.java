package dmytro.mudrov.sm.services.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import dmytro.mudrov.sm.dao.SeasonsDAO;
import dmytro.mudrov.sm.dao.SerialsDAO;
import dmytro.mudrov.sm.model.Season;
import dmytro.mudrov.sm.model.Serial;
import dmytro.mudrov.sm.services.dataimport.DataSource;
import dmytro.mudrov.sm.services.dataimport.model.SeasonImportData;
import dmytro.mudrov.sm.services.dataimport.model.SerialImportData;
import dmytro.mudrov.sm.services.dataimport.model.SeriesImportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataGeneratorService implements DataSource {

    @Autowired
    private SerialsDAO serialsDAO;
    @Autowired
    private SeasonsDAO seasonsDAO;

    /**
     * Generate 1 new serial with 1 season and 1 series.
     * Add 1 season to all existing serials.
     * Add 1 series to all existing seasons.
     */
    @Override
    public List<SerialImportData> getSerials() {
        final List<SerialImportData> serialImportData = new ArrayList<>();
        serialImportData.add(getSerial());
        seasonsDAO.findAll().stream().forEach(season -> {
            SerialImportData serial = getSerialImportData(season.getSerial());
            List<SeasonImportData> seasons = new ArrayList<>(serial.getSeasons());
            seasons.add(getSeasonImportData(season));
            serial.setSeasons(seasons);
            serialImportData.add(serial);
        });
        return serialImportData;
    }

    private SerialImportData getSerial() {
        SerialImportData serialImportData = new SerialImportData();
        serialImportData.setName(UUID.randomUUID().toString());
        serialImportData.setDescription(UUID.randomUUID().toString());
        serialImportData.setSeasons(Arrays.asList(getSeason()));
        return serialImportData;
    }

    private SeasonImportData getSeason() {
        SeasonImportData seasonImportData = new SeasonImportData();
        seasonImportData.setNumber((int) (Math.random() * 100000));
        seasonImportData.setData(getData());
        seasonImportData.setSeries(Arrays.asList(getSeries()));
        return seasonImportData;
    }

    private SeriesImportData getSeries() {
        SeriesImportData seriesImportData = new SeriesImportData();
        seriesImportData.setData(getData());
        seriesImportData.setName(UUID.randomUUID().toString());
        seriesImportData.setNumber((int) (Math.random() * 100000));
        return seriesImportData;
    }

    private byte[] getData() {
        byte[] arr = new byte[(int) (Math.random() * 1000)];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (byte) (Math.random() * 300);
        }
        return arr;
    }

    private SeasonImportData getSeasonImportData(Season season) {
        SeasonImportData seasonImportData = new SeasonImportData();
        seasonImportData.setData(season.getData());
        seasonImportData.setNumber(season.getNumber());
        seasonImportData.setSeries(Arrays.asList(getSeries()));
        return seasonImportData;
    }

    private SerialImportData getSerialImportData(Serial serial) {
        SerialImportData serialImportData = new SerialImportData();
        serialImportData.setName(serial.getName());
        serialImportData.setDescription(serial.getDescription());
        serialImportData.setSeasons(Arrays.asList(getSeason()));
        return serialImportData;
    }
}
