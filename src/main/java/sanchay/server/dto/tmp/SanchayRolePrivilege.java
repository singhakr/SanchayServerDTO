package sanchay.server.dto.tmp;

import javax.persistence.*;
import java.io.Serial;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import sanchay.server.dao.auth.model.domain.SanchayUser;

@Entity
public class SanchayRolePrivilege {

    @Serial
    private static final long serialVersionUID = -6323832485073294147L;

    @EmbeddedId
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    SanchayRolePrivilegeKey id;

    String rolename;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    SanchayUser user;

    @ManyToOne
    @MapsId("privilegeId")
    @JoinColumn(name = "privilege_id")
    SanchayPrivilege privilege;

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(id);
        hcb.append(rolename);
        return hcb.toHashCode();
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SanchayRolePrivilege)) {
            return false;
        }
        SanchayRolePrivilege that = (SanchayRolePrivilege) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(id, that.id);
        eb.append(rolename, that.rolename);
        return eb.isEquals();
    }
}
