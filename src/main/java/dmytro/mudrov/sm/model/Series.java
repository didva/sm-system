package dmytro.mudrov.sm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.common.base.Objects;

@Document(collection = "series")
public class Series {

    @Id
    private String id;
    private Serial serial;
    private String name;
    private byte[] data;

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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
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
                Objects.equal(this.serial, that.serial) &&
                Objects.equal(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, serial, name);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("id", id).add("serial", serial).add("name", name).toString();
    }
}
