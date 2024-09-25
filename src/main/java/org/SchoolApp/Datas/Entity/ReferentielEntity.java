package org.SchoolApp.Datas.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.SchoolApp.Datas.Enums.StatusReferenceEnum;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "referentiel_entity")
@ToString
@EqualsAndHashCode(callSuper = true) // Utilisation de l'égalité basée sur la superclasse
public class ReferentielEntity extends EntityAbstract {

    @Column(unique = true, nullable = false)
    private String libelle;

    @Column(nullable = false, unique = true)
    private String code;

    private String description;

    private String photoCouverture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusReferenceEnum status = StatusReferenceEnum.Inactif; // Valeur par défaut

    @ManyToMany(mappedBy = "referentiels", fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<PromoEntity> promos = new HashSet<>();

    @OneToMany(mappedBy = "referentiel")
    @JsonIgnore
    private Set<ApprenantEntity> apprenants;

    @ManyToMany
    @JoinTable(
            name = "referentiel_competence",
            joinColumns = @JoinColumn(name = "referentiel_id"),
            inverseJoinColumns = @JoinColumn(name = "competence_id")
    )
    @JsonIgnore
    private Set<CompetencesEntity> competences = new HashSet<>();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ReferentielEntity other = (ReferentielEntity) obj;
        return super.equals(obj); // Repose sur l'égalité de l'id dans EntityAbstract
    }

    @Override
    public int hashCode() {
        return super.hashCode(); // Utilise le hashCode de EntityAbstract basé sur l'id
    }
}
