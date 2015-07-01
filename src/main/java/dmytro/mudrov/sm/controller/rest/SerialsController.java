package dmytro.mudrov.sm.controller.rest;

import java.util.List;

import dmytro.mudrov.sm.dao.SerialsDAO;
import dmytro.mudrov.sm.model.Serial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/serials")
public class SerialsController {

    @Autowired
    private SerialsDAO serialsDAO;

    @RequestMapping
    public List<Serial> getSerials() {
        return serialsDAO.findAll();
    }

    @RequestMapping("/${id}")
    public Serial getSerial(@PathVariable String id) {
        return serialsDAO.findOne(id);
    }

}
