package in.co.sanchay.server.mapper;

import in.co.sanchay.server.dao.auth.model.domain.SanchayAnnotationLevel;
import in.co.sanchay.server.dto.auth.model.domain.SanchayAnnotationLevelSlimDTO;
import org.modelmapper.PropertyMap;

public class SanchayALevelToSanchayALevelSlimDTOMap extends PropertyMap<SanchayAnnotationLevel, SanchayAnnotationLevelSlimDTO> {
    private SanchayModelMapper modelMapper;

    SanchayALevelToSanchayALevelSlimDTOMap(SanchayModelMapper modelMapper)
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
