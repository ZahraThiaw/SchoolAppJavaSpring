package org.SchoolApp.Web.Dtos.Response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;


@Data
public class NoteResponseDto {
    private Long id;
    private float note;
    private Long apprenant;
    private Long module;
}
