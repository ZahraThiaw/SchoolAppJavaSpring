package org.SchoolApp.Datas.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "notes") // Renommage de la table
public class NotesEntity extends EntityAbstract {

    private float note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", nullable = false)
    @JsonIgnore
    @ToString.Exclude
    private ModulesEntity module;

    @ManyToOne
    @JoinColumn(name = "apprenant_id", nullable = false)
    @JsonManagedReference
    private ApprenantEntity apprenant;
}
