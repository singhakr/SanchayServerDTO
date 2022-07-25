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
import sanchay.server.dao.auth.model.domain.SanchayRole;
import sanchay.server.dao.auth.model.domain.SanchayUser;

/**
 *
 * @author User
 */
public class SanchayRoleDTODeserializer extends StdDeserializer<SanchayRole> {

    public SanchayRoleDTODeserializer() {
        this(null);
    }

    public SanchayRoleDTODeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public SanchayRole deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {

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

        SanchayRole role = new SanchayRole();

        role.setId(id);
        role.setVersion(version);
        role.setName(name);

        role.setUsers(userMap);

        return role;
    }
    
}
