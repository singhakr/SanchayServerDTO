package sanchay.server.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import sanchay.server.dto.auth.model.domain.SanchayAnnotationLevelDTO;
import sanchay.server.dto.auth.model.domain.SanchayAnnotationLevelSlimDTO;

public class SanchayALevelDTOToSanchayALevelSlimDTOMap extends PropertyMap<SanchayAnnotationLevelDTO, SanchayAnnotationLevelSlimDTO> {
    private SanchayModelMapper modelMapper;

    SanchayALevelDTOToSanchayALevelSlimDTOMap(SanchayModelMapper modelMapper)
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
