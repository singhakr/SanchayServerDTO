package in.co.sanchay.server.mapper;

import in.co.sanchay.server.dao.auth.model.domain.SanchayOrganisation;
import in.co.sanchay.server.dto.auth.model.domain.SanchayOrganisationDTO;
import org.modelmapper.PropertyMap;

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
