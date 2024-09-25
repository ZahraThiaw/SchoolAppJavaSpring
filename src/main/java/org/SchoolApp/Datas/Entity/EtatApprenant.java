package org.SchoolApp.Datas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "etat_apprenants") // Renommage de la table
public class EtatApprenant extends EntityAbstract {

    @Column(unique = true, nullable = false)
    private String etat;

    @Column(nullable = false)
    private String motif;

    @OneToMany(mappedBy = "etatApprenant")
    @JsonIgnore
    private List<ApprenantEntity> apprenants;
}
