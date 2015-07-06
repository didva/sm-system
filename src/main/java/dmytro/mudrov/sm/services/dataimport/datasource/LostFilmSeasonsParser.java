package dmytro.mudrov.sm.services.dataimport.datasource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dmytro.mudrov.sm.services.dataimport.model.SeasonImportData;
import dmytro.mudrov.sm.services.dataimport.model.SeriesImportData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LostFilmSeasonsParser {

    @Value("${lost.film.url.domain}")
    private String domainUrl;
    @Value("${lost.film.url.download}")
    private String downloadUrl;
    @Value("${lost.film.uid}")
    private String uid;
    @Value("${lost.film.password}")
    private String password;

    public List<SeasonImportData> parse(String serialId, Element seasons) throws IOException {
        List<SeasonImportData> seasonsData = new ArrayList<>();
        SeasonImportData seasonData = null;
        for (Element item : seasons.children()) {
            if (isSeasonInfoDiv(item)) {
                if (seasonData != null) {
                    seasonsData.add(seasonData);
                }
                seasonData = getSeasonImportData(item);
            } else {
                fillEpisodesData(serialId, seasonData, item);
            }
        }
        if (seasonData != null) {
            seasonsData.add(seasonData);
        }
        return seasonsData;
    }

    private SeasonImportData getSeasonImportData(Element item) {
        try {
            SeasonImportData seasonImportData = new SeasonImportData();
            seasonImportData.setNumber(Integer.valueOf(item.text().split(" ")[0]));
            return seasonImportData;
        } catch (Exception e) {
            return null;
        }
    }

    private void fillEpisodesData(String serialId, SeasonImportData seasonImportData, Element item) throws IOException {
        if (seasonImportData == null) {
            return;
        }
        Element itemTitle = item.select(".t_episode_title").first();
        byte[] data = getTorrentBytes(serialId, seasonImportData, itemTitle);
        Integer episodeNum = getEpisodeNumber(item.select(".t_episode_num").text().trim());
        if (episodeNum == null) {
            seasonImportData.setData(data);
        } else {
            SeriesImportData seriesImportData = new SeriesImportData();
            seriesImportData.setNumber(episodeNum);
            seriesImportData.setName(itemTitle.select("span").text().trim());
            seriesImportData.setData(data);
            seasonImportData.getSeries().add(seriesImportData);
        }
    }

    private boolean isSeasonInfoDiv(Element item) {
        return item.hasClass("content");
    }

    private byte[] getTorrentBytes(String serialId, SeasonImportData seasonImportData, Element itemTitle)
            throws IOException {
        String itemNo = itemTitle.attr("onclick").split(",")[2].replaceAll("'", "").replaceAll("\\)", "");
        Document document = Jsoup
                .connect(domainUrl + String.format(downloadUrl, serialId, seasonImportData.getNumber(), itemNo))
                .cookie("uid", uid).cookie("pass", password).get();
        String torrentHref = document.select("table a").first().attr("href");
        return Jsoup.connect(torrentHref).ignoreContentType(true).execute().bodyAsBytes();
    }

    private Integer getEpisodeNumber(String str) {
        Integer result = null;
        try {
            result = Integer.parseInt(str);
        } catch (NumberFormatException ignored) {
        }
        return result;
    }
}
