package org.SchoolApp.Web.Dtos.Mapper;

import javax.annotation.processing.Generated;
import org.SchoolApp.Datas.Entity.ApprenantEntity;
import org.SchoolApp.Web.Dtos.Request.ApprenantRequestDto;
import org.SchoolApp.Web.Dtos.Response.ApprenantResponseDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-26T08:14:29+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Ubuntu)"
)
@Component
public class ApprenantMapperImpl implements ApprenantMapper {

    @Override
    public ApprenantEntity toEntity(ApprenantRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        ApprenantEntity apprenantEntity = new ApprenantEntity();

        return apprenantEntity;
    }

    @Override
    public ApprenantResponseDto toDto(ApprenantEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ApprenantResponseDto apprenantResponseDto = new ApprenantResponseDto();

        return apprenantResponseDto;
    }
}
