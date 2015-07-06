package dmytro.mudrov.sm.controller.rest;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import dmytro.mudrov.sm.dao.SerialsDAO;
import dmytro.mudrov.sm.model.Serial;
import dmytro.mudrov.sm.model.dto.SeriesDTO;
import dmytro.mudrov.sm.services.SeriesService;
import dmytro.mudrov.sm.services.dataimport.DataImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/import")
public class ImporterController {

    @Autowired
    private DataImporter dataImporter;
    @Autowired
    private SeriesService seriesService;
    @Autowired
    private SerialsDAO serialsDAO;

    @RequestMapping(method = RequestMethod.POST)
    public List<SeriesDTO> generateSerials() throws Exception {
        dataImporter.importData();
        List<SeriesDTO> seriesList = new ArrayList<>();
        serialsDAO.findAll().stream().map(Serial::getId).collect(toList()).stream().map(seriesService::findAll)
                .forEach(seriesList::addAll);
        return seriesList;
    }

}
