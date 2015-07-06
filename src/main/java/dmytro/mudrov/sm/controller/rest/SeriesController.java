package dmytro.mudrov.sm.controller.rest;

import java.util.List;

import dmytro.mudrov.sm.model.dto.SeriesDTO;
import dmytro.mudrov.sm.services.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/series/{serialId}")
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    @RequestMapping
    public List<SeriesDTO> findAll(@PathVariable("serialId") String serialId) {
        return seriesService.findAll(serialId);
    }

}
