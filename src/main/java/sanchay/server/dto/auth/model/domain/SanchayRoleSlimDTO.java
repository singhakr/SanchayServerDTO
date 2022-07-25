/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanchay.server.dto.auth.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import sanchay.common.dto.json.SanchayRoleDTODeserializer;
import sanchay.common.dto.json.SanchayRoleDTOSerializer;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder=true)
//@Jacksonized
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonSerialize(using = SanchayRoleDTOSerializer.class)
//@JsonDeserialize(using = SanchayRoleDTODeserializer.class)
//public class SanchayRoleSlimDTO extends SanchaySlimDTO implements Serializable {
public class SanchayRoleSlimDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 5597544257725192555L;

    private Long id;

    private Long version;
    private String name;

    private boolean toBeAdded;

    private boolean toBeDeleted;

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
        if (!(obj instanceof SanchayRoleSlimDTO)) {
            return false;
        }
        SanchayRoleSlimDTO that = (SanchayRoleSlimDTO) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(name, that.name);
        return eb.isEquals();
    }
}
