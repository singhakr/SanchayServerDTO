/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.co.sanchay.server.dao.auth.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.persistence.*;

import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"roles", "languages", "organisations", "annotationLevels"})
public class SanchayUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 5673594945402722082L;
    
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    @Column(nullable = false)
    private Long version;
    @Column(unique = true, updatable = false, nullable = false)
    private String username;
//    private String name;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String password;
    private boolean enabled;
    private boolean tokenExpired;
    
    private String currentRoleName;
    private String currentOrganisationName;
    private String currentLanguageName;
    private String currentAnnotationLevelName;

//    @ManyToMany(fetch = FetchType.EAGER,
    @ManyToMany(
//            cascade = {
//                    CascadeType.MERGE,
//                    CascadeType.PERSIST
//            }
    )
//    @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
//    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
//    @ElementCollection(targetClass=SanchayRole.class)
    @JsonIgnoreProperties("users")
    @MapKey(name = "name")
//    @JsonManagedReference
    private Map<String, SanchayRole> roles = new LinkedHashMap<>();

//    @OneToMany(mappedBy = "user")
//    Set<SanchayRolePrivilege> rolePrivileges = new HashSet<>();

//    @ManyToMany(fetch = FetchType.EAGER,
    @ManyToMany(
//            cascade = {
//                    CascadeType.MERGE,
//                    CascadeType.PERSIST
//            }
    )
//    @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
//    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "users_languages",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "language_id", referencedColumnName = "id"))
//    @ElementCollection(targetClass=SanchayResourceLanguage.class)
    @JsonIgnoreProperties("users")
    @MapKey(name = "name")
//    @JsonManagedReference
    private Map<String, SanchayResourceLanguage> languages = new LinkedHashMap<>();

//    @ManyToMany(fetch = FetchType.EAGER,
    @ManyToMany(
//            cascade = {
//                    CascadeType.MERGE,
//                    CascadeType.PERSIST
//            }
    )
//    @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
//    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "users_organisations",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "organisation_id", referencedColumnName = "id"))
//    @ElementCollection(targetClass=SanchayResourceLanguage.class)
    @JsonIgnoreProperties("users")
    @MapKey(name = "name")
//    @JsonManagedReference
    private Map<String, SanchayOrganisation> organisations = new LinkedHashMap<>();

    //    @ManyToMany(fetch = FetchType.EAGER,
    @ManyToMany(
//    cascade = {
//            CascadeType.PERSIST
////            CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH
//    }
    )
//    @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
//    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "users_annotation_levels",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "annotation_level_id", referencedColumnName = "id"))
//    @ElementCollection(targetClass=SanchayResourceLanguage.class)
    @JsonIgnoreProperties("users")
    @MapKey(name = "name")
//    @JsonManagedReference
    private Map<String, SanchayAnnotationLevel> annotationLevels = new LinkedHashMap<>();

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(username);
        return hcb.toHashCode();
    }

    @JsonIgnore
    public SanchayRole getCurrentRole()
    {
        return roles.get(currentRoleName);
    }

    @JsonIgnore
    public SanchayResourceLanguage getCurrentLanguage()
    {
        return languages.get(currentLanguageName);
    }

    @JsonIgnore
    public SanchayOrganisation getCurrentOrganisation()
    {
        return organisations.get(currentOrganisationName);
    }

    @JsonIgnore
    public SanchayAnnotationLevel getCurrentAnnotationLevel()
    {
        return annotationLevels.get(currentAnnotationLevelName);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SanchayUser)) {
            return false;
        }
        SanchayUser that = (SanchayUser) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(username, that.username);
        return eb.isEquals();
    }

    public void addRole(SanchayRole role) {

        //avoid circular calls : assumes equals and hashcode implemented
        if (!roles.containsKey(role.getName())) {
            roles.put(role.getName(), role);

            //add method to Product : sets 'other side' of association
            role.addUser(this);
        }
    }

    public void removeRole(SanchayRole role) {

        //avoid circular calls: assumes equals and hashcode implemented:
        if (roles.containsKey(role.getName())) {
            roles.remove(role.getName());

            //add method to Product: set 'other side' of association:
            role.removeUser(this);
        }
    }

    public void addLanguage(SanchayResourceLanguage language) {

        //avoid circular calls : assumes equals and hashcode implemented
        if (!languages.containsKey(language.getName())) {
            languages.put(language.getName(), language);

            //add method to Product : sets 'other side' of association
            language.addUser(this);
        }
    }

    public void removeLanguage(SanchayResourceLanguage language) {

        //avoid circular calls: assumes equals and hashcode implemented: 
        if (languages.containsKey(language.getName())) {
            languages.remove(language.getName());

            //add method to Product: set 'other side' of association: 
            language.removeUser(this);
        }
    }

    public void addOrganisation(SanchayOrganisation organisation) {

        //avoid circular calls : assumes equals and hashcode implemented
        if (!organisations.containsKey(organisation.getName())) {
            organisations.put(organisation.getName(), organisation);

            //add method to Product : sets 'other side' of association
            organisation.addUser(this);
        }
    }

    public void removeOrganisation(SanchayOrganisation organisation) {

        //avoid circular calls: assumes equals and hashcode implemented: 
        if (organisations.containsKey(organisation.getName())) {
            organisations.remove(organisation.getName());

            //add method to Product: set 'other side' of association: 
            organisation.removeUser(this);
        }
    }

    public void addAnnotationLevel(SanchayAnnotationLevel level) {

        //avoid circular calls : assumes equals and hashcode implemented
        if (!annotationLevels.containsKey(level.getName())) {
            annotationLevels.put(level.getName(), level);

            //add method to Product : sets 'other side' of association
            level.addUser(this);
        }
    }

    public void removeAnnotationLevel(SanchayAnnotationLevel level) {

        //avoid circular calls: assumes equals and hashcode implemented:
        if (annotationLevels.containsKey(level.getName())) {
            annotationLevels.remove(level.getName());

            //add method to Product: set 'other side' of association:
            level.removeUser(this);
        }
    }
    
    public boolean hasRole(String roleName)
    {
        return roles.keySet().contains(roleName);
    }
}
