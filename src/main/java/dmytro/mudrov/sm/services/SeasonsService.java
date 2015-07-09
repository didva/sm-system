package dmytro.mudrov.sm.services;

import java.util.ArrayList;
import java.util.List;

import dmytro.mudrov.sm.dao.SeasonsDAO;
import dmytro.mudrov.sm.dao.SerialsDAO;
import dmytro.mudrov.sm.model.Serial;
import dmytro.mudrov.sm.model.dto.SeasonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeasonsService {

    @Autowired
    private SerialsDAO serialsDAO;
    @Autowired
    private SeasonsDAO seasonsDAO;
    @Autowired
    private SeriesService seriesService;

    public List<SeasonDTO> findAll(String serialId) {
        Serial serial = serialsDAO.findOne(serialId);
        return findAll(serial);
    }

    public List<SeasonDTO> findAll(Serial serial) {
        if (serial == null) {
            throw new IllegalArgumentException();
        }
        List<SeasonDTO> seasons = new ArrayList<>();
        seasonsDAO.findBySerialOrderByNumberDesc(serial).forEach(s -> {
            SeasonDTO seasonDTO = new SeasonDTO(s);
            seasonDTO.setSeries(seriesService.findBySeason(s));
            seasons.add(seasonDTO);
        });
        return seasons;
    }

}
