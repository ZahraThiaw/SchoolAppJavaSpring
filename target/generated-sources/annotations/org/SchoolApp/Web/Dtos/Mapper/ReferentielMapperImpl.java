package org.SchoolApp.Web.Dtos.Mapper;

import javax.annotation.processing.Generated;
import org.SchoolApp.Datas.Entity.ReferentielEntity;
import org.SchoolApp.Web.Dtos.Request.ReferentielRequestDto;
import org.SchoolApp.Web.Dtos.Request.ReferentielUpdateRequestDto;
import org.SchoolApp.Web.Dtos.Response.ReferentielResponseDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-26T01:13:29+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
@Component
public class ReferentielMapperImpl implements ReferentielMapper {

    @Override
    public ReferentielEntity toEntity(ReferentielRequestDto referentielRequestDto) {
        if ( referentielRequestDto == null ) {
            return null;
        }

        ReferentielEntity referentielEntity = new ReferentielEntity();

        return referentielEntity;
    }

    @Override
    public ReferentielResponseDto toDto(ReferentielEntity referentielEntity) {
        if ( referentielEntity == null ) {
            return null;
        }

        ReferentielResponseDto referentielResponseDto = new ReferentielResponseDto();

        return referentielResponseDto;
    }

    @Override
    public ReferentielEntity toEntity(ReferentielUpdateRequestDto referentielUpdateRequestDto) {
        if ( referentielUpdateRequestDto == null ) {
            return null;
        }

        ReferentielEntity referentielEntity = new ReferentielEntity();

        return referentielEntity;
    }
}
