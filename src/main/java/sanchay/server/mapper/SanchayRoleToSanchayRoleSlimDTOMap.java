package sanchay.server.mapper;

import org.modelmapper.PropertyMap;
import sanchay.server.dao.auth.model.domain.SanchayRole;
import sanchay.server.dto.auth.model.domain.SanchayRoleDTO;
import sanchay.server.dto.auth.model.domain.SanchayRoleSlimDTO;

public class SanchayRoleToSanchayRoleSlimDTOMap extends PropertyMap<SanchayRole, SanchayRoleSlimDTO> {
    private SanchayModelMapper modelMapper;

    SanchayRoleToSanchayRoleSlimDTOMap(SanchayModelMapper modelMapper)
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
