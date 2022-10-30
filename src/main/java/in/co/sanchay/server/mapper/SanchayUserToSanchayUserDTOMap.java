package in.co.sanchay.server.mapper;

import in.co.sanchay.server.dao.auth.model.domain.*;
import in.co.sanchay.server.dto.auth.model.domain.*;
import org.modelmapper.PropertyMap;
import in.co.sanchay.server.dao.auth.model.domain.*;
import in.co.sanchay.server.dto.auth.model.domain.*;

import java.util.Map;

public class SanchayUserToSanchayUserDTOMap extends PropertyMap<SanchayUser, SanchayUserDTO> {

    private SanchayModelMapper modelMapper;

    SanchayUserToSanchayUserDTOMap(SanchayModelMapper modelMapper)
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

        Map<String, SanchayRole> roleMap = source.getRoles();
        Map<String, SanchayRoleSlimDTO> roleSlimDTOMap = SanchayMapperUtils.convertMap(roleMap, SanchayRoleSlimDTO.class, modelMapper);

        map().setRoles(roleSlimDTOMap);

        Map<String, SanchayOrganisation> organisationMap = source.getOrganisations();
        Map<String, SanchayOrganisationSlimDTO> organisationSlimDTOMap = SanchayMapperUtils.convertMap(organisationMap, SanchayOrganisationSlimDTO.class, modelMapper);

        map().setOrganisations(organisationSlimDTOMap);

        Map<String, SanchayResourceLanguage> languageMap = source.getLanguages();
        Map<String, SanchayResourceLanguageSlimDTO> languageSlimDTOMap = SanchayMapperUtils.convertMap(languageMap, SanchayResourceLanguageSlimDTO.class, modelMapper);

        map().setLanguages(languageSlimDTOMap);

        Map<String, SanchayAnnotationLevel> levelMap = source.getAnnotationLevels();
        Map<String, SanchayAnnotationLevelSlimDTO> levelSlimDTOMap = SanchayMapperUtils.convertMap(levelMap, SanchayAnnotationLevelSlimDTO.class, modelMapper);

        map().setAnnotationLevels(levelSlimDTOMap);
    }
}
