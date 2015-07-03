package dmytro.mudrov.sm.services.dataimport.converters;

import dmytro.mudrov.sm.model.Serial;
import dmytro.mudrov.sm.services.dataimport.model.SerialImportData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class SerialConverter implements Converter<SerialImportData, Serial> {

    @Override
    public Serial convert(SerialImportData source) {
        Serial serial = new Serial();
        serial.setName(source.getName());
        serial.setDescription(source.getDescription());
        return serial;
    }

}
