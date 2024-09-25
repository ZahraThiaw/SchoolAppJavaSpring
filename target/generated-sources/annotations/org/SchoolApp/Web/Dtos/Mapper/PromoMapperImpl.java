package org.SchoolApp.Web.Dtos.Mapper;

import javax.annotation.processing.Generated;
import org.SchoolApp.Datas.Entity.PromoEntity;
import org.SchoolApp.Web.Dtos.Request.PromoRequestDto;
import org.SchoolApp.Web.Dtos.Response.PromoResponseDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-25T20:37:25+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Ubuntu)"
)
@Component
public class PromoMapperImpl implements PromoMapper {

    @Override
    public PromoEntity toEntity(PromoRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        PromoEntity promoEntity = new PromoEntity();

        return promoEntity;
    }

    @Override
    public PromoResponseDto toDto(PromoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        PromoResponseDto promoResponseDto = new PromoResponseDto();

        return promoResponseDto;
    }
}
