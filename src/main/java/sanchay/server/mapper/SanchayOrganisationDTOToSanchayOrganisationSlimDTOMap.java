package sanchay.server.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import sanchay.server.dto.auth.model.domain.SanchayOrganisationDTO;
import sanchay.server.dto.auth.model.domain.SanchayOrganisationSlimDTO;

public class SanchayOrganisationDTOToSanchayOrganisationSlimDTOMap extends PropertyMap<SanchayOrganisationDTO, SanchayOrganisationSlimDTO> {
    private SanchayModelMapper modelMapper;

    SanchayOrganisationDTOToSanchayOrganisationSlimDTOMap(SanchayModelMapper modelMapper)
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
