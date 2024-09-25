package org.SchoolApp.Datas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@ToString
@Table(name = "competences") // Renommage de la table
public class CompetencesEntity extends EntityAbstract {

    @Column(unique = true, nullable = false)
    private String nom;

    private String description;
    private int duree_acquisition;
    private String type;

    @ManyToOne
    @JoinColumn(name = "type_competence_id", nullable = false) // Relation avec TypeCompetenceEntity
    private TypeCompetenceEntity typeCompetence;

    @ManyToMany(mappedBy = "competences")
    @JsonIgnore
    private List<ReferentielEntity> referentiels;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "competence_module",
            joinColumns = @JoinColumn(name = "competence_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id"))
    @JsonIgnore
    @ToString.Exclude
    private List<ModulesEntity> modules;
}
