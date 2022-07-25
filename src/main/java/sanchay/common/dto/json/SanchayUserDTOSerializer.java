/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanchay.common.dto.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import sanchay.server.dao.auth.model.domain.SanchayUser;

/**
 *
 * @author User
 */
public class SanchayUserDTOSerializer extends StdSerializer<SanchayUser> {

    public SanchayUserDTOSerializer() {
        this(null);
    }

    public SanchayUserDTOSerializer(Class<SanchayUser> t) {
        super(t);
    }

    @Override
    public void serialize(SanchayUser value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        
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
    }
    
}
