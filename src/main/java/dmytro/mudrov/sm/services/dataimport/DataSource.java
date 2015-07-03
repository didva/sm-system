package dmytro.mudrov.sm.services.dataimport;

import java.util.List;

import dmytro.mudrov.sm.services.dataimport.model.SerialImportData;

public interface DataSource {

    List<SerialImportData> getSerials();

}
