/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanchay.server.dao.auth.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import sanchay.common.dto.json.SanchayRoleDTODeserializer;
import sanchay.common.dto.json.SanchayRoleDTOSerializer;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"users"})
@JsonSerialize(using = SanchayRoleDTOSerializer.class)
@JsonDeserialize(using = SanchayRoleDTODeserializer.class)
public class SanchayRole implements Serializable {

    @Serial
    private static final long serialVersionUID = -3233183850870655094L;

    public static final String ROOT = "Root";
    public static final String MANAGER = "Manager";
    public static final String VALIDATOR = "Validator";
    public static final String ANNOTATOR = "Annotator";
    public static final String VIEWER = "Viewer";

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    @Column(nullable = false)
    private Long version;
    @Column(unique = true, updatable = false, nullable = false)
    private String name;

    //    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles", cascade = {
    @ManyToMany(mappedBy = "roles"
//            cascade = {
//            CascadeType.PERSIST
////                    CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH
//        }
    )
//    @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
    @JsonIgnoreProperties("roles")
    @MapKey(name = "username")
//    @JsonBackReference
    private Map<String, SanchayUser> users = new LinkedHashMap<>();


    //    @ManyToMany(//fetch = FetchType.EAGER,
////    @ManyToMany(cascade = {
////    cascade = {
//////        CascadeType.PERSIST, 
////        CascadeType.ALL
////    }
//    )
//    @JoinTable(
//            name = "roles_privileges",
//            joinColumns = @JoinColumn(
//                    name = "role_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "privilege_id", referencedColumnName = "id"))
//    @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
//    private Collection<SanchayPrivilege> privileges = new HashSet<>();

//    @PreRemove
//    private void removeRoleFromUsers() {
//        users.entrySet().forEach(
//                (entry) -> entry.getValue().removeRole(this)
//        );
//    }

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
        if (!(obj instanceof SanchayRole)) {
            return false;
        }
        SanchayRole that = (SanchayRole) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(name, that.name);
        return eb.isEquals();
    }

//    public void addPrivilege(SanchayPrivilege privilege) {
//
//        //assumes equals and hashcode implemented: avoid circular calls
//        if (!privileges.contains(privilege)) {
//            privileges.add(privilege);
//
//            //add method to Product : sets 'other side' of association
//            privilege.addRole(this);
//        }
//    }
//
//    public void removePrivilege(SanchayPrivilege privilege) {
//
//        //assumes equals and hashcode implemented: avoid circular calls
//        if (privileges.contains(privilege)) {
//            privileges.remove(privilege);
//
//            //add method to Product : sets 'other side' of association
//            privilege.removeRole(this);
//        }
//    }

    public void addUser(SanchayUser user) {

        //avoid circular calls : assumes equals and hashcode implemented
        if (!users.containsKey(user.getUsername())) {
            users.put(user.getUsername(), user);

            //add method to Product : sets 'other side' of association
            user.addRole(this);
        }
    }

    public void removeUser(SanchayUser user) {

        //avoid circular calls: assumes equals and hashcode implemented: 
        if (users.containsKey(user.getUsername())) {
            users.remove(user.getUsername());

            //add method to Product: set 'other side' of association: 
            user.removeRole(this);
        }
    }
}
