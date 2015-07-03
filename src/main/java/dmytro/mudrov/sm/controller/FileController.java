package dmytro.mudrov.sm.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import dmytro.mudrov.sm.model.Series;
import dmytro.mudrov.sm.services.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/files")
public class FileController {

    @Autowired
    private SeriesService seriesService;

    @RequestMapping("/series/{seriesId}")
    public void getSeriesFile(@PathVariable String seriesId, HttpServletResponse response) throws IOException {
        Series series = seriesService.findById(seriesId);
        if (series == null) {
            throw new IllegalArgumentException();
        }
        response.setContentType("application-xdownload");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + series.getFileName() + "\"");
        response.getOutputStream().write(series.getData());
    }

}
