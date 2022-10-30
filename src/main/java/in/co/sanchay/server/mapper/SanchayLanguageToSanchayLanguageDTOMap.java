package in.co.sanchay.server.mapper;

import in.co.sanchay.server.dao.auth.model.domain.SanchayResourceLanguage;
import in.co.sanchay.server.dto.auth.model.domain.SanchayResourceLanguageDTO;
import org.modelmapper.PropertyMap;

public class SanchayLanguageToSanchayLanguageDTOMap extends PropertyMap<SanchayResourceLanguage, SanchayResourceLanguageDTO> {
    private SanchayModelMapper modelMapper;

    SanchayLanguageToSanchayLanguageDTOMap(SanchayModelMapper modelMapper)
    {
        super();

        modelMapper.addMappings(this);

        this.modelMapper = modelMapper;
    }

    protected void configure() {
        map().setId(source.getId());
        map().setVersion(source.getVersion());
        map().setName(source.getName());
    }
}
