package dmytro.mudrov.sm.services;

import static java.util.stream.Collectors.toList;

import java.util.List;

import dmytro.mudrov.sm.dao.SerialsDAO;
import dmytro.mudrov.sm.dao.SeriesDAO;
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

    public List<SeriesDTO> findAll(String serialId) {
        Serial serial = serialsDAO.findOne(serialId);
        if (serial == null) {
            throw new IllegalArgumentException();
        }
        return seriesDAO.findBySerial(serial).stream().map(SeriesDTO::new).collect(toList());
    }

    public Series findById(String seriesId) {
        return seriesDAO.findOne(seriesId);
    }
}
