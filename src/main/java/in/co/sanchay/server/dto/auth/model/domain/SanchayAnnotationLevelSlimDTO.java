package in.co.sanchay.server.dto.auth.model.domain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serial;
import java.io.Serializable;

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
//public class SanchayAnnotationLevelSlimDTO extends SanchaySlimDTO implements Serializable {
public class SanchayAnnotationLevelSlimDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7660295115449214587L;

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
        if (!(obj instanceof SanchayAnnotationLevelSlimDTO)) {
            return false;
        }
        SanchayAnnotationLevelSlimDTO that = (SanchayAnnotationLevelSlimDTO) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(name, that.name);
        return eb.isEquals();
    }
}
