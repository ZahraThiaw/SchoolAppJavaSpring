package org.SchoolApp.Datas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "emargements") // Renommage de la table
public class EmargementEntity extends EntityAbstract {

    private LocalDate date;
    private LocalTime entree;
    private LocalTime sortie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserEntity user;
}
