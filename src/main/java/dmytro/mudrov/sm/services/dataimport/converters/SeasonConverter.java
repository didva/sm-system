package dmytro.mudrov.sm.services.dataimport.converters;

import dmytro.mudrov.sm.model.Season;
import dmytro.mudrov.sm.services.dataimport.model.SeasonImportData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class SeasonConverter implements Converter<SeasonImportData, Season> {

    @Override
    public Season convert(SeasonImportData source) {
        Season season = new Season();
        season.setNumber(source.getNumber());
        season.setData(source.getData());
        return season;
    }
}
