package sanchay.server.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import sanchay.server.dto.auth.model.domain.SanchayResourceLanguageDTO;
import sanchay.server.dto.auth.model.domain.SanchayResourceLanguageSlimDTO;

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
