package dmytro.mudrov.sm.services.dataimport.converters;

import dmytro.mudrov.sm.model.Series;
import dmytro.mudrov.sm.services.dataimport.model.SeriesImportData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class SeriesConverter implements Converter<SeriesImportData, Series> {

    @Override
    public Series convert(SeriesImportData source) {
        Series series = new Series();
        series.setName(source.getName());
        series.setData(source.getData());
        series.setNumber(source.getNumber());
        return series;
    }
}
