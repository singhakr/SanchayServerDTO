package in.co.sanchay.server.dao.auth.model.domain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import in.co.sanchay.common.dto.json.SanchayAnnotationLevelDTODeserializer;
import in.co.sanchay.common.dto.json.SanchayAnnotationLevelDTOSerializer;

/**
 *
 * @author User
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"users"})
@JsonSerialize(using = SanchayAnnotationLevelDTOSerializer.class)
@JsonDeserialize(using = SanchayAnnotationLevelDTODeserializer.class)
public class SanchayAnnotationLevel implements Serializable {

    @Serial
    private static final long serialVersionUID = -2043970912363412762L;

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    @Column(nullable = false)
    private Long version;
    @Column(unique = true, updatable = false, nullable = false)
    private String name;

//    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "languages", cascade = {
    @ManyToMany(mappedBy = "annotationLevels"
//            cascade = {
//                    CascadeType.PERSIST
////                    CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH
//            }
    )
//    @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
    @JsonIgnoreProperties("annotationLevels")
    @MapKey(name = "username")
//    @JsonBackReference
    private Map<String, SanchayUser> users = new LinkedHashMap<>();

//    @PreRemove
//    private void removeAnnotationLevelFromUsers() {
//        users.entrySet().forEach(
//                (entry) -> entry.getValue().removeAnnotationLevel(this)
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
        if (!(obj instanceof SanchayAnnotationLevel)) {
            return false;
        }
        SanchayAnnotationLevel that = (SanchayAnnotationLevel) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(name, that.name);
        return eb.isEquals();
    }

    public void addUser(SanchayUser user) {

        //avoid circular calls : assumes equals and hashcode implemented
        if (!users.containsKey(user.getUsername())) {
            users.put(user.getUsername(), user);

            //add method to Product : sets 'other side' of association
            user.addAnnotationLevel(this);
        }
    }

    public void removeUser(SanchayUser user) {

        //avoid circular calls: assumes equals and hashcode implemented:
        if (users.containsKey(user.getUsername())) {
            users.remove(user.getUsername());

            //add method to Product: set 'other side' of association:
            user.removeAnnotationLevel(this);
        }
    }
}
