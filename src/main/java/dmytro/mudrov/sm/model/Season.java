package dmytro.mudrov.sm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.common.base.Objects;

@Document(collection = "seasons")
public class Season {

    @Id
    private String id;
    @DBRef
    private Serial serial;
    private double number;
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

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Season that = (Season) o;

        return Objects.equal(this.id, that.id) &&
                Objects.equal(this.serial, that.serial) &&
                Objects.equal(this.number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, serial, number);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("id", id).add("serial", serial).add("number", number).toString();
    }
}
