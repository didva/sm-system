package dmytro.mudrov.sm.services.dataimport.datasource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dmytro.mudrov.sm.services.dataimport.model.SeasonImportData;
import dmytro.mudrov.sm.services.dataimport.model.SerialImportData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LostFilmSerialParser {

    @Value("${lost.film.url.domain}")
    private String domainUrl;
    @Value("${lost.film.url.serial}")
    private String serialUrl;

    @Autowired
    private LostFilmSeasonsParser lostFilmSeasonsParser;

    public List<SerialImportData> parse(Elements serials) throws IOException {
        List<SerialImportData> serialsImportData = new ArrayList<>();
        for (Element serial : serials) {
            String serialId = serial.attr("href").replace(serialUrl, "");
            String oName = serial.select("span").first().text().trim();
            String name = serial.text().replace(oName, "").trim();
            Document document = Jsoup.connect(domainUrl + serialUrl + serialId).get();
            Element seasons = document.select(".mid > div:has(div.t_row)").first();
            List<SeasonImportData> seasonsImportData = lostFilmSeasonsParser.parse(serialId, seasons);

            SerialImportData serialImportData = getSerials(serialId, oName, name, document, seasonsImportData);
            serialsImportData.add(serialImportData);
        }
        return serialsImportData;
    }

    private SerialImportData getSerials(String sId, String oName, String name, Document doc,
            List<SeasonImportData> seasons) {
        SerialImportData serialImportData = new SerialImportData();
        serialImportData.setId(sId);
        serialImportData.setName(name);
        serialImportData.setOriginalName(oName.substring(1, oName.length() - 1).trim());
        serialImportData.setDescription(doc.select(".content + span").text().trim());
        serialImportData.getSeasons().addAll(seasons);
        return serialImportData;
    }

}
