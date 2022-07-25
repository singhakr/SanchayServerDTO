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
import lombok.extern.slf4j.Slf4j;
import sanchay.server.dao.auth.model.domain.SanchayOrganisation;

/**
 *
 * @author User
 */
@Slf4j
public class SanchayOrganisationDTOSerializer extends StdSerializer<SanchayOrganisation> {

    public SanchayOrganisationDTOSerializer() {
        this(null);
    }

    public SanchayOrganisationDTOSerializer(Class<SanchayOrganisation> t) {
        super(t);
    }

    @Override
    public void serialize(SanchayOrganisation value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        
        gen.writeStartObject();

        gen.writeNumberField("id", value.getId());
        gen.writeNumberField("version", value.getVersion());
        gen.writeStringField("name", value.getName());
        gen.writeStringField("longName", value.getLongName());

        gen.writeArrayFieldStart("users");
        List<String> list = value.getUsers().entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
        gen.writeArray((String []) list.toArray(new String[0]), 0, list.toArray(new String[0]).length);
        gen.writeEndArray();

        gen.writeEndObject();
        log.info(gen.toString());
    }
    
}
