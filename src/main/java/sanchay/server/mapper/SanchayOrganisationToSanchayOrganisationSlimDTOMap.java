package sanchay.server.mapper;

import org.modelmapper.PropertyMap;
import sanchay.server.dao.auth.model.domain.SanchayOrganisation;
import sanchay.server.dto.auth.model.domain.SanchayOrganisationDTO;
import sanchay.server.dto.auth.model.domain.SanchayOrganisationSlimDTO;

public class SanchayOrganisationToSanchayOrganisationSlimDTOMap extends PropertyMap<SanchayOrganisation, SanchayOrganisationSlimDTO> {
    private SanchayModelMapper modelMapper;

    SanchayOrganisationToSanchayOrganisationSlimDTOMap(SanchayModelMapper modelMapper)
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
