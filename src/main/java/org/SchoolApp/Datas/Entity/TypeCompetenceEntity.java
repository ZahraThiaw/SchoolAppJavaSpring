package org.SchoolApp.Datas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@ToString
@Table(name = "type_competences") // Renommage de la table
public class TypeCompetenceEntity extends EntityAbstract {

    @Column(unique = true, nullable = false)
    private String nom;

    private String description;

    @OneToMany(mappedBy = "typeCompetence", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CompetencesEntity> competences;
}
