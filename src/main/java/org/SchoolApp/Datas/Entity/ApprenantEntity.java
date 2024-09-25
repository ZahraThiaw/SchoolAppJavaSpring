package org.SchoolApp.Datas.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@ToString
@Table(name = "apprenants") // Renommage de la table
public class ApprenantEntity extends EntityAbstract {

    private String nomTuteur;
    private String prenomTuteur;
    private String contactTuteur;
    private String cniFile;
    private String extraitFile;
    private String diplomeFile;
    private String casierFile;
    private String photoCouverture;

    @Column(unique = true)
    private String matricule;

    private String qrCodeLink;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    @ToString.Exclude
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etat_id")
    @JsonIgnore
    @ToString.Exclude
    private EtatApprenant etatApprenant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "referentiel_id", nullable = false)
    @JsonIgnore
    @ToString.Exclude
    private ReferentielEntity referentiel;

    @OneToMany(mappedBy = "apprenant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    private List<NotesEntity> notes;
}
