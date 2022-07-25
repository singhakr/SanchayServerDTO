/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanchay.server.dto.tmp;

import java.io.Serial;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author User
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SanchayPrivilege {

    @Serial
    private static final long serialVersionUID = 589657876383479883L;

    public static final String EVERYTHING = "EVERYTHING";
    public static final String MANAGEMENT = "MANAGEMENT";
    public static final String VALIDATION = "VALIDATION";
    public static final String ANNOTATION = "ANNOTATION";
    public static final String READING = "READING";

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    @Column(nullable = false)
    private Long version;

    @Column(unique = true, updatable = false, nullable = false)
    private String name;

/** Using composite key instead
//    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "privileges", cascade = {
    @ManyToMany(mappedBy = "privileges"
//            , cascade = {
//        CascadeType.PERSIST,
//        CascadeType.MERGE
//    }
    )
//    @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
    private Collection<SanchayRole> roles = new HashSet<>();
*/

    @OneToMany(mappedBy = "privilege")
    Set<SanchayRolePrivilege> rolePrivileges = new HashSet<>();

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
        if (!(obj instanceof SanchayPrivilege)) {
            return false;
        }
        SanchayPrivilege that = (SanchayPrivilege) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(name, that.name);
        return eb.isEquals();
    }

//    public void addRole(SanchayRole role) {
//
//        //avoid circular calls : assumes equals and hashcode implemented
//        if (!roles.contains(role)) {
//            roles.add(role);
//
//            //add method to Product : sets 'other side' of association
//            role.addPrivilege(this);
//        }
//    }
//
//    public void removeRole(SanchayRole role) {
//
//        //avoid circular calls: assumes equals and hashcode implemented:
//        if (roles.contains(role)) {
//            roles.remove(role);
//
//            //add method to Product: set 'other side' of association:
//            role.removePrivilege(this);
//        }
//    }
}
