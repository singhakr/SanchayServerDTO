/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanchay.common.dto.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.node.BooleanNode;
import sanchay.server.dao.auth.model.domain.*;

/**
 *
 * @author User
 */
public class SanchayUserDTODeserializer extends StdDeserializer<SanchayUser> {

    public SanchayUserDTODeserializer() {
        this(null);
    }

    public SanchayUserDTODeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public SanchayUser deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {

        JsonNode node = p.getCodec().readTree(p);

        Long id = Long.parseLong(node.get("id").asText());
        Long version = Long.parseLong(node.get("version").asText());
        String username = node.get("username").asText();
        String emailAddress = node.get("emailAddress").asText();
        String firstName = node.get("firstName").asText();
        String lastName = node.get("lastName").asText();
        String password = node.get("password").asText();
        boolean enabled = (Boolean) ((BooleanNode) node.get("enabled")).booleanValue();
        boolean tokenExpired = (Boolean) ((BooleanNode) node.get("tokenExpired")).booleanValue();

        String currentRoleName = node.get("currentRoleName").asText();
        String currentOrganisationName = node.get("currentOrganisationName").asText();
        String currentLanguageName = node.get("currentLanguageName").asText();
        String currentAnnotationLevelName = node.get("currentAnnotationLevelName").asText();

        Map<String, SanchayRole> roleMap = new LinkedHashMap<>();
        List<String> roles = node.findValuesAsText("roles");

        roles.forEach(
                roleName ->
                {
                    SanchayRole role = new SanchayRole();
                    role.setName(roleName);

                    roleMap.put(roleName, role);
                }
        );

        Map<String, SanchayResourceLanguage> languageMap = new LinkedHashMap<>();
        List<String> languages = node.findValuesAsText("languages");

        roles.forEach(
                languageName ->
                {
                    SanchayResourceLanguage language = new SanchayResourceLanguage();
                    language.setName(languageName);

                    languageMap.put(languageName, language);
                }
        );

        Map<String, SanchayOrganisation> organisationMap = new LinkedHashMap<>();
        List<String> organisations = node.findValuesAsText("organisations");

        roles.forEach(
                organisationName ->
                {
                    SanchayOrganisation organisation = new SanchayOrganisation();
                    organisation.setName(organisationName);

                    organisationMap.put(organisationName, organisation);
                }
        );

        Map<String, SanchayAnnotationLevel> annotationLevelMap = new LinkedHashMap<>();
        List<String> annotationLevels = node.findValuesAsText("annotationLevels");

        roles.forEach(
                annotationLevelName ->
                {
                    SanchayAnnotationLevel annotationLevel = new SanchayAnnotationLevel();
                    annotationLevel.setName(annotationLevelName);

                    annotationLevelMap.put(annotationLevelName, annotationLevel);
                }
        );

        SanchayUser user = new SanchayUser();

        user.setId(id);
        user.setVersion(version);
        user.setUsername(username);
        user.setEmailAddress(emailAddress);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setEnabled(enabled);
        user.setTokenExpired(tokenExpired);
        user.setCurrentRoleName(currentRoleName);
        user.setCurrentOrganisationName(currentOrganisationName);
        user.setCurrentLanguageName(currentLanguageName);
        user.setCurrentAnnotationLevelName(currentAnnotationLevelName);

        user.setRoles(roleMap);
        user.setLanguages(languageMap);
        user.setOrganisations(organisationMap);
        user.setAnnotationLevels(annotationLevelMap);

        return user;
    }
    
}
