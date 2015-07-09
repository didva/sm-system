package dmytro.mudrov.sm.controller.rest;

import java.util.List;

import dmytro.mudrov.sm.dao.SerialsDAO;
import dmytro.mudrov.sm.model.Serial;
import dmytro.mudrov.sm.model.dto.BaseSerialDTO;
import dmytro.mudrov.sm.model.dto.FullSerialDTO;
import dmytro.mudrov.sm.services.SerialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/serials")
public class SerialsController {

    @Autowired
    private SerialsService serialsService;

    @RequestMapping
    public List<BaseSerialDTO> getSerials() {
        return serialsService.getAllSerials();
    }

    @RequestMapping("/{id}")
    public FullSerialDTO getSerial(@PathVariable("id") String id) {
        return serialsService.getSerial(id);
    }

}
