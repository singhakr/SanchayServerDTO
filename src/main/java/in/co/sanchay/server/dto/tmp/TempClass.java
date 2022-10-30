/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.co.sanchay.server.dto.tmp;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static javax.management.Query.value;

import in.co.sanchay.server.dao.auth.model.domain.SanchayAnnotationLevel;
import in.co.sanchay.server.dao.auth.model.domain.SanchayOrganisation;
import in.co.sanchay.server.dao.auth.model.domain.SanchayResourceLanguage;
import in.co.sanchay.server.dao.auth.model.domain.SanchayRole;
import in.co.sanchay.server.dao.auth.model.domain.SanchayUser;

/**
 *
 * @author User
 */
//@Slf4j
public class TempClass {
    
    public static void main(String[] args) throws IOException
    {
        JsonFactory factory = new JsonFactory();
        JsonGenerator gen = factory.createGenerator(System.out);
        
        SanchayUser value = new SanchayUser();
        value.setId(1L);
        value.setVersion(2L);
        value.setUsername("plato");
        value.setEmailAddress("a@b.c");
        value.setFirstName("Plato");
        value.setLastName("Greek");
        value.setPassword("1234");
        value.setEnabled(true);
        value.setTokenExpired(false);
        value.setCurrentRoleName(SanchayRole.ANNOTATOR);
        value.setCurrentOrganisationName("IIIT-H");
        value.setCurrentLanguageName("Hindi");
        value.setCurrentAnnotationLevelName("POS-Tagging");

        Map<String, SanchayRole> roleMap = new LinkedHashMap<>();
        SanchayRole role = new SanchayRole();
        role.setName(SanchayRole.ANNOTATOR);
        roleMap.put(SanchayRole.ANNOTATOR, role);

        Map<String, SanchayResourceLanguage> languageMap = new LinkedHashMap<>();
        SanchayResourceLanguage language = new SanchayResourceLanguage();
        role.setName("Hindi");
        languageMap.put("Hindi", language);

        Map<String, SanchayOrganisation> organisationMap = new LinkedHashMap<>();
        SanchayOrganisation organisation = new SanchayOrganisation();
        role.setName("IIIT-H");
        organisationMap.put("IIIT-H", organisation);

        Map<String, SanchayAnnotationLevel> annotationLevelMap = new LinkedHashMap<>();
        SanchayAnnotationLevel annotationLevel = new SanchayAnnotationLevel();
        role.setName("POS-Tagging");
        annotationLevelMap.put("POS-Tagging", annotationLevel);

        value.setRoles(roleMap);
        value.setLanguages(languageMap);
        value.setOrganisations(organisationMap);
        value.setAnnotationLevels(annotationLevelMap);

        gen.useDefaultPrettyPrinter();

        gen.writeStartObject();

        gen.writeNumberField("id", value.getId());
        gen.writeNumberField("version", value.getVersion());
        gen.writeStringField("username", value.getUsername());
        gen.writeStringField("emailAddress", value.getEmailAddress());
        gen.writeStringField("firstName", value.getFirstName());
        gen.writeStringField("lastName", value.getLastName());
        gen.writeStringField("password", value.getPassword());
        gen.writeBooleanField("enabled", value.isEnabled());
        gen.writeBooleanField("tokenExpired", value.isTokenExpired());
        gen.writeStringField("currentRoleName", value.getCurrentRoleName());
        gen.writeStringField("currentOrganisationName", value.getCurrentOrganisationName());
        gen.writeStringField("currentLanguageName", value.getCurrentLanguageName());
        gen.writeStringField("currentAnnotationLevelName", value.getCurrentAnnotationLevelName());
        
        gen.writeArrayFieldStart("roles");
        List<String> list = value.getRoles().entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());        
        gen.writeArray((String []) list.toArray(new String[0]), 0, list.toArray(new String[0]).length);
        gen.writeEndArray();
        
        gen.writeArrayFieldStart("organisations");
        list = value.getOrganisations().entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());        
        gen.writeArray((String []) list.toArray(new String[0]), 0, list.toArray(new String[0]).length);
        gen.writeEndArray();
        
        gen.writeArrayFieldStart("languages");
        list = value.getLanguages().entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());        
        gen.writeArray((String []) list.toArray(new String[0]), 0, list.toArray(new String[0]).length);
        gen.writeEndArray();
        
        gen.writeArrayFieldStart("annotationLevels");
        list = value.getAnnotationLevels().entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());        
        gen.writeArray((String []) list.toArray(new String[0]), 0, list.toArray(new String[0]).length);
        gen.writeEndArray();

        gen.writeEndObject();

        gen.close();

        System.out.println(gen.getCurrentValue());
//        log.info(gen.toString());
    }
    
}
