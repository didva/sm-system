package dmytro.mudrov.sm.services;

import static java.util.stream.Collectors.toList;

import java.util.List;

import dmytro.mudrov.sm.dao.SerialsDAO;
import dmytro.mudrov.sm.model.Serial;
import dmytro.mudrov.sm.model.dto.BaseSerialDTO;
import dmytro.mudrov.sm.model.dto.FullSerialDTO;
import dmytro.mudrov.sm.model.dto.SeasonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerialsService {

    @Autowired
    private SerialsDAO serialsDAO;
    @Autowired
    private SeasonsService seasonsService;

    public FullSerialDTO getSerial(String serialId) {
        Serial serial = serialsDAO.findOne(serialId);
        List<SeasonDTO> seasons = seasonsService.findAll(serial);
        return new FullSerialDTO(serial, seasons);
    }

    public List<BaseSerialDTO> getAllSerials() {
        List<Serial> serials = serialsDAO.findAll();
        return serials.stream().map(BaseSerialDTO::new).collect(toList());
    }
}
