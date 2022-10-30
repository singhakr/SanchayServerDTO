package in.co.sanchay.server.dto.auth.model.domain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import in.co.sanchay.server.mapper.SanchayMapperUtils;

import java.io.Serial;
import java.io.Serializable;
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
//    private Set<String> usersAdded;
//    private Set<String> usersAdded = new LinkedHashSet<>();
    private Map<String, SanchayUserSlimDTO> usersAdded = new LinkedHashMap<>();

    @Builder.Default
//    private Set<String> usersDeleted;
//    private Set<String> usersDeleted = new LinkedHashSet<>();
    private Map<String, SanchayUserSlimDTO> usersDeleted = new LinkedHashMap<>();

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
            SanchayUserSlimDTO userSlimDTO = SanchayMapperUtils.getPlainModelMapperInstance().map(user, SanchayUserSlimDTO.class);
            users.put(user.getUsername(), userSlimDTO);
            usersAdded.put(user.getUsername(), userSlimDTO);

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
            SanchayUserSlimDTO userSlimDTO = SanchayMapperUtils.getPlainModelMapperInstance().map(user, SanchayUserSlimDTO.class);
            usersDeleted.put(user.getUsername(), userSlimDTO);

            //add method to Product: set 'other side' of association:
            user.removeAnnotationLevel(this);

            setDirty(true);
        }
    }
}
