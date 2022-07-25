package sanchay.server.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import sanchay.server.dto.auth.model.domain.SanchayRoleDTO;
import sanchay.server.dto.auth.model.domain.SanchayRoleSlimDTO;

public class SanchayRoleDTOToSanchayRoleSlimDTOMap extends PropertyMap<SanchayRoleDTO, SanchayRoleSlimDTO> {
    private SanchayModelMapper modelMapper;

    SanchayRoleDTOToSanchayRoleSlimDTOMap(SanchayModelMapper modelMapper)
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
