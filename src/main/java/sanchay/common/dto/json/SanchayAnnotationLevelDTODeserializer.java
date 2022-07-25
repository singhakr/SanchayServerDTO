/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanchay.common.dto.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import sanchay.server.dao.auth.model.domain.SanchayAnnotationLevel;
import sanchay.server.dao.auth.model.domain.SanchayUser;

/**
 *
 * @author User
 */
public class SanchayAnnotationLevelDTODeserializer extends StdDeserializer<SanchayAnnotationLevel> {

    public SanchayAnnotationLevelDTODeserializer() {
        this(null);
    }

    public SanchayAnnotationLevelDTODeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public SanchayAnnotationLevel deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {

        JsonNode node = p.getCodec().readTree(p);

        Long id = Long.parseLong(node.get("id").asText());
        Long version = Long.parseLong(node.get("version").asText());
        String name = node.get("name").asText();

        Map<String, SanchayUser> userMap = new LinkedHashMap<>();
        List<String> users = node.findValuesAsText("users");

        users.forEach(
                username ->
                {
                    SanchayUser user = new SanchayUser();
                    user.setUsername(username);

                    userMap.put(username, user);
                }
        );

        SanchayAnnotationLevel annotationLevel = new SanchayAnnotationLevel();

        annotationLevel.setId(id);
        annotationLevel.setVersion(version);
        annotationLevel.setName(name);

        annotationLevel.setUsers(userMap);

        return annotationLevel;
    }
    
}
