package dmytro.mudrov.sm.services.dataimport.datasource;

import java.util.List;

import dmytro.mudrov.sm.services.dataimport.model.SerialImportData;

public interface DataSource {

    List<SerialImportData> getSerials() throws Exception;

}
