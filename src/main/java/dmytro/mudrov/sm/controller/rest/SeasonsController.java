package dmytro.mudrov.sm.controller.rest;

import java.util.List;

import dmytro.mudrov.sm.model.dto.SeasonDTO;
import dmytro.mudrov.sm.services.SeasonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/seasons/{serialId}")
public class SeasonsController {

    @Autowired
    private SeasonsService seasonsService;

    @RequestMapping
    public List<SeasonDTO> getSerials(@PathVariable("serialId") String serialId) {
        return seasonsService.findAll(serialId);
    }
}
