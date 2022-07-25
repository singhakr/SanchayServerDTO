package sanchay.server.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import sanchay.server.dao.auth.model.domain.SanchayOrganisation;
import sanchay.server.dao.auth.model.domain.SanchayResourceLanguage;
import sanchay.server.dto.auth.model.domain.SanchayOrganisationDTO;
import sanchay.server.dto.auth.model.domain.SanchayResourceLanguageDTO;

public class SanchayLanguageToSanchayLanguageDTOMap extends PropertyMap<SanchayResourceLanguage, SanchayResourceLanguageDTO> {
    private SanchayModelMapper modelMapper;

    SanchayLanguageToSanchayLanguageDTOMap(SanchayModelMapper modelMapper)
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
