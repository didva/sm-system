package dmytro.mudrov.sm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.google.common.base.Objects;

public class Series {

    @Id
    private String id;
    private int number;
    private String name;
    @DBRef
    private Season season;
    private byte[] data;

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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFileName() {
        return name.replaceAll(" ", "_") + ".torrent";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Series that = (Series) o;

        return Objects.equal(this.id, that.id) &&
                Objects.equal(this.name, that.name) &&
                Objects.equal(this.season, that.season) &&
                Objects.equal(this.number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, season, number);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("id", id).add("number", number).add("name", name).add("season", season)
                .toString();
    }
}
