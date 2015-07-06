package dmytro.mudrov.sm.services.dataimport.model;

import java.util.ArrayList;
import java.util.List;

public class SeasonImportData {

    private double number;
    private byte[] data;
    private List<SeriesImportData> series = new ArrayList<>();

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

    public List<SeriesImportData> getSeries() {
        return series;
    }

    public void setSeries(List<SeriesImportData> series) {
        this.series = series;
    }
}
