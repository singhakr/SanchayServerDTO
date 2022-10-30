package in.co.sanchay.server.mapper;

import in.co.sanchay.server.dao.auth.model.domain.SanchayRole;
import in.co.sanchay.server.dto.auth.model.domain.SanchayRoleSlimDTO;
import org.modelmapper.PropertyMap;

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
