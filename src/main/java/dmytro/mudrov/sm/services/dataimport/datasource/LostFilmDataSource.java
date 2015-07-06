package dmytro.mudrov.sm.services.dataimport.datasource;

import java.io.IOException;
import java.util.List;

import dmytro.mudrov.sm.services.dataimport.model.SerialImportData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LostFilmDataSource implements DataSource {

    @Value("${lost.film.url.domain}")
    private String domainUrl;
    @Value("${lost.film.url.serials}")
    private String serialsUrl;

    @Autowired
    private LostFilmSerialParser lostFilmSerialParser;

    @Override
    public List<SerialImportData> getSerials() throws IOException {
        Document document = Jsoup.connect(domainUrl + serialsUrl).get();
        Elements serials = document.select(".mid .bb .bb_a");
        return lostFilmSerialParser.parse(serials);
    }
}
