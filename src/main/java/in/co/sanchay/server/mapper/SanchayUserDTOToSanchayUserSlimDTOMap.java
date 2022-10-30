package in.co.sanchay.server.mapper;

import in.co.sanchay.server.dto.auth.model.domain.SanchayUserDTO;
import in.co.sanchay.server.dto.auth.model.domain.SanchayUserSlimDTO;
import org.modelmapper.PropertyMap;

public class SanchayUserDTOToSanchayUserSlimDTOMap extends PropertyMap<SanchayUserDTO, SanchayUserSlimDTO>  {
    private SanchayModelMapper modelMapper;

    SanchayUserDTOToSanchayUserSlimDTOMap(SanchayModelMapper modelMapper)
    {
        super();

        modelMapper.addMappings(this);

        this.modelMapper = modelMapper;
    }

    protected void configure() {
        map().setId(source.getId());
        map().setVersion(source.getVersion());
        map().setUsername(source.getUsername());
        map().setEmailAddress(source.getEmailAddress());
        map().setFirstName(source.getFirstName());
        map().setLastName(source.getLastName());
        map().setId(source.getId());
        map().setPassword("");
        map().setEnabled(source.isEnabled());
        map().setTokenExpired(source.isTokenExpired());
        map().setCurrentRoleName(source.getCurrentRoleName());
        map().setCurrentOrganisationName(source.getCurrentOrganisationName());
        map().setCurrentLanguageName(source.getCurrentLanguageName());
        map().setCurrentAnnotationLevelName(source.getCurrentAnnotationLevelName());
    }
}
