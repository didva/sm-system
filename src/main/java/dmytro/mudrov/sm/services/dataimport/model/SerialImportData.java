package dmytro.mudrov.sm.services.dataimport.model;

import java.util.ArrayList;
import java.util.List;

public class SerialImportData {

    private String id;
    private String name;
    private String originalName;
    private String description;
    private List<SeasonImportData> seasons = new ArrayList<>();

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

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
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
