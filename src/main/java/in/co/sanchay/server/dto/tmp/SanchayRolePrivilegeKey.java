/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.co.sanchay.server.dto.tmp;

import java.io.Serial;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author User
 */
@Embeddable
public class SanchayRolePrivilegeKey implements Serializable {

    @Serial
    private static final long serialVersionUID = -6786352374956993679L;

    @Column(name = "user_id")
    Long userId;

    @Column(name = "privilege_id")
    Long privilegeId;

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(userId);
        hcb.append(privilegeId);
        return hcb.toHashCode();
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SanchayRolePrivilegeKey)) {
            return false;
        }
        SanchayRolePrivilegeKey that = (SanchayRolePrivilegeKey) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(userId, that.userId);
        eb.append(privilegeId, that.privilegeId);
        return eb.isEquals();
    }
}
