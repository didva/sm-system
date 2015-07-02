package dmytro.mudrov.sm.model.dto;

import dmytro.mudrov.sm.model.Serial;
import dmytro.mudrov.sm.model.Series;

public class SeriesDTO {

    private String id;
    private Serial serial;
    private String name;

    public SeriesDTO(Series series) {
        id = series.getId();
        serial = series.getSerial();
        name = series.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Serial getSerial() {
        return serial;
    }

    public void setSerial(Serial serial) {
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
