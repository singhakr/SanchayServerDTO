/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.co.sanchay.common.dto.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import in.co.sanchay.server.dao.auth.model.domain.SanchayOrganisation;
import in.co.sanchay.server.dao.auth.model.domain.SanchayUser;

/**
 *
 * @author User
 */
public class SanchayOrganisationDTODeserializer extends StdDeserializer<SanchayOrganisation> {

    public SanchayOrganisationDTODeserializer() {
        this(null);
    }

    public SanchayOrganisationDTODeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public SanchayOrganisation deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {

        JsonNode node = p.getCodec().readTree(p);

        Long id = Long.parseLong(node.get("id").asText());
        Long version = Long.parseLong(node.get("version").asText());
        String name = node.get("name").asText();
        String longName = node.get("longName").asText();

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

        SanchayOrganisation sanchayOrganisation = new SanchayOrganisation();

        sanchayOrganisation.setId(id);
        sanchayOrganisation.setVersion(version);
        sanchayOrganisation.setName(name);
        sanchayOrganisation.setLongName(longName);

        sanchayOrganisation.setUsers(userMap);

        return sanchayOrganisation;
    }
    
}
