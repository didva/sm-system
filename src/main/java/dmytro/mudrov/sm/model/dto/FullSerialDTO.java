package dmytro.mudrov.sm.model.dto;

import java.util.List;

import dmytro.mudrov.sm.model.Serial;

public class FullSerialDTO extends BaseSerialDTO {

    private String description;
    private List<SeasonDTO> seasons;

    public FullSerialDTO(Serial serial, List<SeasonDTO> seasons) {
        super(serial);
        this.description = serial.getDescription();
        this.seasons = seasons;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SeasonDTO> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<SeasonDTO> seasons) {
        this.seasons = seasons;
    }
}
