package sanchay.server.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import sanchay.server.dao.auth.model.domain.SanchayAnnotationLevel;
import sanchay.server.dto.auth.model.domain.SanchayAnnotationLevelDTO;

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
