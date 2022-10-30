package in.co.sanchay.server.mapper;

import in.co.sanchay.server.dto.auth.model.domain.SanchayAnnotationLevelDTO;
import in.co.sanchay.server.dto.auth.model.domain.SanchayAnnotationLevelSlimDTO;
import org.modelmapper.PropertyMap;

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
