package org.SchoolApp.Web.Dtos.Mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.SchoolApp.Datas.Entity.CompetencesEntity;
import org.SchoolApp.Web.Dtos.Request.CompetenceRequest;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-26T09:20:03+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Ubuntu)"
)
@Component
public class CompetenceMapperImpl implements CompetenceMapper {

    @Override
    public CompetenceRequest toDto(CompetencesEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CompetenceRequest competenceRequest = new CompetenceRequest();

        return competenceRequest;
    }

    @Override
    public CompetencesEntity toEntity(CompetenceRequest dto) {
        if ( dto == null ) {
            return null;
        }

        CompetencesEntity competencesEntity = new CompetencesEntity();

        return competencesEntity;
    }

    @Override
    public List<CompetenceRequest> toDtos(List<CompetencesEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CompetenceRequest> list = new ArrayList<CompetenceRequest>( entities.size() );
        for ( CompetencesEntity competencesEntity : entities ) {
            list.add( toDto( competencesEntity ) );
        }

        return list;
    }

    @Override
    public List<CompetencesEntity> toEntities(List<CompetenceRequest> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<CompetencesEntity> list = new ArrayList<CompetencesEntity>( dtos.size() );
        for ( CompetenceRequest competenceRequest : dtos ) {
            list.add( toEntity( competenceRequest ) );
        }

        return list;
    }
}
