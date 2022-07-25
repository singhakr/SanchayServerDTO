package sanchay.server.dto.auth.model.domain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import sanchay.common.dto.json.SanchayAnnotationLevelDTODeserializer;
import sanchay.common.dto.json.SanchayAnnotationLevelDTOSerializer;
import sanchay.common.dto.json.SanchayResourceLanguageDTODeserializer;
import sanchay.common.dto.json.SanchayResourceLanguageDTOSerializer;
import sanchay.server.mapper.SanchayMapperUtils;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

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
//@JsonSerialize(using = SanchayAnnotationLevelDTOSerializer.class)
//@JsonDeserialize(using = SanchayAnnotationLevelDTODeserializer.class)
//public class SanchayAnnotationLevelDTO extends SanchayDTO implements Serializable {
public class SanchayAnnotationLevelDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6392416043991268290L;

    private Long id;

    private Long version;

    private String name;

    private boolean dirty;

    private boolean toBeAdded;

    private boolean toBeDeleted;

    @Builder.Default
    private Set<String> usersAdded = new LinkedHashSet<>();

    @Builder.Default
    private Set<String> usersDeleted = new LinkedHashSet<>();

    @Builder.Default
    private Map<String, SanchayUserSlimDTO> users = new LinkedHashMap<>();

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(name);
        return hcb.toHashCode();
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SanchayAnnotationLevelDTO)) {
            return false;
        }
        SanchayAnnotationLevelDTO that = (SanchayAnnotationLevelDTO) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(name, that.name);
        return eb.isEquals();
    }

//    @JsonIgnore
    public void addUser(SanchayUserDTO user) {

        //avoid circular calls : assumes equals and hashcode implemented
        if (!users.containsKey(user.getUsername())) {
            users.put(user.getUsername(), SanchayMapperUtils.getPlainModelMapperInstance().map(user, SanchayUserSlimDTO.class));
            usersAdded.add(user.getUsername());

            //add method to Product : sets 'other side' of association
            user.addAnnotationLevel(this);

            setDirty(true);
        }
    }

//    @JsonIgnore
    public void removeUser(SanchayUserDTO user) {

        //avoid circular calls: assumes equals and hashcode implemented:
        if (users.containsKey(user.getUsername())) {
            users.remove(user.getUsername());
            usersDeleted.add(user.getUsername());

            //add method to Product: set 'other side' of association:
            user.removeAnnotationLevel(this);

            setDirty(true);
        }
    }
}