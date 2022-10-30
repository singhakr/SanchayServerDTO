package in.co.sanchay.server.mapper;

import in.co.sanchay.server.dao.auth.model.domain.SanchayResourceLanguage;
import in.co.sanchay.server.dto.auth.model.domain.SanchayResourceLanguageSlimDTO;
import org.modelmapper.PropertyMap;

public class SanchayLanguageToSanchayLanguageSlimDTOMap extends PropertyMap<SanchayResourceLanguage, SanchayResourceLanguageSlimDTO> {
    private SanchayModelMapper modelMapper;

    SanchayLanguageToSanchayLanguageSlimDTOMap(SanchayModelMapper modelMapper)
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
