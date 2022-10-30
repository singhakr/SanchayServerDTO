package in.co.sanchay.server.mapper;

import in.co.sanchay.server.dto.auth.model.domain.SanchayRoleDTO;
import in.co.sanchay.server.dto.auth.model.domain.SanchayRoleSlimDTO;
import org.modelmapper.PropertyMap;

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
