package dmytro.mudrov.sm.services.dataimport.model;

import java.util.List;

public class SeasonImportData {

    private int number;
    private byte[] data;
    private List<SeriesImportData> series;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
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
