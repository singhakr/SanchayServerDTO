/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanchay.server.dao.auth.model.domain;

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
import sanchay.common.dto.json.SanchayOrganisationDTODeserializer;
import sanchay.common.dto.json.SanchayOrganisationDTOSerializer;

/**
 *
 * @author User
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"users"})
@JsonSerialize(using = SanchayOrganisationDTOSerializer.class)
@JsonDeserialize(using = SanchayOrganisationDTODeserializer.class)
public class SanchayOrganisation implements Serializable {

    @Serial
    private static final long serialVersionUID = 5665911962164883278L;

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(nullable = false)
    private Long version;

    @Column(unique = true, updatable = false, nullable = false)
    private String name;

    @Column(unique = true, updatable = false, nullable = false)
    private String longName;

//    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "languages", cascade = {
    @ManyToMany(mappedBy = "organisations"
//            , cascade = {
//        CascadeType.PERSIST, 
//        CascadeType.MERGE
//    }
    )
//    @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
    @JsonIgnoreProperties("organisations")
    @MapKey(name = "username")
//    @JsonBackReference
    private Map<String, SanchayUser> users = new LinkedHashMap<>();

    @PreRemove
    private void removeOrganisationFromUsers() {
        users.entrySet().forEach(
                (entry) -> entry.getValue().removeOrganisation(this)
        );
    }

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
        if (!(obj instanceof SanchayOrganisation)) {
            return false;
        }
        SanchayOrganisation that = (SanchayOrganisation) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(name, that.name);
        return eb.isEquals();
    }

    public void addUser(SanchayUser user) {

        //avoid circular calls : assumes equals and hashcode implemented
        if (!users.containsKey(user.getUsername())) {
            users.put(user.getUsername(), user);

            //add method to Product : sets 'other side' of association
            user.addOrganisation(this);
        }
    }

    public void removeUser(SanchayUser user) {

        //avoid circular calls: assumes equals and hashcode implemented:
        if (users.containsKey(user.getUsername())) {
            users.remove(user.getUsername());

            //add method to Product: set 'other side' of association:
            user.removeOrganisation(this);
        }
    }
}
