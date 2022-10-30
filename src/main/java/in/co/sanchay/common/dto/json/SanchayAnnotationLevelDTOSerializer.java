/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.co.sanchay.common.dto.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import in.co.sanchay.server.dao.auth.model.domain.SanchayAnnotationLevel;

/**
 *
 * @author User
 */
public class SanchayAnnotationLevelDTOSerializer extends StdSerializer<SanchayAnnotationLevel> {

    public SanchayAnnotationLevelDTOSerializer() {
        this(null);
    }

    public SanchayAnnotationLevelDTOSerializer(Class<SanchayAnnotationLevel> t) {
        super(t);
    }

    @Override
    public void serialize(SanchayAnnotationLevel value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        
        gen.writeStartObject();

        gen.writeNumberField("id", value.getId());
        gen.writeNumberField("version", value.getVersion());
        gen.writeStringField("name", value.getName());

        gen.writeArrayFieldStart("users");
        List<String> list = value.getUsers().entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
        gen.writeArray((String []) list.toArray(new String[0]), 0, list.toArray(new String[0]).length);
        gen.writeEndArray();

        gen.writeEndObject();        
    }
    
}
