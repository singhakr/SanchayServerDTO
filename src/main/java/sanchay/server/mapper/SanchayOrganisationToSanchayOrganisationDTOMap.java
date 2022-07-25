package sanchay.server.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import sanchay.server.dao.auth.model.domain.SanchayOrganisation;
import sanchay.server.dao.auth.model.domain.SanchayRole;
import sanchay.server.dto.auth.model.domain.SanchayOrganisationDTO;
import sanchay.server.dto.auth.model.domain.SanchayRoleDTO;

public class SanchayOrganisationToSanchayOrganisationDTOMap extends PropertyMap<SanchayOrganisation, SanchayOrganisationDTO> {
    private SanchayModelMapper modelMapper;

    SanchayOrganisationToSanchayOrganisationDTOMap(SanchayModelMapper modelMapper)
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
