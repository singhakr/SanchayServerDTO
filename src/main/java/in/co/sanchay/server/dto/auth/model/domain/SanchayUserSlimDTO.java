/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.co.sanchay.server.dto.auth.model.domain;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.Email;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder=true)
//@Jacksonized
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonSerialize(using = SanchayUserDTOSerializer.class)
//@JsonDeserialize(using = SanchayUserDTODeserializer.class)
//public class SanchayUserSlimDTO extends SanchaySlimDTO implements Serializable {
public class SanchayUserSlimDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6278303207513495348L;

    private Long id;

    private Long version;

    private String username;
//    private String name;

    @Email
    private String emailAddress;

    private String firstName;

    private String lastName;

    private String password;

    private boolean enabled;

    private boolean tokenExpired;

    private boolean toBeAdded;

    private boolean toBeDeleted;

    private String currentRoleName;
    private String currentOrganisationName;
    private String currentLanguageName;
    private String currentAnnotationLevelName;

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(username);
        return hcb.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SanchayUserSlimDTO)) {
            return false;
        }
        SanchayUserSlimDTO that = (SanchayUserSlimDTO) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(username, that.username);
        return eb.isEquals();
    }
}
