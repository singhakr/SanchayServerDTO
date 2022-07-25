package sanchay.server.dto.auth.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = SanchayUserDTO.class, name = "SanchayUserDTO"),
//        @JsonSubTypes.Type(value = SanchayRoleDTO.class, name = "SanchayRoleDTO"),
//        @JsonSubTypes.Type(value = SanchayOrganisationDTO.class, name = "SanchayOrganisationDTO"),
//        @JsonSubTypes.Type(value = SanchayResourceLanguageDTO.class, name = "SanchayResourceLanguageDTO"),
//        @JsonSubTypes.Type(value = SanchayAnnotationLevelDTO.class, name = "SanchayAnnotationLevelDTO"),
//})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanchayDTO {
//    public abstract SanchaySlimDTO getSlimDTO();
//
//    public abstract void setSlimDTO(SanchaySlimDTO slimDTO);

    public SanchaySlimDTO getSlimDTO() {
        return slimDTO;
    }

    public void setSlimDTO(SanchaySlimDTO slimDTO) {
        this.slimDTO = slimDTO;
    }

    protected SanchaySlimDTO slimDTO;
}
