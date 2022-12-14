package in.co.sanchay.server.mapper;

import in.co.sanchay.server.dto.auth.model.domain.SanchayResourceLanguageDTO;
import in.co.sanchay.server.dto.auth.model.domain.SanchayResourceLanguageSlimDTO;
import org.modelmapper.PropertyMap;

public class SanchayLanguageDTOToSanchayLanguageSlimDTOMap extends PropertyMap<SanchayResourceLanguageDTO, SanchayResourceLanguageSlimDTO> {
    private SanchayModelMapper modelMapper;

    SanchayLanguageDTOToSanchayLanguageSlimDTOMap(SanchayModelMapper modelMapper)
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
