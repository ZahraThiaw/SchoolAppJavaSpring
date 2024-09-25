package org.SchoolApp.Web.Dtos.Mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.SchoolApp.Datas.Entity.ModulesEntity;
import org.SchoolApp.Web.Dtos.Request.ModuleRequest;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-25T20:37:25+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Ubuntu)"
)
@Component
public class ModuleMappperImpl implements ModuleMappper {

    @Override
    public ModuleRequest toDto(ModulesEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ModuleRequest moduleRequest = new ModuleRequest();

        return moduleRequest;
    }

    @Override
    public ModulesEntity toEntity(ModuleRequest dto) {
        if ( dto == null ) {
            return null;
        }

        ModulesEntity modulesEntity = new ModulesEntity();

        return modulesEntity;
    }

    @Override
    public List<ModuleRequest> toDtos(List<ModulesEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ModuleRequest> list = new ArrayList<ModuleRequest>( entities.size() );
        for ( ModulesEntity modulesEntity : entities ) {
            list.add( toDto( modulesEntity ) );
        }

        return list;
    }

    @Override
    public List<ModulesEntity> toEntities(List<ModuleRequest> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<ModulesEntity> list = new ArrayList<ModulesEntity>( dtos.size() );
        for ( ModuleRequest moduleRequest : dtos ) {
            list.add( toEntity( moduleRequest ) );
        }

        return list;
    }
}
