package in.co.sanchay.server.mapper;

import in.co.sanchay.server.dao.auth.model.domain.SanchayOrganisation;
import in.co.sanchay.server.dto.auth.model.domain.SanchayOrganisationSlimDTO;
import org.modelmapper.PropertyMap;

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
