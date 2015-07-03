package dmytro.mudrov.sm.model.dto;

import dmytro.mudrov.sm.model.Series;

public class SeriesDTO {

    private String id;
    private int number;
    private String name;

    public SeriesDTO(Series series) {
        id = series.getId();
        name = series.getName();
        number = series.getNumber();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
