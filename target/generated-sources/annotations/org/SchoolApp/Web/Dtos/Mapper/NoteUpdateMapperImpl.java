package org.SchoolApp.Web.Dtos.Mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.SchoolApp.Datas.Entity.NotesEntity;
import org.SchoolApp.Web.Dtos.Request.NoteUpdate;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-26T09:06:31+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Ubuntu)"
)
@Component
public class NoteUpdateMapperImpl implements NoteUpdateMapper {

    @Override
    public NoteUpdate toDto(NotesEntity entity) {
        if ( entity == null ) {
            return null;
        }

        NoteUpdate noteUpdate = new NoteUpdate();

        return noteUpdate;
    }

    @Override
    public NotesEntity toEntity(NoteUpdate dto) {
        if ( dto == null ) {
            return null;
        }

        NotesEntity notesEntity = new NotesEntity();

        return notesEntity;
    }

    @Override
    public List<NoteUpdate> toDtoList(List<NotesEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<NoteUpdate> list = new ArrayList<NoteUpdate>( entities.size() );
        for ( NotesEntity notesEntity : entities ) {
            list.add( toDto( notesEntity ) );
        }

        return list;
    }

    @Override
    public List<NotesEntity> toEntityList(List<NoteUpdate> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<NotesEntity> list = new ArrayList<NotesEntity>( dtos.size() );
        for ( NoteUpdate noteUpdate : dtos ) {
            list.add( toEntity( noteUpdate ) );
        }

        return list;
    }

    @Override
    public NotesEntity updateEntityFromDto(NoteUpdate dto, NotesEntity entity) {
        if ( dto == null ) {
            return entity;
        }

        return entity;
    }
}
