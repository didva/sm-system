package dmytro.mudrov.sm.services.test;

import java.util.UUID;

import dmytro.mudrov.sm.dao.SerialsDAO;
import dmytro.mudrov.sm.dao.SeriesDAO;
import dmytro.mudrov.sm.model.Serial;
import dmytro.mudrov.sm.model.Series;
import dmytro.mudrov.sm.model.dto.SeriesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataGeneratorService {

    @Autowired
    private SerialsDAO serialsDAO;
    @Autowired
    private SeriesDAO seriesDAO;

    public Serial addSerial() {
        Serial serial = new Serial();
        serial.setName(UUID.randomUUID().toString());
        serial.setDescription(UUID.randomUUID().toString());
        return serialsDAO.save(serial);
    }

    public SeriesDTO addSeries(String serialId) {
        Serial serial = serialsDAO.findOne(serialId);
        Series series = new Series();
        series.setName(UUID.randomUUID().toString());
        series.setSerial(serial);
        series.setData(getData());
        return new SeriesDTO(seriesDAO.save(series));
    }

    private byte[] getData() {
        byte[] arr = new byte[(int) (Math.random() * 1000)];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (byte) (Math.random() * 300);
        }
        return arr;
    }
}
