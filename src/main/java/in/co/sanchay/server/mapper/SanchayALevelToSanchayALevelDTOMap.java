package in.co.sanchay.server.mapper;

import in.co.sanchay.server.dao.auth.model.domain.SanchayAnnotationLevel;
import in.co.sanchay.server.dto.auth.model.domain.SanchayAnnotationLevelDTO;
import org.modelmapper.PropertyMap;

public class SanchayALevelToSanchayALevelDTOMap extends PropertyMap<SanchayAnnotationLevel, SanchayAnnotationLevelDTO> {
    private SanchayModelMapper modelMapper;

    SanchayALevelToSanchayALevelDTOMap(SanchayModelMapper modelMapper)
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
