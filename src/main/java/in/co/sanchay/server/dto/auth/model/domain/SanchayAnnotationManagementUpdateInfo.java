/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.co.sanchay.server.dto.auth.model.domain;

import lombok.*;
import in.co.sanchay.server.dto.auth.model.domain.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author User
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder=true)
//@Jacksonized
//@JsonIgnoreProperties(ignoreUnknown = true)
public class SanchayAnnotationManagementUpdateInfo {

    @Builder.Default
    private Map<String, SanchayUserDTO> allUsers = new LinkedHashMap<>();
    @Builder.Default
    private Map<String, SanchayRoleDTO> allRoles = new LinkedHashMap<>();
    @Builder.Default
    private Map<String, SanchayOrganisationDTO> allOrganisations = new LinkedHashMap<>();
    @Builder.Default
    private Map<String, SanchayResourceLanguageDTO> allLanguages = new LinkedHashMap<>();
    @Builder.Default
    private Map<String, SanchayAnnotationLevelDTO> allLevels = new LinkedHashMap<>();

    @Builder.Default
    private Map<String, SanchayUserSlimDTO> allSlimUsers = new LinkedHashMap<>();
    @Builder.Default
    private Map<String, SanchayRoleSlimDTO> allSlimRoles = new LinkedHashMap<>();
    @Builder.Default
    private Map<String, SanchayOrganisationSlimDTO> allSlimOrganisations = new LinkedHashMap<>();
    @Builder.Default
    private Map<String, SanchayResourceLanguageSlimDTO> allSlimLanguages = new LinkedHashMap<>();
    @Builder.Default
    private Map<String, SanchayAnnotationLevelSlimDTO> allSlimLevels = new LinkedHashMap<>();
//
//    private SanchayUserDTO selectedUser;
//    private SanchayRoleDTO selectedURole;
//    private SanchayOrganisationDTO selectedOrganisation;
//    private SanchayResourceLanguageDTO selectedLanguage;
//    private SanchayAnnotationLevelDTO selectedLevel;
//
//    private SanchayUserDTO currentlySelectedRoleUser;
//    private SanchayUserDTO currentlySelectedOrgUser;
//    private SanchayUserDTO currentlySelectedLangUser;
//    private SanchayUserDTO currentlySelectedLevelUser;
//
//    private SanchayRoleDTO currentAssignedUserRole;
//    private SanchayOrganisationDTO currentAssignedUserOrganisation;
//    private SanchayResourceLanguageDTO currentAssignedUserLanguage;
//    private SanchayAnnotationLevelDTO currentAssignedUserLevel;

//    private Map<String, Map<String, SanchayRoleDTO>> assignedUserRoles = new LinkedHashMap<>();
//    private Map<String, Map<String, SanchayOrganisationDTO>> assignedUserOrganisations = new LinkedHashMap<>();
//    private Map<String, Map<String, SanchayResourceLanguageDTO>> assignedUserLanguages = new LinkedHashMap<>();
//    private Map<String, Map<String, SanchayAnnotationLevelDTO>> assignedUserLevels = new LinkedHashMap<>();
}
