package in.co.sanchay.server.mapper;

import in.co.sanchay.server.dto.auth.model.domain.SanchayOrganisationDTO;
import in.co.sanchay.server.dto.auth.model.domain.SanchayOrganisationSlimDTO;
import org.modelmapper.PropertyMap;

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
