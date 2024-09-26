package org.SchoolApp.Web.Dtos.Mapper;

import javax.annotation.processing.Generated;
import org.SchoolApp.Datas.Entity.NotesEntity;
import org.SchoolApp.Web.Dtos.Request.NoteRequest;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-26T08:14:29+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Ubuntu)"
)
@Component
public class NoteRequestMapperImpl extends NoteRequestMapper {

    @Override
    public NotesEntity toEntity(NoteRequest noteRequest) {
        if ( noteRequest == null ) {
            return null;
        }

        NotesEntity notesEntity = new NotesEntity();

        return notesEntity;
    }
}
