/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanchay.server.dto.auth.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import sanchay.common.dto.json.SanchayUserDTODeserializer;
import sanchay.common.dto.json.SanchayUserDTOSerializer;
import sanchay.server.mapper.SanchayMapperUtils;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder=true)
//@Jacksonized
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonSerialize(using = SanchayUserDTOSerializer.class)
//@JsonDeserialize(using = SanchayUserDTODeserializer.class)
//public class SanchayUserDTO extends SanchayDTO implements Serializable {
public class SanchayUserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -1123357400993877492L;

    private Long id;

    private Long version;
    private String username;
//    private String name;

    @Email
    private String emailAddress;

    private String firstName;

    private String lastName;

    private String password;

    private boolean enabled;

    private boolean tokenExpired;

    private String currentRoleName;
    private String currentOrganisationName;
    private String currentLanguageName;
    private String currentAnnotationLevelName;

    private boolean dirty;

    private boolean toBeAdded;

    private boolean toBeDeleted;

    @Builder.Default
    private Map<String, SanchayRoleSlimDTO> roles = new LinkedHashMap<>();

    @Builder.Default
    private Map<String, SanchayResourceLanguageSlimDTO> languages = new LinkedHashMap<>();

    @Builder.Default
    private Map<String, SanchayOrganisationSlimDTO> organisations = new LinkedHashMap<>();

    @Builder.Default
    private Map<String, SanchayAnnotationLevelSlimDTO> annotationLevels = new LinkedHashMap<>();

    @Builder.Default
//    private Set<String> rolesAdded;
//    private Set<String> rolesAdded = new LinkedHashSet<>();
    private Map<String, SanchayRoleSlimDTO> rolesAdded = new LinkedHashMap<>();

    @Builder.Default
//    private Set<String> languagesAdded;
//    private Set<String> languagesAdded = new LinkedHashSet<>();
    private Map<String, SanchayResourceLanguageSlimDTO> languagesAdded = new LinkedHashMap<>();

    @Builder.Default
//    private Set<String> organisationsAdded;
//    private Set<String> organisationsAdded = new LinkedHashSet<>();
    private Map<String, SanchayOrganisationSlimDTO> organisationsAdded = new LinkedHashMap<>();

    @Builder.Default
//    private Set<String> annotationLevelsAdded;
//    private Set<String> annotationLevelsAdded = new LinkedHashSet<>();
    private Map<String, SanchayAnnotationLevelSlimDTO> annotationLevelsAdded = new LinkedHashMap<>();

    @Builder.Default
//    private Set<String> rolesDeleted;
//    private Set<String> rolesDeleted = new LinkedHashSet<>();
    private Map<String, SanchayRoleSlimDTO> rolesDeleted = new LinkedHashMap<>();

    @Builder.Default
//    private Set<String> languagesDeleted;
//    private Set<String> languagesDeleted = new LinkedHashSet<>();
    private Map<String, SanchayResourceLanguageSlimDTO> languagesDeleted = new LinkedHashMap<>();

    @Builder.Default
//    private Set<String> organisationsDeleted;
//    private Set<String> organisationsDeleted = new LinkedHashSet<>();
    private Map<String, SanchayOrganisationSlimDTO> organisationsDeleted = new LinkedHashMap<>();

    @Builder.Default
//    private Set<String> annotationLevelsDeleted;
//    private Set<String> annotationLevelsDeleted = new LinkedHashSet<>();
    private Map<String, SanchayAnnotationLevelSlimDTO> annotationLevelsDeleted = new LinkedHashMap<>();

    @JsonIgnore
    public SanchayRoleSlimDTO getCurrentRole()
    {
        return roles.get(currentRoleName);
    }

    @JsonIgnore
    public SanchayResourceLanguageSlimDTO getCurrentLanguage()
    {
        return languages.get(currentLanguageName);
    }

    @JsonIgnore
    public SanchayOrganisationSlimDTO getCurrentOrganisation()
    {
        return organisations.get(currentOrganisationName);
    }

    @JsonIgnore
    public SanchayAnnotationLevelSlimDTO getCurrentAnnotationLevel()
    {
        return annotationLevels.get(currentAnnotationLevelName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SanchayUserDTO)) {
            return false;
        }
        SanchayUserDTO that = (SanchayUserDTO) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(username, that.getUsername());
        return eb.isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(username);
        return hcb.toHashCode();
    }

//    @JsonIgnore
    public void addRole(SanchayRoleDTO role) {

        //avoid circular calls : assumes equals and hashcode implemented
        if (!roles.containsKey(role.getName())) {
            SanchayRoleSlimDTO roleSlimDTO = SanchayMapperUtils.getPlainModelMapperInstance().map(role, SanchayRoleSlimDTO.class);
            roles.put(role.getName(), roleSlimDTO);
            rolesAdded.put(role.getName(), roleSlimDTO);

            //add method to Product: set 'other side' of association:
            role.addUser(this);

            setDirty(true);
        }
    }

//    @JsonIgnore
    public void removeRole(SanchayRoleDTO role) {

        //avoid circular calls: assumes equals and hashcode implemented:
        if (roles.containsKey(role.getName())) {
            roles.remove(role.getName());
            SanchayRoleSlimDTO roleSlimDTO = SanchayMapperUtils.getPlainModelMapperInstance().map(role, SanchayRoleSlimDTO.class);
            rolesDeleted.put(role.getName(), roleSlimDTO);

            //add method to Product: set 'other side' of association:
            role.removeUser(this);

            setDirty(true);
        }
    }

//    @JsonIgnore
    public void addLanguage(SanchayResourceLanguageDTO language) {

        //avoid circular calls : assumes equals and hashcode implemented
        if (!languages.containsKey(language.getName())) {
            SanchayResourceLanguageSlimDTO languageSlimDTO = SanchayMapperUtils.getPlainModelMapperInstance().map(language, SanchayResourceLanguageSlimDTO.class);
            languages.put(language.getName(), languageSlimDTO);
            languagesAdded.put(language.getName(), languageSlimDTO);

            //add method to Product: set 'other side' of association:
            language.addUser(this);

            setDirty(true);
        }
    }

//    @JsonIgnore
    public void removeLanguage(SanchayResourceLanguageDTO language) {

        //avoid circular calls: assumes equals and hashcode implemented:
        if (languages.containsKey(language.getName())) {
            languages.remove(language.getName());
            SanchayResourceLanguageSlimDTO languageSlimDTO = SanchayMapperUtils.getPlainModelMapperInstance().map(language, SanchayResourceLanguageSlimDTO.class);
            languagesDeleted.put(language.getName(), languageSlimDTO);

            //add method to Product: set 'other side' of association:
            language.removeUser(this);

            setDirty(true);
        }
    }

//    @JsonIgnore
    public void addOrganisation(SanchayOrganisationDTO organisation) {

        //avoid circular calls : assumes equals and hashcode implemented
        if (!organisations.containsKey(organisation.getName())) {
            SanchayOrganisationSlimDTO organisationSlimDTO = SanchayMapperUtils.getPlainModelMapperInstance().map(organisation, SanchayOrganisationSlimDTO.class);
            organisations.put(organisation.getName(), organisationSlimDTO);
            organisationsAdded.put(organisation.getName(), organisationSlimDTO);

            //add method to Product: set 'other side' of association:
            organisation.addUser(this);

            setDirty(true);
        }
    }

//    @JsonIgnore
    public void removeOrganisation(SanchayOrganisationDTO organisation) {

        //avoid circular calls: assumes equals and hashcode implemented:
        if (organisations.containsKey(organisation.getName())) {
            organisations.remove(organisation.getName());
            SanchayOrganisationSlimDTO organisationSlimDTO = SanchayMapperUtils.getPlainModelMapperInstance().map(organisation, SanchayOrganisationSlimDTO.class);
            organisationsDeleted.put(organisation.getName(), organisationSlimDTO);

            //add method to Product: set 'other side' of association:
            organisation.removeUser(this);

            setDirty(true);
        }
    }

//    @JsonIgnore
    public void addAnnotationLevel(SanchayAnnotationLevelDTO level) {

        //avoid circular calls : assumes equals and hashcode implemented
        if (!annotationLevels.containsKey(level.getName())) {
            SanchayAnnotationLevelSlimDTO levelSlimDTO = SanchayMapperUtils.getPlainModelMapperInstance().map(level, SanchayAnnotationLevelSlimDTO.class);
            annotationLevels.put(level.getName(), levelSlimDTO);
            annotationLevelsAdded.put(level.getName(), levelSlimDTO);

            //add method to Product: set 'other side' of association:
            level.addUser(this);

            setDirty(true);
        }
    }

//    @JsonIgnore
    public void removeAnnotationLevel(SanchayAnnotationLevelDTO level) {

        //avoid circular calls: assumes equals and hashcode implemented:
        if (annotationLevels.containsKey(level.getName())) {
            annotationLevels.remove(level.getName());
            SanchayAnnotationLevelSlimDTO levelSlimDTO = SanchayMapperUtils.getPlainModelMapperInstance().map(level, SanchayAnnotationLevelSlimDTO.class);
            annotationLevelsDeleted.put(level.getName(), levelSlimDTO);

            //add method to Product: set 'other side' of association:
            level.removeUser(this);

            setDirty(true);
        }
    }
}
