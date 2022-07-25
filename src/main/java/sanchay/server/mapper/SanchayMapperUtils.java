package sanchay.server.mapper;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import org.modelmapper.ModelMapper;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.stream.Collectors;
import org.modelmapper.convention.MatchingStrategies;
import sanchay.server.dto.auth.model.domain.*;

public class SanchayMapperUtils {
    // Only for SanchayServer authentication classes
    // P is the parent class of the destination class
    interface IMapToOriginalJPADestinationObject<S, D, P, Class> {
        D map(S source, D originalJPADestinationObject,
              P originalParentJPADestinationObject, Class targetClass);
    }

    // Only for SanchayServer authentication classes
//    public static <S, D, P> Map<String, D> covertMap(Map<String, S> sourceMap, Class<D> targetClass,
//              IMapToOriginalJPADestinationObject<S, D, P, Class> upMapperRef, ModelMapper modelMapper) {
    public static <S, T> Map<String, T> convertMap(Map<String, S> sourceMap, Class<T> targetClass,
            ModelMapper modelMapper) {
        return sourceMap
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry) -> entry.getKey(),
                        (entry) ->
                        {
//                            SanchaySlimDTO slimDTO = (SanchaySlimDTO) modelMapper.map(entry.getValue(), targetClass);
//                            SanchayDTO dto = (SanchayDTO) entry.getValue();

//                            Class slimDTOClass = slimDTO.getClass();

//                            dto.setSlimDTO(slimDTO);
//                            dto.setSlimDTO(slimDTOClass.cast(slimDTO));

//                            return (T) slimDTO;
                            return modelMapper.map(entry.getValue(), targetClass);
                        }
                ));
    }
    public static ObjectMapper getPlainObjectMapperInstance() {
        ObjectMapper mapper = new ObjectMapper();

        return mapper;
    }

    public static ObjectMapper getPolymorphicObjectMapperInstance() {
        ObjectMapper mapper = new ObjectMapper();

        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                .allowIfSubType("sanchay.server.dto.auth.model.domain")
//                .allowIfSubType("java.util.ArrayList")
                .allowIfBaseType(SanchayDTO.class)
                .allowIfBaseType(SanchaySlimDTO.class)
                .allowIfSubType(SanchayUserDTO.class)
                .allowIfSubType(SanchayRoleDTO.class)
                .allowIfSubType(SanchayOrganisationDTO.class)
                .allowIfSubType(SanchayResourceLanguageDTO.class)
                .allowIfSubType(SanchayAnnotationLevelDTO.class)
                .allowIfSubType(SanchayUserSlimDTO.class)
                .allowIfSubType(SanchayRoleSlimDTO.class)
                .allowIfSubType(SanchayOrganisationSlimDTO.class)
                .allowIfSubType(SanchayResourceLanguageSlimDTO.class)
                .allowIfSubType(SanchayAnnotationLevelSlimDTO.class)
                .allowIfSubType(LinkedHashMap.class)
                .allowIfSubType(LinkedHashSet.class)
                .allowIfSubTypeIsArray()
                .allowIfBaseType(SanchayAnnotationManagementUpdateInfo.class)
                .allowIfSubType(SanchayAnnotationManagementUpdateInfo.class)
                .build();

//        mapper.activateDefaultTyping(PolymorphicTypeValidator ptv,
//                ObjectMapper.DefaultTyping applicability, JsonTypeInfo.As includeAs)

        mapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.WRAPPER_ARRAY);

        return mapper;
    }

    public static ModelMapper getPlainModelMapperInstance() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    public static SanchayModelMapper getModelMapperInstance()
    {
        SanchayModelMapper modelMapper = new SanchayModelMapper();
        
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);        

        new SanchayUserToSanchayUserDTOMap(modelMapper);
        new SanchayUserDTOToSanchayUserSlimDTOMap(modelMapper);
        new SanchayUserToSanchayUserSlimDTOMap(modelMapper);

        new SanchayRoleToSanchayRoleDTOMap(modelMapper);
        new SanchayRoleDTOToSanchayRoleSlimDTOMap(modelMapper);
        new SanchayRoleToSanchayRoleSlimDTOMap(modelMapper);

        new SanchayOrganisationToSanchayOrganisationDTOMap(modelMapper);
        new SanchayOrganisationDTOToSanchayOrganisationSlimDTOMap(modelMapper);
        new SanchayOrganisationToSanchayOrganisationDTOMap(modelMapper);

        new SanchayLanguageToSanchayLanguageDTOMap(modelMapper);
        new SanchayLanguageDTOToSanchayLanguageSlimDTOMap(modelMapper);
        new SanchayLanguageToSanchayLanguageDTOMap(modelMapper);

        new SanchayALevelToSanchayALevelDTOMap(modelMapper);
        new SanchayALevelDTOToSanchayALevelSlimDTOMap(modelMapper);
        new SanchayALevelToSanchayALevelDTOMap(modelMapper);

        return modelMapper;
    }
}
