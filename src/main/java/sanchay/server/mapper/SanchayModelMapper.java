package sanchay.server.mapper;

import org.modelmapper.ModelMapper;

public class SanchayModelMapper extends ModelMapper {
//public class SanchayModelMapper<S,D,P> extends ModelMapper {

//    private SanchayMapperUtil.IMapToOriginalJPADestinationObject<S, T, P, Class> upMapper;

//    public <D> D map(S source, Class<D> destinationType,
//                 D originalJPADestinationObject, P originalParentJPADestinationObject,
//                 SanchayMapperUtils.IMapToOriginalJPADestinationObject<S, D, P, Class> upMapper) {
//
//        D destination = super.map(source, destinationType);
//
//        destination = upMapper.map(source, originalJPADestinationObject, originalParentJPADestinationObject, destinationType);
//        return destination;
//    }

    @Override
    public <D> D map(Object source, Class<D> destinationType) {
        Object tmpSource = source;
//        if(source == null){
//            tmpSource = new Object();
//        }

        return super.map(tmpSource, destinationType);
    }
}
