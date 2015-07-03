package dmytro.mudrov.sm.services.dataimport.model;

import java.util.List;

public class SerialImportData {

    private String name;
    private String description;
    private List<SeasonImportData> seasons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SeasonImportData> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<SeasonImportData> seasons) {
        this.seasons = seasons;
    }
}
