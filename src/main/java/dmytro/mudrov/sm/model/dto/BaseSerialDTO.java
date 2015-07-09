package dmytro.mudrov.sm.model.dto;

import dmytro.mudrov.sm.model.Serial;

public class BaseSerialDTO {

    private String id;
    private String name;
    private String originalName;

    public BaseSerialDTO(Serial serial) {
        id = serial.getId();
        name = serial.getName();
        originalName = serial.getOriginalName();
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

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }
}
