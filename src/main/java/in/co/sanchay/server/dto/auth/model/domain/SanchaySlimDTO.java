package in.co.sanchay.server.dto.auth.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = SanchayUserSlimDTO.class, name = "SanchayUserSlimDTO"),
//        @JsonSubTypes.Type(value = SanchayRoleSlimDTO.class, name = "SanchayRoleSlimDTO"),
//        @JsonSubTypes.Type(value = SanchayOrganisationSlimDTO.class, name = "SanchayOrganisationSlimDTO"),
//        @JsonSubTypes.Type(value = SanchayResourceLanguageSlimDTO.class, name = "SanchayResourceLanguageSlimDTO"),
//        @JsonSubTypes.Type(value = SanchayAnnotationLevelSlimDTO.class, name = "SanchayAnnotationLevelSlimDTO"),
//})
public class SanchaySlimDTO {
}
