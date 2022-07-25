package sanchay.server.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import sanchay.server.dao.auth.model.domain.SanchayRole;
import sanchay.server.dao.auth.model.domain.SanchayUser;
import sanchay.server.dto.auth.model.domain.SanchayRoleDTO;
import sanchay.server.dto.auth.model.domain.SanchayRoleSlimDTO;
import sanchay.server.dto.auth.model.domain.SanchayUserSlimDTO;

import java.util.Map;

public class SanchayRoleToSanchayRoleDTOMap extends PropertyMap<SanchayRole, SanchayRoleDTO> {
    private SanchayModelMapper modelMapper;

    SanchayRoleToSanchayRoleDTOMap(SanchayModelMapper modelMapper)
    {
        super();

        modelMapper.addMappings(this);

        this.modelMapper = modelMapper;
    }

    protected void configure() {
        map().setId(source.getId());
        map().setVersion(source.getVersion());
        map().setName(source.getName());

        Map<String, SanchayUser> userMap = source.getUsers();
        Map<String, SanchayUserSlimDTO> userSlimDTOMap = SanchayMapperUtils.convertMap(userMap, SanchayUserSlimDTO.class, modelMapper);

        map().setUsers(userSlimDTOMap);
    }
}
