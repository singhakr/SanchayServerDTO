/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.co.sanchay.server.dao.auth.model.domain;

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
import in.co.sanchay.common.dto.json.SanchayResourceLanguageDTODeserializer;
import in.co.sanchay.common.dto.json.SanchayResourceLanguageDTOSerializer;

/**
 *
 * @author User
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"users"})
@JsonSerialize(using = SanchayResourceLanguageDTOSerializer.class)
@JsonDeserialize(using = SanchayResourceLanguageDTODeserializer.class)
public class SanchayResourceLanguage implements Serializable{

    @Serial
    private static final long serialVersionUID = -1845815420487833962L;

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
    @ManyToMany(mappedBy = "languages"
//            cascade = {
//                    CascadeType.PERSIST
////                    CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH
//            }
    )
//    @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
    @JsonIgnoreProperties("languages")
    @MapKey(name = "username")
//    @JsonBackReference
    private Map<String, SanchayUser> users = new LinkedHashMap<>();

//    @PreRemove
//    private void removeLanguageFromUsers() {
//        users.entrySet().forEach(
//                (entry) -> entry.getValue().removeLanguage(this)
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
        if (!(obj instanceof SanchayResourceLanguage)) {
            return false;
        }
        SanchayResourceLanguage that = (SanchayResourceLanguage) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(name, that.name);
        return eb.isEquals();
    }

    public void addUser(SanchayUser user) {

        //avoid circular calls : assumes equals and hashcode implemented
        if (!users.containsKey(user.getUsername())) {
            users.put(user.getUsername(), user);

            //add method to Product : sets 'other side' of association
            user.addLanguage(this);
        }
    }

    public void removeUser(SanchayUser user) {

        //avoid circular calls: assumes equals and hashcode implemented:
        if (users.containsKey(user.getUsername())) {
            users.remove(user.getUsername());

            //add method to Product: set 'other side' of association:
            user.removeLanguage(this);
        }
    }
}
