package org.SchoolApp.Web.Dtos.Response;

import lombok.Data;
import org.SchoolApp.Datas.Entity.Role;

@Data
public class UserResponseDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String photo;
    private String adresse;
    private String role;
    private boolean deleted;
}
