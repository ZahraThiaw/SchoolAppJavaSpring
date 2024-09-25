package org.SchoolApp.Datas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Data
@Entity
@ToString
@Table(name = "role_entity")
@EqualsAndHashCode(callSuper = true) // Utilise equals/hashCode de EntityAbstract
public class Role extends EntityAbstract {

    private String libelle;

    @OneToMany(mappedBy = "role")
    private Set<UserEntity> users;
}
