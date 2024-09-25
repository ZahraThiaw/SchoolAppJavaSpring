package org.SchoolApp.Datas.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@ToString
@Table(name = "fonctions") // Renommage de la table
public class Fonction extends EntityAbstract {

    private String libelle;
    private String description;

    @OneToMany(mappedBy = "fonction")
    @ToString.Exclude
    private List<UserEntity> users;
}
