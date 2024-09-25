package org.SchoolApp.Datas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.SchoolApp.Datas.Enums.EtatEnum;
import org.hibernate.annotations.Where;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "promo_entity") // Renommage de la table
@ToString
@EqualsAndHashCode(callSuper = true) // Utilisation de l'égalité basée sur la superclasse
public class PromoEntity extends EntityAbstract {

    @Column(nullable = false, unique = true)
    private String libelle;

    private Date date_debut;
    private Date date_fin;
    private int duree;

    @Enumerated(EnumType.STRING)
    private EtatEnum etat;

    @ManyToMany
    @JsonManagedReference
    @JsonIgnore
    @JoinTable(
            name = "promotion_referentiel",
            joinColumns = @JoinColumn(name = "promotion_id"),
            inverseJoinColumns = @JoinColumn(name = "referentiel_id")
    )
    @Where(clause = "deleted = false")
    private Set<ReferentielEntity> referentiels = new HashSet<>();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PromoEntity other = (PromoEntity) obj;
        return super.equals(obj); // Repose sur l'égalité de l'id dans EntityAbstract
    }

    @Override
    public int hashCode() {
        return super.hashCode(); // Utilise le hashCode de EntityAbstract basé sur l'id
    }
}
