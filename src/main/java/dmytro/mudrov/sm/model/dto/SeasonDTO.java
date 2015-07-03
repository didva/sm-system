package dmytro.mudrov.sm.model.dto;

import java.util.List;

import dmytro.mudrov.sm.model.Season;

public class SeasonDTO {

    private String id;
    private int number;
    private List<SeriesDTO> series;

    public SeasonDTO(Season season) {
        id = season.getId();
        number = season.getNumber();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<SeriesDTO> getSeries() {
        return series;
    }

    public void setSeries(List<SeriesDTO> series) {
        this.series = series;
    }
}
