/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanchay.server.dto.auth.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import sanchay.common.dto.json.SanchayResourceLanguageDTODeserializer;
import sanchay.common.dto.json.SanchayResourceLanguageDTOSerializer;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

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
//@JsonSerialize(using = SanchayResourceLanguageDTOSerializer.class)
//@JsonDeserialize(using = SanchayResourceLanguageDTODeserializer.class)
//public class SanchayResourceLanguageSlimDTO extends SanchaySlimDTO implements Serializable{
public class SanchayResourceLanguageSlimDTO implements Serializable{

    @Serial
    private static final long serialVersionUID = -4437133834386336477L;

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
        if (!(obj instanceof SanchayResourceLanguageSlimDTO)) {
            return false;
        }
        SanchayResourceLanguageSlimDTO that = (SanchayResourceLanguageSlimDTO) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(name, that.name);
        return eb.isEquals();
    }
}
